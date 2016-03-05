package br.com.ahe.redes;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
class ClienteTCP {
	public static void main(String args[]) throws UnknownHostException, IOException {
		// Cria um socket TCP para conex�o com localhost:8000
		Socket sock = new Socket("localhost", 8000);
		// Coloca os dados em um buffer e envia para o servidor
		DataOutputStream d = new DataOutputStream(sock.getOutputStream());
		String sBuf = "Mensagem de teste!";
		d.writeBytes(sBuf + '\n');
		// Prepara um buffer para receber a resposta do servidor
		InputStreamReader s = new InputStreamReader(sock.getInputStream());
		BufferedReader rec = new BufferedReader(s);
		// L� os dados enviados pela aplica��o servidora
		String rBuf = rec.readLine();
		// Apresenta a resposta recebida
		InetAddress ip = sock.getInetAddress();
		int port = sock.getPort();
		System.out.println(ip + ":" + port + ": " + rBuf);
		// Encerra a conex�o com o servidor
		sock.close();
	}
}
