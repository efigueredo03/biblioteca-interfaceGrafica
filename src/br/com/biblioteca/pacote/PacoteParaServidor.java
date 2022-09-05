package br.com.biblioteca.pacote;

import br.com.biblioteca.entidades.Entidade;
import br.com.biblioteca.entidades.Tipo;
import br.com.biblioteca.servidor.comando.ComandoServidor;

public class PacoteParaServidor {

	private Entidade entidade;
	private ComandoServidor comando;
	private Tipo tipo;
	
	public PacoteParaServidor(Entidade entidade, ComandoServidor comando, Tipo tipo) {
		this.comando = comando;
		this.entidade = entidade;
		this.tipo = tipo;
	}
	
	public Entidade getEntidade() {
		return entidade;
	}
	
	public ComandoServidor getComando() {
		return comando;
	}
	
	public Tipo getTipo() {
		return tipo;
	}
	
}
