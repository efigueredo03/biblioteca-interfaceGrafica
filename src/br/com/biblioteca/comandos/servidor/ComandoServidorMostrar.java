package br.com.biblioteca.comandos.servidor;

import java.io.IOException;
import java.io.ObjectOutputStream;

import br.com.biblioteca.bancoDeDados.BancoDeDados;
import br.com.biblioteca.comandos.Comando;
import br.com.biblioteca.pacote.Pacote;
import br.com.biblioteca.pacote.PacoteParaCliente;
import br.com.biblioteca.pacote.PacoteParaServidor;

public class ComandoServidorMostrar extends ComandoServidor {

	public ComandoServidorMostrar(BancoDeDados db, ObjectOutputStream saida, Comando proximo) {
		super(db, saida, proximo);
	}

	@Override
	protected void executarComando(Pacote pacote) throws IOException {
		PacoteParaServidor pacoteCast = (PacoteParaServidor) pacote;
		PacoteParaCliente pacoteParaCliente = new PacoteParaCliente(true, null, db.retornarArmazenamento(pacoteCast.getTipo()));
		super.saida.writeObject(pacoteParaCliente);
	}

	@Override
	protected boolean condicaoParaExecucao(Pacote pacote) {
		PacoteParaServidor pacoteCast = (PacoteParaServidor) pacote;
		return pacoteCast.getComando() == ComandoServidorEnums.MOSTRAR;
	}
	


}
