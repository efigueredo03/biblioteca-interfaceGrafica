package br.com.biblioteca.pacote;

import java.io.Serializable;

import br.com.biblioteca.comandos.servidor.ComandoServidorEnums;
import br.com.biblioteca.entidades.Entidade;
import br.com.biblioteca.entidades.Tipo;

public class PacoteParaServidor implements Pacote, Serializable {

	private static final long serialVersionUID = 1L;
	private Entidade entidade;
	private ComandoServidorEnums comando;
	private Tipo tipo;
	
	public PacoteParaServidor(Entidade entidade, ComandoServidorEnums comando, Tipo tipo) {
		this.comando = comando;
		this.entidade = entidade;
		this.tipo = tipo;
	}
	
	public Entidade getEntidade() {
		return entidade;
	}
	
	public ComandoServidorEnums getComando() {
		return comando;
	}
	
	public Tipo getTipo() {
		return tipo;
	}
	
}
