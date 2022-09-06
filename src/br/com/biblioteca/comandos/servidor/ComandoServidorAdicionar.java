package br.com.biblioteca.comandos.servidor;

import java.io.IOException;
import java.io.ObjectOutputStream;

import br.com.biblioteca.bancoDeDados.BancoDeDados;
import br.com.biblioteca.comandos.Comando;
import br.com.biblioteca.pacote.Pacote;
import br.com.biblioteca.pacote.PacoteParaCliente;
import br.com.biblioteca.pacote.PacoteParaServidor;

public class ComandoServidorAdicionar extends ComandoServidor {
	
	

	public ComandoServidorAdicionar(BancoDeDados db, ObjectOutputStream saida, Comando proximo) {
		super(db, saida, proximo);
	}

	@Override
	public void executarComando(Pacote pacote) throws IOException {
		PacoteParaServidor pacoteCast = (PacoteParaServidor) pacote;
		PacoteParaCliente pacoteParaCliente;
		if (super.db.adicionarNoBancoDeDados(pacoteCast.getEntidade())) {
			pacoteParaCliente = new PacoteParaCliente(true, "Entidade adicionado ao sistema", null);
		} else {
			pacoteParaCliente = new PacoteParaCliente(false, "Entidade já existe no sistema", null);
		}
		super.saida.writeObject(pacoteParaCliente);
	}

	@Override
	protected boolean condicaoParaExecucao(Pacote pacote) {
		PacoteParaServidor pacoteCast = (PacoteParaServidor) pacote;
		return pacoteCast.getComando() == ComandoServidorEnums.ADICIONAR;
	}
	
}
