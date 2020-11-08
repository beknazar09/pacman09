public class Position{

	private int x;
	private int y;

//constructor with two parameters
	public Position(int x, int y){	this.x = x;	this.y = y;	}

//getter and setter methods
	public int getX(){	return x;	}
	public int getY(){	return y;	}
	public void setX(int x){	this.x = x;	}
	public void setY(int y){	this.y = y;	}
	
//returns true if two Position instances will have the same pairs (int x,int y)
	public boolean equals(Position other){
		return (this.x == other.getX() && this.y == other.getY());	}
}