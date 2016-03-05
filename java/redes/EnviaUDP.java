package br.com.ahe.redes;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
class EnviaUDP {
	public static void main(String args[]) throws IOException {
		// Coloca os dados em um buffer
		String buf = "Mensagem de teste!";
		byte[] s = new byte[buf.length()];
		s = buf.getBytes();
		// Prepara um pacote com o buffer e as informa��es do destinat�rio
		InetAddress ip = InetAddress.getByName("localhost");
		DatagramPacket pack = new DatagramPacket(s, s.length, ip, 8000);
		// Cria um socket UDP e envia o pacote para localhost:8000
		DatagramSocket socket = new DatagramSocket();
		socket.send(pack);
		// Encerra o socket
		socket.close();
	}
}
