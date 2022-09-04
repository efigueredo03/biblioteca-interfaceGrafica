package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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
		System.out.println("entrar");
	}
	// Event Listener on Button[#bt_cadastrar].onAction
	@FXML
	public void botaoCadatrarPressionado(ActionEvent event) {
		System.out.println("logar");
	}
}
