package application;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class CadastrarController implements Initializable {
	@FXML
	private Circle avatar;
	@FXML
	private TextField tf_sobrenome;
	@FXML
	private TextField tf_name;
	@FXML
	private TextField tf_cpf;
	@FXML
	private TextField tf_email;
	@FXML
	private TextField tf_pass;
	@FXML
	private RadioButton check_fem;
	@FXML
	private ToggleGroup sexo;
	@FXML
	private RadioButton check_mas;
	@FXML
	private Button bt_image;
	@FXML
	private Button bt_cadastrar;
	@FXML
	private Button bt_cancelar;
	
	private Image imagem;
	private FileChooser fileChooser;
	private File filePath;

	// Event Listener on Button[#bt_image].onAction
	@FXML
	public void selecionarImagem(ActionEvent event) {
		try {
			Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
			fileChooser = new FileChooser();
			fileChooser.setTitle("Selecionar imagem");		
			// Set imagem pelo usuario
			String userDirectoryString = System.getProperty("user.home") + "\\Pictures";
			File userDirectory = new File(userDirectoryString);	
			if (!userDirectory.canRead()) {
				userDirectory = new File("c:/");
			}
			fileChooser.setInitialDirectory(userDirectory);	
			this.filePath = fileChooser.showOpenDialog(stage);	
		} catch (RuntimeException r) {
			System.out.println("continuando");
		}
		
		// tentar trocar a foto		
		try {
			BufferedImage bi = ImageIO.read(filePath);
			Image image = SwingFXUtils.toFXImage(bi, null);
			avatar.setFill(new ImagePattern(image));
			this.imagem = image;
			
		} catch (IOException e) {
			System.out.println("continuando");
		}			
	}
	// Event Listener on Button[#bt_cadastrar].onAction
	@FXML
	public void cadastrar(ActionEvent event) {
		String nome = tf_name.getText();
		String sobrenome = tf_sobrenome.getText();
		String senha = tf_pass.getText();
		String email = tf_email.getText();
		String cpf = tf_cpf.getText();
		boolean masculino = check_mas.isSelected();
		
		
	}
	// Event Listener on Button[#bt_cancelar].onAction
	@FXML
	public void cancelar(ActionEvent event) {
		// TODO Autogenerated
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Image image = new Image("C:\\Users\\emano\\OneDrive\\Documentos\\Java\\BibliotecaInterfaceGrafica\\src\\br\\com\\biblioteca\\imagens\\user.png");
		avatar.setFill(new ImagePattern(image));	
	}
}