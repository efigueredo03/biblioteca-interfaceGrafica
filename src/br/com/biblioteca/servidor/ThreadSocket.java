package br.com.biblioteca.servidor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import br.com.biblioteca.bancoDeDados.BancoDeDados;
import br.com.biblioteca.pacote.PacoteParaServidor;
import br.com.biblioteca.servidor.comando.ComandoServidor;

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
			
			ComandoServidor comando = pacote.getComando();
			
			if(comando == ComandoServidor.ADICIONAR) {
				db.adicionarNoBancoDeDados(pacote.getEntidade());
			}
			
			if (comando == ComandoServidor.REMOVER) {
				db.removerDoBancoDeDados(pacote.getEntidade());
			}
			
			if (comando == ComandoServidor.MOSTRAR) {
				db.retornarArmazenamento(pacote.getTipo());
			}
			
			if (comando == ComandoServidor.VERIFICAR) {
				db.verificarSeEntidadeExiste(pacote.getEntidade(), db.retornarArmazenamento(pacote.getEntidade().getTipo()));
			}
			
			
			
			
			
		} catch (ClassNotFoundException | IOException e) {
			System.out.println("Deu merda");
		}
		
		
	}
	
}
