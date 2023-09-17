import java.util.HashMap;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {
	HashMap<String, Scene> sceneMap;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
		
	}

	//feel free to remove the starter code from this method
	@Override
	public void start(Stage primaryStage) {
		sceneMap = new HashMap<String,Scene>();
		
		// set up the background of the start up menu
		Image backgroundPic = new Image("RocketLaunch.jpg");
		BackgroundImage backgroundStartUp = new BackgroundImage(backgroundPic, null, null, null, new BackgroundSize(1300, 1260,false,false,false,false));
		Background startBackground = new Background(backgroundStartUp);
		
		TextField gameTitle = new TextField("Space Exploration Game");
		gameTitle.setEditable(false);
		gameTitle.setMaxWidth(310);
		gameTitle.setStyle("-fx-background-color: white;" + "-fx-border-color: black;" + "-fx-text-color: white");
		gameTitle.setFont(Font.font("Copperplate", FontWeight.BOLD, 24));
		
		Button explorationButton = new Button("Exploration Mode");
		Button sandboxButton = new Button("Sandbox Mode");
		Button exitButton = new Button("Exit");
		
		// set Font
		explorationButton.setFont(Font.font("Papyrus", FontWeight.BOLD, 14));
		sandboxButton.setFont(Font.font("Papyrus", FontWeight.BOLD, 14));
		
		// set button Size
		sandboxButton.setMinSize(50, 50);
		explorationButton.setMinSize(50,50);
		
		//template exit commands
		explorationButton.setOnAction(e->Platform.exit());;
		exitButton.setOnAction(e->Platform.exit());
		sandboxButton.setOnAction(e->Platform.exit());
		
		// holders that will hold the buttons
		HBox gameModeHolder = new HBox(30, explorationButton, sandboxButton);
		gameModeHolder.setAlignment(Pos.CENTER);
		VBox buttonHolder = new VBox(30, gameModeHolder, exitButton);
		buttonHolder.setAlignment(Pos.CENTER);
		VBox centerPiece = new VBox(200, gameTitle, buttonHolder);
		centerPiece.setAlignment(Pos.CENTER);
		
		// initialize and present Borderpane/scenes
		BorderPane borderPane = new BorderPane();
		borderPane.setBackground(startBackground);
		borderPane.setCenter(centerPiece);
		Scene start = new Scene(borderPane, 1300, 850);
		
		primaryStage.setTitle("Space Exploration Game");
		primaryStage.setScene(start);
		primaryStage.show();
		
		
	}
}
