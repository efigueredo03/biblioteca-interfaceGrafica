package br.com.biblioteca.comandos.servidor;

import java.io.IOException;

import br.com.biblioteca.pacote.Pacote;

public class SemComandoServidor extends ComandoServidor {

	public SemComandoServidor() {
		super(null, null, null);
	}

	@Override
	protected void executarComando(Pacote pacote) throws IOException {
			
	}

	@Override
	protected boolean condicaoParaExecucao(Pacote pacote) {
		return true;
	}

}
