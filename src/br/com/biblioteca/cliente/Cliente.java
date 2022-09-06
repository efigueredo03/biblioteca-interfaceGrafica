package br.com.biblioteca.cliente;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import br.com.biblioteca.pacote.PacoteParaCliente;
import br.com.biblioteca.pacote.PacoteParaServidor;

public class Cliente {

	public PacoteParaCliente enviarPacoteAoServidor(PacoteParaServidor pacote) throws IOException, ClassNotFoundException {
		Socket socket = new Socket("10.55.105.133", 10000);
		ObjectOutputStream saidaPacotes = new ObjectOutputStream(socket.getOutputStream());
		saidaPacotes.writeObject(pacote);
		ObjectInputStream entradaPacotes = new ObjectInputStream(socket.getInputStream());
		PacoteParaCliente pacoteParaCliente = (PacoteParaCliente) entradaPacotes.readObject();
		socket.close();
		saidaPacotes.close();
		entradaPacotes.close();
		return pacoteParaCliente;
	}
		
}
