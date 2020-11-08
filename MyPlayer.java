import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MyPlayer implements Player{
//private fields
	private ImageView ball;
	private Map map;
	private Position position;

	MyPlayer(Map map){

		this.map = map;	
		position = map.getStartPosition();

	//setting the gif file of the packman using ImageVies 
		ball = new ImageView(new Image("files/pac.gif"));

	//setting the ball into the map 
		ball.setX(position.getX()*map.getUnit() + map.getUnit()/6);
		ball.setY(position.getY()*map.getUnit() + map.getUnit()/6);

	//setting the ball's size parameters
		ball.setFitHeight(map.getUnit()*0.66);
		ball.setFitWidth(map.getUnit()*0.66);
	//adding the ball into the Map(Pane)
		map.getChildren().add(ball);	}

	//moving the ball, checking the direction before; rotating the packman if the direction is changed 
	public void moveRight(){	
		if(this.getPosition().getX() < map.getSize()-1 && map.getValue(this.getPosition().getY(), this.getPosition().getX()+1) != 1){
			ball.setX(ball.getX() + map.getUnit());
			ball.setRotate(0);	}
		else System.out.println("Invalid position!");	}
	
	public void moveLeft(){	
		if(this.getPosition().getX() > 0 && map.getValue(this.getPosition().getY(), this.getPosition().getX()-1) != 1){
			ball.setX(ball.getX() - map.getUnit());
			ball.setRotate(180);	}
		else System.out.println("Invalid position!");	}
	
	public void moveUp(){	
		if(this.getPosition().getY() > 0 && map.getValue(this.getPosition().getY()-1, this.getPosition().getX()) != 1){
			ball.setY(ball.getY() - map.getUnit());
			ball.setRotate(270);	}
		else System.out.println("Invalid position!");	}

	public void moveDown(){		
		if(this.getPosition().getY() < map.getSize()-1 && map.getValue(this.getPosition().getY()+1, this.getPosition().getX()) != 1){
			ball.setY(ball.getY() + map.getUnit());
			ball.setRotate(90);	}
		else System.out.println("Invalid position!");	}

	//getting the last position of the packman by the coordinates of the ball
	public Position getPosition(){	
		return new Position((int)ball.getX()/map.getUnit(), (int)ball.getY()/map.getUnit());	}
}
