package br.com.biblioteca.entiade.usuario;

import javafx.scene.image.Image;

public class Administrador extends Usuario {

	private static final long serialVersionUID = 1L;

	public Administrador(String cpf, String senha, String nome, String sobrenome, String sexo, Image avatar, TipoUsuario tipo) {
		super(cpf, senha, nome, sobrenome, sexo, avatar, tipo);
	}

}
