package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent rootLogin = FXMLLoader.load(getClass().getResource("FXMLLogin.fxml"));
		primaryStage.setTitle("Login");
		primaryStage.setScene(new Scene(rootLogin));
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
