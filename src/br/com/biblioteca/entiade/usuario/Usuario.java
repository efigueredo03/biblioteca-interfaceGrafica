package br.com.biblioteca.entiade.usuario;

import java.io.Serializable;

import br.com.biblioteca.entidades.Entidade;
import javafx.scene.image.Image;

public abstract class Usuario extends Entidade implements Serializable {

	private static final long serialVersionUID = 1L;
	private String senha;
	private String sexo;
	private String nome;
	private String sobrenome;
	private Image avatar;
	
	public Usuario(String cpf, String senha, String nome, String sobrenome, String sexo, Image avatar, TipoUsuario tipo) {
		super(tipo, cpf);
		this.senha = senha;
		this.nome = nome;
		this.sobrenome= sobrenome;
		this.sexo = sexo;
		this.avatar = avatar;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSobrenome() {
		return sobrenome;
	}
	
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	public String getSexo() {
		return sexo;
	}
	
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public Image getAvatar() {
		return avatar;
	}
	
	public void setAvatar(Image avatar) {
		this.avatar = avatar;
	}
	
}
