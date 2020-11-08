import java.io.File;
import java.io.FileNotFoundException;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import java.util.Scanner;

public class Map extends Pane{
	private int UNIT = 35;
	private int size;
	private int[][] map;
	private Position start;

	public Map(String fileName){
//reading from the .txt file to create the map		
	try{
		File file = new File(fileName);
		Scanner in = new Scanner(file);
		if(!in.hasNextInt())
			throw new InvalidMapException("Empty file");

		while(in.hasNextInt()){
		size = in.nextInt();
			map = new int[size][size];
			for(int i = 0; i < size; i++)
				for(int j = 0; j < size; j++){
					if(!in.hasNextInt())
						throw new InvalidMapException("Invalid map");
					map[i][j] = in.nextInt();	}
			
				if(in.hasNextInt())
					throw new InvalidMapException("Invalid map");
}			
			in.close();

	}catch(FileNotFoundException ex){System.out.println("File in not found"); System.exit(0);}
		catch(InvalidMapException ex){System.out.println(ex); System.exit(0);}

//creating the black rectangle for the background
		Rectangle background = new Rectangle(0, 0, size*UNIT, size*UNIT);
		background.setFill(Color.BLACK);
		this.getChildren().add(background);

		for(int i = 0; i < size; i++)
			for(int j = 0; j < size; j++){
				if(map[i][j] == 1){
					Rectangle rec = new Rectangle(j*UNIT, i*UNIT, UNIT, UNIT);
					this.getChildren().add(rec);
				//setting rectangle's stroke's width	
					rec.setStrokeWidth(4);
				//making the corners rounded
					rec.setArcWidth(15);
					rec.setArcHeight(15);
				//setting the color of the stroke to the dark-blue color	
					rec.setStroke(Color.BLUE.darker());	}

			else if(map[i][j] == 0 || map[i][j] == 2){
			//if the element has the value value "2", then assign the start field to this (x;y) pair 
				if(map[i][j] == 2)	
					start = new Position(j, i);	
			//if the value is "0" or "2" then create the white dot(little circle) here
				 	Circle cir = new Circle(j*UNIT +  UNIT/2, i*UNIT+ UNIT/2, 1);
				 	cir.setFill(Color.WHITE);
				 	this.getChildren().add(cir);
				}
			}

	
	}
//getter methods for the UNIT, size fields, map array's specific element and the start Position 
	public int getUnit(){	return UNIT;	}
	public int getSize(){	return size;	}
	public int getValue(int i, int j){	return map[i][j];}
	public Position getStartPosition(){	return start;	}	
}
//Exception for the map if doesn't have the enough values
class InvalidMapException extends Exception{
	InvalidMapException(){super();}
	InvalidMapException(String str){super(str);}	}