package br.com.ahe.sd.trabalho.webservice;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Objects;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import br.com.ahe.sd.trabalho.corba.Empresa;

/**
 * Created by aheggert on 24/06/14.
 */
public class WebserviceUtils {

    public static final String IP_WS = "http://localhost:8080/";

    private static WebserviceUtils thisz;

    public static WebserviceUtils get() {
        if(Objects.isNull(thisz)) {
            thisz = new WebserviceUtils();
        }
        return thisz;
    }

    @SuppressWarnings( "unchecked" )
    private List<EmpresaXML> leXmlEmpresas(InputStream inputStream) {
        XStream stream = new XStream(new DomDriver());
        stream.alias("empresa", EmpresaXML.class);
        return (List<EmpresaXML>) stream.fromXML(inputStream);
    }

    private CompraXML leXmlCompra(InputStream inputStream) {
        XStream stream = new XStream(new DomDriver());
        stream.alias("compra", CompraXML.class);
        return (CompraXML) stream.fromXML(inputStream);
    }

    private MovimentacaoXML leXmlMovimentacao(InputStream inputStream) {
        XStream stream = new XStream(new DomDriver());
        stream.alias("movimentacao", MovimentacaoXML.class);
        return (MovimentacaoXML) stream.fromXML(inputStream);
    }

    public Empresa getEmpresaWS(String siglaEmpresa) {
        HttpURLConnection con = null;
        try {
            Empresa emp = new Empresa();
            emp.sigla = siglaEmpresa;
            URL url = new URL(IP_WS + "empresas/" + emp.sigla);
            con = (HttpURLConnection) url.openConnection();
            InputStream content = con.getInputStream();
            EmpresaXML dados = leXmlEmpresas(content).get(0);
            emp.nome = dados.getNome();
            return emp;
        } catch (Exception e) {
//            e.printStackTrace();
            throw new IllegalArgumentException("Empresa não encontrada na base da BOVESPA");
        } finally {
            con.disconnect();
        }
    }

    public CompraXML comprarAcao(String sigla, String valor, String quantidade) {
        HttpURLConnection con = null;
        try {
            URL url = new URL(IP_WS + "compra/" + sigla + "|" + valor  + "|" +  quantidade);
            con = (HttpURLConnection) url.openConnection();
            InputStream content = con.getInputStream();
            return leXmlCompra(content);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException(e.getMessage());
        } catch (IOException e) {
            throw new IllegalArgumentException(e.getMessage());
        } finally {
            con.disconnect();
        }
    }

    public MovimentacaoXML movimentoAcao(String sigla) {
        HttpURLConnection con = null;
        try {
            URL url = new URL(IP_WS + "movimento/" + sigla);
            con = (HttpURLConnection) url.openConnection();
            InputStream content = con.getInputStream();
            return leXmlMovimentacao(content);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException(e.getMessage());
        } catch (IOException e) {
            throw new IllegalArgumentException(e.getMessage());
        } finally {
            con.disconnect();
        }
    }

    public static void main(String[] args) {
        WebserviceUtils ws = new WebserviceUtils();
        System.out.println(ws.movimentoAcao("ABEV3"));

    }
}
