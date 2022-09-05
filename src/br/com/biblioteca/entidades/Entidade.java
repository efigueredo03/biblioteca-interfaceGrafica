package br.com.biblioteca.entidades;

public abstract class Entidade {

	private Tipo tipo;
	
	public Entidade(Tipo tipo) {
		this.tipo = tipo;
	}
	
	public Tipo getTipo() {
		return tipo;
	}
	
}
