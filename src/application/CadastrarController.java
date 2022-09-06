package application;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;

import br.com.biblioteca.cliente.Cliente;
import br.com.biblioteca.comandos.servidor.ComandoServidorEnums;
import br.com.biblioteca.entiade.usuario.TipoUsuario;
import br.com.biblioteca.entiade.usuario.UsuarioFisico;
import br.com.biblioteca.pacote.PacoteParaCliente;
import br.com.biblioteca.pacote.PacoteParaServidor;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
	private Cliente cliente;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Image image = new Image("C:\\Users\\efigueredo\\eclipse-workspace\\BibliotecaInterfaceGrafica\\src\\br\\com\\biblioteca\\imagens\\user.png");
		avatar.setFill(new ImagePattern(image));
		this.cliente = new Cliente();
	}
	
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
	public void cadastrar(ActionEvent event) throws ClassNotFoundException, IOException {
		String nome = tf_name.getText();
		String sobrenome = tf_sobrenome.getText();
		String senha = tf_pass.getText();
		String email = tf_email.getText();
		String cpf = tf_cpf.getText();
		String sexo;
		if (check_mas.isSelected()) {
			sexo = "Masculino";
		} else {
			sexo = "Feminino";
		}
		
		boolean condicao1 = nome.isEmpty();
		boolean condicao2 = sobrenome.isEmpty();
		boolean condicao3 = senha.isEmpty();
		boolean condicao4 = email.isEmpty();
		boolean condicao5 = cpf.isEmpty();
		
		if (!condicao1 && !condicao2 && !condicao3 && !condicao4 && !condicao5) {
			System.out.println("entrou na criacao");
			UsuarioFisico pessoa = new UsuarioFisico(tf_name.getText(), tf_sobrenome.getText(), tf_pass.getText(), tf_email.getText(), tf_cpf.getText(), sexo, this.imagem, TipoUsuario.PESSOA);
			PacoteParaServidor pacote = new PacoteParaServidor(pessoa, ComandoServidorEnums.ADICIONAR, TipoUsuario.PESSOA);
			PacoteParaCliente pacoteParaCliente = cliente.enviarPacoteAoServidor(pacote);
			retornarLogin();
			
			if (!pacoteParaCliente.getResultadoBoolean()) {
				Parent usuarioJaExistePopup = FXMLLoader.load(getClass().getResource("FXMLUsuarioJaExiste.fxml"));
				Stage stage = new Stage();
				stage.setScene(new Scene(usuarioJaExistePopup));
				stage.show();
				
			}
			
		} else {
			Parent usuarioDadosInsuficientes= FXMLLoader.load(getClass().getResource("FXMLDadosInsuficientes.fxml"));
			Stage stage = new Stage();
			stage.setScene(new Scene(usuarioDadosInsuficientes));
			stage.show();
		}
		
		
		
		
	}
	// Event Listener on Button[#bt_cancelar].onAction
	@FXML
	public void cancelar(ActionEvent event) throws IOException {
		retornarLogin();
	}
	
	private void retornarLogin() throws IOException {
		Main main = new Main();
		main.changeScene("FXMLLogin.fxml");
	}
	
}
