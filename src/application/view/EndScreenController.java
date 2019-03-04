package application.view;

import java.io.IOException;
import java.net.URL;

import application.model.Controller;
import application.model.SceneTransition;
import application.model.UI;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * The Class EndScreenController
 * 
 * @author Thomas Whaley
 * @version 1.0
 */
public class EndScreenController extends Controller {

	@FXML
	private Button playAgainButton;
	
	@FXML
	private Button closeButton;
	
	@FXML
	private Label label;
	
	/**
	 * Constructs a new EndScreenController object.
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	public EndScreenController() {
		super();
	}
	
	@FXML
	public void initialize() {}
	
	@Override
	public void bindPlayersToViewModel() {}
	
	/**
	 * Gets the label that displays at the top of the end screen
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the label at the top of the end screen
	 */
	public Label getLabel() {
		return this.label;
	}
	
	/**
	 * Closes the application when the user clicks the close button.
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	@FXML
	public void close() {
		Stage stage = (Stage) this.label.getScene().getWindow();
		stage.close();
		System.exit(0);
	}
	
	/**
	 * Starts a new game when the user clicks the play again button.
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	@FXML
	public void playAgain() {
		this.getPlayerController().setWinner(null);
		
		Stage stage = (Stage) this.label.getScene().getWindow();
		URL path = this.getClass().getResource(UI.Paths.GAME_SCREEN_FXML);
		
		try {
			SceneTransition.init(stage, path, this.getPlayerController());
		} catch (IOException e) {
			this.label.setText("IO Error");
		}
	}
}
