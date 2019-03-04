package application.model;

import java.io.IOException;
import java.net.URL;

import application.view.EndScreenController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * The SceneTransition Class.
 * 
 * @author Thomas Whaley
 * @version 1.0
 */
public final class SceneTransition {

	/**
	 * Causes the specified stage of the application to change into the one described by 
	 * the path url.
	 * 
	 * @precondition stage != null && url != null && playerController != null
	 * @postcondition none
	 * 
	 * @param stage the stage for the actions to be performed on
	 * @param url the url object to specify where the FXML document is
	 * @param playerController the object that contains information about the players
	 * 
	 * @throws IOException if there is an error loading the fxml
	 */
	public static void init(Stage stage, URL url, PlayerController playerController) throws IOException {
		if (stage == null) {
			throw new IllegalArgumentException(UI.ExceptionMessages.NULL_STAGE);
		}
		if (url == null) {
			throw new IllegalArgumentException(UI.ExceptionMessages.NULL_URL);
		}
		if (playerController == null) {
			throw new IllegalArgumentException(UI.ExceptionMessages.NULL_PLAYER_CONTROLLER);
		}

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(url);
		Pane pane = (Pane) loader.load();
		Controller controller = loader.getController();
		controller.setPlayerController(playerController);
		controller.bindPlayersToViewModel();
		
		if (controller instanceof EndScreenController) {
			Player winner = playerController.getWinner();
			if (winner == null) {
				((EndScreenController) controller).getLabel().setText("It was a draw.");
			} else {
				((EndScreenController) controller).getLabel().setText(winner.getName() + " wins!");
			}
		}
		
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.setTitle(UI.Titles.TIC_TAC_TOE);
	}
	
}
