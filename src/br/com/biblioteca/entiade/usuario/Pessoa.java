package br.com.biblioteca.entiade.usuario;

import javafx.scene.image.Image;

public class Pessoa extends UsuarioFisico {

	private static final long serialVersionUID = 1L;

	public Pessoa(String cpf, String senha, String nome, String sobrenome, String email, String sexo, Image avatar, TipoUsuario tipo) {
		super(cpf, senha, nome, sobrenome, email, sexo, avatar, tipo);
	}

}
