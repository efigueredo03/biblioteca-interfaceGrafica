package br.com.biblioteca.bancoDeDados;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import br.com.biblioteca.entiade.usuario.TipoUsuario;
import br.com.biblioteca.entidades.Entidade;
import br.com.biblioteca.entidades.Tipo;
import br.com.biblioteca.entidades.livro.TipoLivro;

public class BancoDeDados {

	private Map<Tipo, ArrayList<Entidade>> armazenamento;
	
	public BancoDeDados() {
		this.armazenamento = new HashMap<Tipo, ArrayList<Entidade>>();
		this.armazenamento.put(TipoUsuario.ADMINISTRADOR, new ArrayList<Entidade>());
		this.armazenamento.put(TipoUsuario.FUNCIONARIO, new ArrayList<Entidade>());
		this.armazenamento.put(TipoUsuario.PESSOA, new ArrayList<Entidade>());
		
		this.armazenamento.put(TipoLivro.ROMANCE, new ArrayList<Entidade>());
		this.armazenamento.put(TipoLivro.TERROR, new ArrayList<Entidade>());
		this.armazenamento.put(TipoLivro.FANTASIA, new ArrayList<Entidade>());
		this.armazenamento.put(TipoLivro.AVENTURA, new ArrayList<Entidade>());
		this.armazenamento.put(TipoLivro.MEDIEVAL, new ArrayList<Entidade>());
		this.armazenamento.put(TipoLivro.HISTORIA, new ArrayList<Entidade>());
		this.armazenamento.put(TipoLivro.CONTO, new ArrayList<Entidade>());
		this.armazenamento.put(TipoLivro.FUTURISTA, new ArrayList<Entidade>());
		this.armazenamento.put(TipoLivro.FICÇAO_CIENTIFICA, new ArrayList<Entidade>());
		this.armazenamento.put(TipoLivro.DESENVOLVIMENTO_PESSOAL, new ArrayList<Entidade>());
		this.armazenamento.put(TipoLivro.POESIA, new ArrayList<Entidade>());
		this.armazenamento.put(TipoLivro.BIOGRAFICA, new ArrayList<Entidade>());
		this.armazenamento.put(TipoLivro.AUTOAJUDA, new ArrayList<Entidade>());
		this.armazenamento.put(TipoLivro.TEATRO, new ArrayList<Entidade>());
		this.armazenamento.put(TipoLivro.GRAMATICA, new ArrayList<Entidade>());
		this.armazenamento.put(TipoLivro.GEOGRAFICA, new ArrayList<Entidade>());
		this.armazenamento.put(TipoLivro.TECNOLOGIA, new ArrayList<Entidade>());
		this.armazenamento.put(TipoLivro.MATEMATICA, new ArrayList<Entidade>());
		this.armazenamento.put(TipoLivro.FISICA, new ArrayList<Entidade>());
		this.armazenamento.put(TipoLivro.QUIMICA, new ArrayList<Entidade>());
		this.armazenamento.put(TipoLivro.INGLES, new ArrayList<Entidade>());
	}	
	
	public boolean adicionarNoBancoDeDados(Entidade entidade) {
		ArrayList<Entidade> armazenamento = this.armazenamento.get(entidade.getTipo());
		for (Entidade entidadeArmazenamento : armazenamento) {
			if(entidadeArmazenamento.equals(entidade)) {
				return false;
			}
		}
		armazenamento.add(entidade);
		return true;
	}
	
}
