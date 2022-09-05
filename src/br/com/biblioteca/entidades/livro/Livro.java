package br.com.biblioteca.entidades.livro;

import br.com.biblioteca.entidades.Entidade;

public class Livro extends Entidade {
	
	private String titulo;
	private String autor;
	private String data;
	private long id;

	public Livro(String titulo, String autor, String data, int id, TipoLivro tipo) {
		super(tipo);
		this.titulo = titulo;
		this.autor = autor;
		this.data = data;
		this.id = id;
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
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
