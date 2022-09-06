package application;

import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class DadosInsuficientesController {
	@FXML
	private Button bt_ok;

	// Event Listener on Button[#bt_ok].onAction
	@FXML
	public void okPress(ActionEvent event) {
		Stage stage = (Stage) this.bt_ok.getScene().getWindow();
		stage.close();
	}
}
