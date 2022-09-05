package br.com.biblioteca.entiade.usuario;

import javafx.scene.image.Image;

public class Funcionario extends UsuarioFisico {

	private static final long serialVersionUID = 1L;

	public Funcionario(String cpf, String senha, String nome, String sobrenome, String email, String sexo, Image avatar, TipoUsuario tipo) {
		super(cpf, senha, nome, sobrenome, email, sexo, avatar, tipo);
	}

}
