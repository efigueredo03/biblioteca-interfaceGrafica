package br.com.biblioteca.comandos.servidor;

import java.io.ObjectOutputStream;

import br.com.biblioteca.bancoDeDados.BancoDeDados;
import br.com.biblioteca.comandos.Comando;

public abstract class ComandoServidor extends Comando {
	
	public ComandoServidor(BancoDeDados db, ObjectOutputStream saida, Comando proximo) {
		super(db, saida, proximo);
	}
	
}
