package application.model;

public final class UI {

	public static final String TOP_LABEL = "%s's Turn";
	public static final String BOTTOM_LABEL = "%d Seconds Remaining";
	public static final String NULL_PROCESS = "NULL PROCESS";
	
	public static final class ExceptionMessages {
		public static final String NULL_NAME = "name cannot be null.";
		public static final String NULL_PLAYER_TYPE = "player type cannot be null.";
		public static final String NULL_NEW_PLAYER = "new player cannot be null.";
		public static final String MATCHING_TYPES = "Players cannot have matching types.";
		public static final String NULL_PLAYER_CONTROLLER = "player controller cannot be null.";
		public static final String NULL_PLAYER = "Player cannot be null.";
		public static final String NULL_STAGE = "Stage cannot be null.";
		public static final String NULL_URL = "URL cannot be null.";
		public static final String NULL_CLASS = "Class cannot be null.";
		public static final String IO_ERROR = "An Error Occurred.";
	}
	
	public static final class FieldWarnings {
		public static final String PLAYER_ONE_NAME = "Player 1 must have a name.";
		public static final String PLAYER_TWO_NAME = "Player 2 must have a name.";
		public static final String PLAYER_ONE_XO_SAME_TIME = "Player 1 cannot be X and O at the same time.";
		public static final String PLAYER_TWO_XO_SAME_TIME = "Player 2 cannot be X and O at the same time.";
		public static final String PLAYER_ONE_MUST_HAVE_TYPE = "Player 1 must select a player type.";
		public static final String PLAYER_TWO_MUST_HAVE_TYPE = "Player 2 must select a player type.";
	}
	
	public static final class Titles {
		public static final String START_SCREEN_TITLE = "Player Creation";
		public static final String TIC_TAC_TOE = "Tic-Tac-Toe";
	}
	
	public static final class Paths {
		public static final String START_SCREEN_FXML = "view/StartScreen.fxml";
		public static final String GAME_SCREEN_FXML = "GameScreen.fxml";
		public static final String END_SCREEN_FXML = "EndScreen.fxml";
	}
	
}
