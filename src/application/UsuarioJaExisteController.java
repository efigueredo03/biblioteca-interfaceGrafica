package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class UsuarioJaExisteController implements Initializable {
	@FXML
	private Button bt_ok;

	// Event Listener on Button[#bt_ok].onAction
	@FXML
	public void okPress(ActionEvent event) {
		Stage stage = (Stage) this.bt_ok.getScene().getWindow();
		stage.close();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	
	
	
}
