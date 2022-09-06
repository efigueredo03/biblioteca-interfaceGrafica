package br.com.biblioteca.entidades.livro;

import br.com.biblioteca.entidades.Entidade;

public class Livro extends Entidade {
	
	private static final long serialVersionUID = 1L;
	private String titulo;
	private String autor;
	private String data;

	public Livro(String titulo, String autor, String data, String id, TipoLivro tipo) {
		super(tipo, id);
		this.titulo = titulo;
		this.autor = autor;
		this.data = data;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}

}
