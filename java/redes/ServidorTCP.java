package br.com.ahe.redes;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
class ServidorTCP {
	@SuppressWarnings("resource")
	public static void main(String args[]) throws IOException {
		// Cria um socket TCP para pedidos de conex�o na porta 8000
		ServerSocket listenSocket = new ServerSocket(8000);
		// Aguarda at� que um cliente pe�a por uma conex�o
		Socket sock = listenSocket.accept();
		// Prepara um buffer para receber dados de um cliente
		InputStreamReader s = new InputStreamReader(sock.getInputStream());
		BufferedReader rec = new BufferedReader(s);
		// L� os dados enviados pela aplica��o cliente
		String rBuf = rec.readLine();
		// Apresenta os dados recebidos
		InetAddress ip = sock.getInetAddress();
		int port = sock.getPort();
		System.out.println(ip + ":" + port + ": " + rBuf);
		// Coloca a resposta em um buffer e envia para o cliente
		DataOutputStream d = new DataOutputStream(sock.getOutputStream());
		String sBuf = "Ok!";
		d.writeBytes(sBuf + '\n');
		// Encerra a conex�o com o cliente
		sock.close();
	}
}
