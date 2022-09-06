module BibliotecaInterfaceGrafica {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.desktop;
	requires javafx.swing;
	requires javafx.graphics;
	
	opens application to javafx.graphics, javafx.fxml;
}
