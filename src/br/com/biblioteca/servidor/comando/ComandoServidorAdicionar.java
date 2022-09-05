package br.com.biblioteca.servidor.comando;

public class ComandoServidorAdicionar {

	public boolean executarComando(PacoteParaServidor pacote) {
		return db.adicionarNoBancoDeDados(pacote.getEntidade());
	}
	
}
