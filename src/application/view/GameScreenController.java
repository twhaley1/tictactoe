package application.view;

import java.io.IOException;
import java.net.URL;

import application.model.Controller;
import application.model.CountThreadListener;
import application.model.GameCount;
import application.model.SceneTransition;
import application.model.UI;
import application.viewmodel.GameScreenViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * Controller for the GameScreen fxml file
 * 
 * @author Thomas Whaley
 * @version 1.0
 */
public class GameScreenController extends Controller implements CountThreadListener {

	private GameScreenViewModel viewModel;
	private Thread countingThread;
	private GameCount count;
	
	@FXML
	private Label bottomMiddleLabel;
	
	@FXML
	private Label topMiddleLabel;
	
	@FXML
	private Label middleRightLabel;
	
	@FXML
	private Label topLeftLabel;
	
	@FXML
	private Label bottomLeftLabel;
	
	@FXML
	private Label bottomRightLabel;
	
	@FXML
	private Label topRightLabel;
	
	@FXML
	private Label middleLeftLabel;
	
	@FXML
	private Label middleMiddleLabel;
	
	@FXML
	private Label topLabel;
	
	@FXML
	private Label bottomLabel;
	
	/**
	 * Creates a new GameScreenController object
	 * 
	 * @precondition: none
	 * @postcondition: none
	 */
	public GameScreenController() {
		super();
		this.viewModel = new GameScreenViewModel();
		this.count = new GameCount(10, this);
		this.countingThread = new Thread(this.count);
		this.countingThread.start();
	}
	
	@Override
	public void bindPlayersToViewModel() {
		this.viewModel.setPlayers(this.getPlayerController());
	}
	
	/**
	 * Gets the Top Label
	 * 
	 * @precondition: none
	 * @postcondition: none
	 * 
	 * @return top label
	 */
	public Label getTopLabel() {
		return this.topLabel;
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
	
	/**
	 * Binds all fxml gui components to StringProperties in the view model.
	 * 
	 * @precondition: none
	 * @postcondition: none
	 */
	private void bindComponentsToViewModel() {
		this.bottomMiddleLabel.textProperty().bindBidirectional(this.viewModel.bottomMiddleProperty());
		this.topMiddleLabel.textProperty().bindBidirectional(this.viewModel.topMiddleProperty());
		this.middleRightLabel.textProperty().bindBidirectional(this.viewModel.middleRightProperty());
		this.topLeftLabel.textProperty().bindBidirectional(this.viewModel.topLeftProperty());
		this.bottomLeftLabel.textProperty().bindBidirectional(this.viewModel.bottomLeftProperty());
		this.bottomRightLabel.textProperty().bindBidirectional(this.viewModel.bottomRightProperty());
		this.topRightLabel.textProperty().bindBidirectional(this.viewModel.topRightProperty());
		this.middleLeftLabel.textProperty().bindBidirectional(this.viewModel.middleLeftProperty());
		this.middleMiddleLabel.textProperty().bindBidirectional(this.viewModel.middleMiddleProperty());
		this.topLabel.textProperty().bindBidirectional(this.viewModel.topLabelProperty());
		
		this.viewModel.clearFields();
		this.bottomLabel.setText("");
	}
	
	/**
	 * Handles what happens when a game is completed.
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	private void endGame() {
		this.setPlayerController(this.viewModel.getPlayerController());
		
		Stage currentStage = (Stage) this.bottomLeftLabel.getScene().getWindow();
		URL path = this.getClass().getResource(UI.Paths.END_SCREEN_FXML);
		
		try {
			SceneTransition.init(currentStage, path, this.getPlayerController());
		} catch (IOException e) {
			this.viewModel.topLabelProperty().set(UI.ExceptionMessages.IO_ERROR);
		}
	}
	
	
	@FXML
	public void topLeftClicked() {
		this.restartThread();
		if (this.viewModel.topLeft()) {
			this.endGame();
		}
	}
	
	@FXML
	public void topMiddleClicked() {
		this.restartThread();
		if (this.viewModel.topMiddle()) {
			this.endGame();
		}
	}
	
	@FXML
	public void topRightClicked() {
		this.restartThread();
		if (this.viewModel.topRight()) {
			this.endGame();
		}
	}
	
	@FXML
	public void middleLeftClicked() {
		this.restartThread();
		if (this.viewModel.middleLeft()) {
			this.endGame();
		}
	}
	
	@FXML
	public void middleMiddleClicked() {
		this.restartThread();
		if (this.viewModel.middleMiddle()) {
			this.endGame();
		}
	}
	
	@FXML
	public void middleRightClicked() {
		this.restartThread();
		if (this.viewModel.middleRight()) {
			this.endGame();
		}
	}
	
	@FXML
	public void bottomLeftClicked() {
		this.restartThread();
		if (this.viewModel.bottomLeft()) {
			this.endGame();
		}
	}
	
	@FXML
	public void bottomMiddleClicked() {
		this.restartThread();
		if (this.viewModel.bottomMiddle()) {
			this.endGame();
		}
	}
	
	@FXML
	public void bottomRightClicked() {
		this.restartThread();
		if (this.viewModel.bottomRight()) {
			this.endGame();
		}
	}

	@Override
	public void notifyComplete() {
		this.viewModel.processTurn();
		this.count.resetCount();
		try {
			this.countingThread.join();
			this.countingThread = new Thread(this.count);
			this.countingThread.start();
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		} catch (IllegalThreadStateException j) {
			System.err.println(j.getMessage());
		}
	}

	@Override
	public void update(int seconds) {
		if (seconds < 0) {
			this.updateBottomLabel("");
		} else {
			this.updateBottomLabel(String.format(UI.BOTTOM_LABEL, seconds));
		}
	}
	
	/**
	 * Updates the bottom label with a specified string.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param message the string to set to the bottom label.
	 */
	private void updateBottomLabel(String message) {
		this.bottomLabel.setText(message);
	}
	
	/**
	 * Restarts the count on the counting thread and sets the label to an empty string.
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	private void restartThread() {
		this.count.resetCount();
		this.updateBottomLabel("");
	}
}
