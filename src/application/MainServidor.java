package application;

import java.io.IOException;

import br.com.biblioteca.servidor.Servidor;

public class MainServidor {

	public static void main(String[] args) throws IOException {
		
		Servidor server = new Servidor();
		server.rodarServidor();
		
	}
	
}
