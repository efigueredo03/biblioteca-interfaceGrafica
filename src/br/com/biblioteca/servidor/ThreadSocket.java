package br.com.biblioteca.servidor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import br.com.biblioteca.bancoDeDados.BancoDeDados;
import br.com.biblioteca.comandos.servidor.ComandoServidor;
import br.com.biblioteca.comandos.servidor.ComandoServidorAdicionar;
import br.com.biblioteca.comandos.servidor.ComandoServidorMostrar;
import br.com.biblioteca.comandos.servidor.ComandoServidorRemover;
import br.com.biblioteca.comandos.servidor.ComandoServidorVerificar;
import br.com.biblioteca.comandos.servidor.SemComandoServidor;
import br.com.biblioteca.pacote.PacoteParaServidor;

public class ThreadSocket extends Thread {

	private Socket cliente;
	private BancoDeDados db;
	private ObjectInputStream entradaPacotes;
	private ObjectOutputStream saidaPacotes;
	
	public ThreadSocket(Socket cliente, BancoDeDados db) throws IOException {
		this.cliente = cliente;
		this.db = db;
		this.entradaPacotes = new ObjectInputStream(this.cliente.getInputStream());
		this.saidaPacotes = new ObjectOutputStream(this.cliente.getOutputStream());
	}
	
	public void run() {
		try {
			PacoteParaServidor pacote = (PacoteParaServidor) entradaPacotes.readObject();
			executarComando(pacote);	
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private void executarComando(PacoteParaServidor pacote) throws IOException {
		ComandoServidor cadeiaDeComandos = new ComandoServidorAdicionar(db, saidaPacotes,
				new ComandoServidorRemover(db, saidaPacotes, 
						new ComandoServidorVerificar(db, saidaPacotes, 
								new ComandoServidorMostrar(db, saidaPacotes, 
										new SemComandoServidor()))));
		
		cadeiaDeComandos.verificarComando(pacote);
	}
	
}
