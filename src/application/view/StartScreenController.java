package application.view;

import java.io.IOException;
import java.net.URL;

import application.model.Controller;
import application.model.PlayerController;
import application.model.SceneTransition;
import application.model.UI;
import application.viewmodel.StartScreenViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Controller class for StartScreen
 * 
 * @author Thomas Whaley
 * @version 1.0
 *
 */
public class StartScreenController extends Controller {

	private StartScreenViewModel viewModel;
	
	@FXML
	private TextField playerOneNameTextField;
	
	@FXML
	private TextField playerTwoNameTextField;
	
	@FXML
	private CheckBox playerOneXCheckBox;
	
	@FXML
	private CheckBox playerOneOCheckBox;
	
	@FXML
	private CheckBox playerTwoXCheckBox;
	
	@FXML
	private CheckBox playerTwoOCheckBox;
	
	@FXML
	private Label errorLabel;
	
	@FXML
	private Button startButton;
	
	/**
	 * Creates a new StartScreenController object.
	 * 
	 * @precondition: none
	 * @postcondition: none
	 */
	public StartScreenController() {
		this.viewModel = new StartScreenViewModel();
	}
	
	/**
	 * Initializes the GUI components, binding them to the view model properties
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	@FXML
	public void initialize() {
		this.bindComponentsToViewModel();
	}
	
	@Override
	public void bindPlayersToViewModel() {}
	
	/**
	 * Binds all gui components to the viewmodel with StringProperty and BooleanProperty
	 * 
	 * @precondition: none
	 * @postcondition: none
	 */
	private void bindComponentsToViewModel() {
		this.playerOneNameTextField.textProperty().bindBidirectional(this.viewModel.playerOneNameProperty());
		this.playerTwoNameTextField.textProperty().bindBidirectional(this.viewModel.playerTwoNameProperty());
		this.errorLabel.textProperty().bindBidirectional(this.viewModel.errorProperty());
		this.playerOneXCheckBox.selectedProperty().bindBidirectional(this.viewModel.playerOneXProperty());
		this.playerOneOCheckBox.selectedProperty().bindBidirectional(this.viewModel.playerOneOProperty());
		this.playerTwoXCheckBox.selectedProperty().bindBidirectional(this.viewModel.playerTwoXProperty());
		this.playerTwoOCheckBox.selectedProperty().bindBidirectional(this.viewModel.playerTwoOProperty());
		
		this.viewModel.clearFields();
	}
	
	@FXML
	public void onStartButton() {
		PlayerController pc = this.viewModel.startButton();
		
		if (pc != null) {
			this.loadGame(pc);
		}
	}
	
	/**
	 * Loads and completes the transition to the GameScreen
	 * 
	 * @precondition: pc != null
	 * @postcondition: none
	 * 
	 * @param pc The PlayerController to pass to the GameScreen
	 */
	private void loadGame(PlayerController pc) {
		Stage currentStage = (Stage) this.startButton.getScene().getWindow();
		URL path = this.getClass().getResource(UI.Paths.GAME_SCREEN_FXML);
		
		try {
			SceneTransition.init(currentStage, path, pc);
		} catch (IOException e) {
			this.viewModel.errorProperty().set(UI.ExceptionMessages.IO_ERROR);
		}
	}
}
