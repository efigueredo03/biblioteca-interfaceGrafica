package br.com.biblioteca.servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import br.com.biblioteca.bancoDeDados.BancoDeDados;

public class Servidor {
	
	private ArrayList<ThreadSocket> listaDeClientes;
	private BancoDeDados db;

	public Servidor() {
		this.listaDeClientes = new ArrayList<ThreadSocket>();
		this.db = new BancoDeDados();
	}
	
	public void rodarServidor() throws IOException {
		ServerSocket servidor = new ServerSocket(10000);
		System.out.println("Esperando conexões");
		while(true) {
			Socket cliente = servidor.accept();
			System.out.println(String.format("Cliente %s conectado", cliente.getInetAddress().getHostAddress()));
			ThreadSocket thread = new ThreadSocket(cliente);
			listaDeClientes.add(thread, db);
			thread.start();
		}
	}
	
}
