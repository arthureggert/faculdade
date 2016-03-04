import web
import xml.etree.ElementTree as ET
import urllib2

tree = ET.parse('cod_bolsa.xml')
root = tree.getroot()

urls = (
    '/users', 'list_users',
    '/users/(.*)', 'get_user'
)

app = web.application(urls, globals())

class list_users:
    def GET(self):
	output = 'users:[';
	for child in root:
                print 'child', child.tag, child.attrib
                output += str(child.attrib) + ','
	output += ']';

        response = urllib2.urlopen('http://www.bmfbovespa.com.br/Pregao-OnLine/ExecutaAcaoCarregarDados.asp?CodDado=Ticker')
        html = response.read()
        print(html)
        return output

class get_user:
    def GET(self, user):
	for child in root:
		if child.attrib['id'] == user:
		    return str(child.attrib)

if __name__ == "__main__":
    app.run()



class busca_emp():
    def GET(self, siglaEmp):
        response = urllib2.urlopen('http://www.bmfbovespa.com.br/Pregao-OnLine/ExecutaAcaoCarregarDados.asp?CodDado=Ticker')
        html = response.read()
        xml = Element('list')
        retorno_consulta = html.split('|')
        for retorno in retorno_consulta:
            empresa = retorno.split('@')
            tEmp = empresa[0].replace('v=', '')
            if tEmp == siglaEmp:
                emp = SubElement(xml,'empresa')
                vs = SubElement(emp , 'sigla')
                vs.text = tEmp
                valor_fechamento = empresa[1].replace('#', '').replace('*', '')
                max_string =  0
                if valor_fechamento[:1] == '-':
                    max_string = 6
                else:
                    max_string = 5
                vf = SubElement(emp,'fechamento')
                vf.text =valor_fechamento[:max_string]
        return prettify(xml)