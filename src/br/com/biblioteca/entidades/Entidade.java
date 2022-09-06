package br.com.biblioteca.entidades;

import java.io.Serializable;

public abstract class Entidade implements Serializable {

	private static final long serialVersionUID = 1L;
	private Tipo tipo;
	private String id;
	
	public Entidade(Tipo tipo, String id) {
		this.tipo = tipo;
		this.id = id;
	}
	
	public Tipo getTipo() {
		return tipo;
	}
	
	public String getId() {
		return id;
	}
	
	public boolean equals(Entidade entidade) {
		return this.id.equals(entidade.getId());
	}
	
}
