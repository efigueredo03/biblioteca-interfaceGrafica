package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	
	private static Stage stg;

	@Override
	public void start(Stage primaryStage) throws Exception {
		stg = primaryStage;
		Parent rootLogin = FXMLLoader.load(getClass().getResource("FXMLLogin.fxml"));
		primaryStage.setTitle("Login");
		primaryStage.setScene(new Scene(rootLogin));
		primaryStage.show();
		
	}
	
	public void changeScene(String fxml) throws IOException {
		Parent pane = FXMLLoader.load(getClass().getResource(fxml));
		stg.setScene(new Scene(pane));
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
