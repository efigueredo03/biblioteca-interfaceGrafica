package br.com.biblioteca.entiade.usuario;

import javafx.scene.image.Image;

public abstract class UsuarioFisico extends Usuario {

	private static final long serialVersionUID = 1L;
	private String email;
	
	public UsuarioFisico(String cpf, String senha, String nome, String sobrenome, String email, String sexo, Image avatar, TipoUsuario tipo) {
		super(cpf, senha, nome, sobrenome, sexo, avatar, tipo);
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
}
