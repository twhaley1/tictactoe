package application;
	
import java.io.IOException;

import application.model.UI;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;


public class Main extends Application {

	/**
	 * Constructs a new Application object for the MenuReviewApplication
	 * program.
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	public Main() {
		super();
	}

	/**
	 * Starts the application and sets the main stage.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param primaryStage
	 *            The main stage to set for the application.
	 * 
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
			Pane pane = this.loadGui();
			Scene scene = new Scene(pane);
			primaryStage.setScene(scene);
			primaryStage.setTitle(UI.Titles.START_SCREEN_TITLE);

			primaryStage.show();
		} catch (IllegalStateException | IOException anException) {
			anException.printStackTrace();
		}
	}

	private Pane loadGui() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource(UI.Paths.START_SCREEN_FXML));
		return (Pane) loader.load();
	}

	/**
	 * Launches the application.
	 * 
	 * @param args
	 *            not used
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
