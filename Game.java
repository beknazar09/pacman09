import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.util.*;
import javafx.scene.input.KeyCode;
import java.io.File; 
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.*;
import javafx.scene.paint.Color;
import javafx.scene.layout.Pane;
import javafx.stage.StageStyle;
import javafx.stage.Modality;

public class Game extends Application{

	private Map map;
	private Player player;
	private Food food;

	public void start(Stage gameStage){

		List<String> parameters = getParameters().getRaw();
		map = new Map(parameters.get(0));
		player = new MyPlayer(map);
		food = new Food(map, player);
//setting the game scene with the map and scene's parameters(height and width) 
		gameStage.setScene(new Scene(map, map.getUnit()*map.getSize(), map.getUnit()*map.getSize()));
		gameStage.show(); 
		System.out.println("Map size: " + map.getSize());

//keyPressed methods for the UP, DOWN, RIGHT, LEFT and ESCAPE buttons	
		
		map.setOnKeyPressed(e->{	

			if(e.getCode() == KeyCode.RIGHT){
				player.moveRight();		}

			else if(e.getCode() == KeyCode.LEFT){
				player.moveLeft();		}

			else if(e.getCode() == KeyCode.UP){
				player.moveUp();		}

			else if(e.getCode() == KeyCode.DOWN){
				player.moveDown();		}
			
		});	

			map.requestFocus();	
	}
}



