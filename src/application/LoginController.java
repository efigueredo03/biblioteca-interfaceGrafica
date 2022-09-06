package application;

import java.io.IOException;

import br.com.biblioteca.entiade.usuario.TipoUsuario;
import br.com.biblioteca.entiade.usuario.UsuarioFisico;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;

public class LoginController {
	@FXML
	private TextField tf_usuario;
	@FXML
	private Button bt_entrar;
	@FXML
	private TextField tf_senha;
	@FXML
	private Button bt_cadastrar;
	@FXML
	private Label lb_status;

	// Event Listener on Button[#bt_entrar].onAction
	@FXML
	public void botaoEntrarPressionado(ActionEvent event) {
		this.logar();
	}
	// Event Listener on Button[#bt_cadastrar].onAction
	@FXML
	public void botaoCadatrarPressionado(ActionEvent event) throws IOException {
		this.abrirJanelaDeCadastro();
	}
	
	private void abrirJanelaDeCadastro() throws IOException {
		Main main = new Main();
		main.changeScene("FXMLCadastrar.fxml");
	}
	
	private void logar() {
		String usuario = this.tf_usuario.getText();
		String senha = this.tf_senha.getText();
		
		UsuarioFisico ObjetoUsuario = new UsuarioFisico(usuario, senha, null, null, null, null, null, null);
				
		
		if(this.verificarEntradaDeDados(ObjetoUsuario)) {
			return;
		}
		
		PacoteParaServidor pacote = new PacoteParaServidor()
		
	}
	
	private void trocarMensagemLabelInformacao(String mensagem) {
		this.lb_status.setText(mensagem);
	}
	
	private boolean verificarEntradaDeDados(UsuarioFisico usuario) {
		if (usuario.getId().length() == 0 && usuario.getSenha().length() == 0) {
			this.trocarMensagemLabelInformacao("Preencha todos os campos");
			return true;
		}
		return false;
	}
	
	private boolean verificarSeUsuarioExisteNoSistema() {
		
	}
	
}
