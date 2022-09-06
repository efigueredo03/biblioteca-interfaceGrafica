package br.com.biblioteca.comandos;

import java.io.IOException;
import java.io.ObjectOutputStream;

import br.com.biblioteca.bancoDeDados.BancoDeDados;
import br.com.biblioteca.pacote.Pacote;

public abstract class Comando {

	protected BancoDeDados db;
	protected ObjectOutputStream saida;
	private Comando proximo;
	
	public Comando(BancoDeDados db, ObjectOutputStream saida, Comando proximo) {
		this.db = db;
		this.saida = saida;
		this.proximo = proximo;
	}
	
	protected abstract void executarComando(Pacote pacote) throws IOException;
	protected abstract boolean condicaoParaExecucao(Pacote pacote);
	
	public boolean verificarComando(Pacote pacote) throws IOException {
		if (this.condicaoParaExecucao(pacote)) {
			this.executarComando(pacote);
			return true;
		}
		return proximo.verificarComando(pacote);
	}
	
}
