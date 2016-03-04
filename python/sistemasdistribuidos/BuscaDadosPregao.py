import ast
import time
import datetime
import web
import urllib2
from xml.etree.ElementTree import Element, SubElement
import xml.etree.ElementTree as ET
from teste import prettify

urls = (
    '/pregao', 'busca_pregao',
    '/movimento/(.*)', 'busca_movimento',
    '/empresas/(.*)', 'busca_empresa',
    '/compra/(.*)', 'compra_acao'

)

app = web.application(urls, globals())

class busca_movimento:
    def GET(self, emp):
        response = urllib2.urlopen('http://www.bmfbovespa.com.br/Pregao-Online/ExecutaAcaoAjax.asp?CodigoPapel='+emp)
        tree = ET.parse(response)
        root = tree.getroot()
        xml = Element('movimentacao')
        for child in root:
            posCod = ET.tostring(child).find('Minimo="')+8
            posCodFim = ET.tostring(child).find('"', posCod)
            minimo = SubElement(xml, 'minimo');
            minimo.text = ET.tostring(child)[posCod:posCodFim].replace('"', '').replace(',', '.')
            posCod = ET.tostring(child).find('Maximo="')+8
            posCodFim = ET.tostring(child).find('"', posCod)
            maximo = SubElement(xml,'maximo')
            maximo.text = ET.tostring(child)[posCod:posCodFim].replace('"', '').replace(',', '.')
            posCod = ET.tostring(child).find('Ultimo="')+8
            posCodFim = ET.tostring(child).find('"', posCod)
            atual = SubElement(xml,'atual')
            atual.text = ET.tostring(child)[posCod:posCodFim].replace('"', '').replace(',', '.')
            posCod = ET.tostring(child).find('Oscilacao="')+11
            posCodFim = ET.tostring(child).find('"', posCod)
            atual = SubElement(xml,'oscilacao')
            atual.text = ET.tostring(child)[posCod:posCodFim].replace('"', '').replace(',', '.')
        return prettify(xml)


class compra_acao:
    def GET(self, dados):
        now = datetime.datetime.now()
        weekend = set([6, 7])
        retorno = Element('compra')
        aprovada = SubElement(retorno , 'aprovada')
        mensagem = SubElement(retorno, 'mensagem')
        splitados = dados.split('|')
        emp = splitados[0]
        vlr = float(splitados[1])
        qtd = splitados[2]
        if float(qtd).__mod__(100) == 0: #and now.hour >= 18:
            minimo , maximo = self.verifica_compra(emp)

            if vlr > float(minimo) and vlr > float(maximo):
                aprovada.text = 'Nao'
                mensagem.text = 'Valor Invalido!(Abaixo do minimo ' + str(minimo) + ' ou maior que o maximo ' + str(maximo) + ')'
            else:
                if now.isoweekday() not in weekend:
                    aprovada.text = 'Sim'
                    mensagem.text = 'Compra Aprovada'
                else:
                    aprovada.text = 'Pendente'
                    mensagem.text = "Pregao Fechado!"
        else:
            aprovada.text = 'Nao'
            mensagem.text = 'Qtd Invalida'
        return prettify(retorno);

    def verifica_compra(self,emp):
        response = urllib2.urlopen('http://www.bmfbovespa.com.br/Pregao-Online/ExecutaAcaoAjax.asp?CodigoPapel='+emp)
        tree = ET.parse(response)
        root = tree.getroot()
        for child in root:
            posCod = ET.tostring(child).find('Minimo="')+8
            posCodFim = ET.tostring(child).find('"', posCod)
            minimo = float(ET.tostring(child)[posCod:posCodFim].replace('"', '').replace(',', '.'))
            posCod = ET.tostring(child).find('Maximo="')+8
            posCodFim = ET.tostring(child).find('"', posCod)
            maximo = float(ET.tostring(child)[posCod:posCodFim].replace('"', '').replace(',', '.'))
        return minimo, maximo


class busca_empresa:
    def GET(self, empresas):
        response = urllib2.urlopen('http://www.bmfbovespa.com.br/Pregao-Online/ExecutaAcaoAjax.asp?CodigoPapel='+empresas)
        tree = ET.parse(response);
        root = tree.getroot();
        xml = Element('list')
        for child in root:
            empresa = SubElement(xml, 'empresa')
            posCod = ET.tostring(child).find('Codigo')
            posCodFim = posCod + 15
            sigla = SubElement(empresa, 'sigla')
            sigla.text = ET.tostring(child)[posCod:posCodFim].split('=')[1].replace('"', '')
            posCod = ET.tostring(child).find('Nome="')+6
            posCodFim = ET.tostring(child).find('"',posCod);
            nome = SubElement(empresa, 'nome')
            nome.text = ET.tostring(child)[posCod:posCodFim].replace('"', '')
        return prettify(xml)


class busca_pregao:
    def GET(self):
        response = urllib2.urlopen('http://www.bmfbovespa.com.br/Pregao-OnLine/ExecutaAcaoCarregarDados.asp?CodDado=Ticker')
        html = response.read()
        xml = Element('list')
        retorno_consulta = html.split('|')
        for retorno in retorno_consulta:
            emp = SubElement(xml,'empresa')
            empresa = retorno.split('@')
            vs = SubElement(emp , 'sigla')
            vs.text = empresa[0].replace('v=', '')
        return prettify(xml)

if __name__ == "__main__":
    app.run()
