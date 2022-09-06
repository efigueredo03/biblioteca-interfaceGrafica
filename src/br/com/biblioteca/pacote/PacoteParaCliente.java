package br.com.biblioteca.pacote;

import java.io.Serializable;
import java.util.ArrayList;

import br.com.biblioteca.entidades.Entidade;

public class PacoteParaCliente implements Pacote, Serializable{

	private static final long serialVersionUID = 1L;
	private boolean resultadoBoolean;
	private String resultadoString;
	private ArrayList<Entidade> armazenamento;
	
	public PacoteParaCliente(boolean resultadoBoolean, String resultadoString, ArrayList<Entidade> armazenamento) {
		this.resultadoString = resultadoString;
		this.resultadoBoolean = resultadoBoolean;
		this.armazenamento = armazenamento;
	}
	
	public String getResultadoString() {
		return resultadoString;
	}
	
	public boolean getResultadoBoolean() {
		return resultadoBoolean;
	}
	
	public ArrayList<Entidade> getArmazenamento() {
		return armazenamento;
	}
	
}
