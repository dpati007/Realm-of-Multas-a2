package GameScenes;

import GameData.PlayerData;
import GameData.WorldData;
import application.TextEffects;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * This type of scene is meant to contain a giant block of Text at the center and can be clicked anywhere
 * to exit the scene, it could optionally contain a user interface and optionally contain a back
 * button
 * 
 * 1. Title
 * 2. Click to transition
 * 3. Optionally. Back Button
 * 4. Optionally. User Interface
 * 
 * @author Dsp02_000
 *
 */
public abstract class SceneTitle extends GameScenes{

	private String sceneClass = "SceneTitle";
	
	public abstract void customEvents();
	
	public SceneTitle(Stage primaryStage, String pathToBackGround, String title, boolean isBackBut,
			boolean isUserInterface, PlayerData player, WorldData world)
	{
		super(primaryStage, pathToBackGround, player, world);
		loadTitle(title, true);
		fadingText("Click to Start");
		sceneButtons(isBackBut);
		sceneEvents();
	}

	@Override
	public void sceneEvents(){
		getFrameWork().setOnMouseClicked(e -> {
			getStage().setScene(getSceneBranch().getFutureScenes(0));
			getStage().show();
		});
	}

	@Override
	public void sceneButtons(boolean isBackBut) {
		// TODO Auto-generated method stub
	}
	
	private void fadingText(String text){
		
		TextEffects apply = new TextEffects();
		Text toFade = new Text();
		toFade.setText(text);
		toFade.setFill(Color.BLACK);
		toFade.setFont(Font.font("Mistral", FontWeight.BOLD, 24));
		toFade.setX((GAME_WIDTH / 2) - toFade.getLayoutBounds().getMaxX() / 2);
		toFade.setY(GAME_HEIGHT - 100); 
		Text fadingText = apply.fadeInAndOut(toFade, 1.0, 0.01, 1500);
		getBorderPane().getChildren().add(fadingText);
	}
	
	/* ---GETTERS AND SETTERS--- */
	
	public String getSceneName(){
		return sceneClass;
	}
}
