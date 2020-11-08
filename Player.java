public interface Player{
	//interface with abstract methods for the MyPlayer class to override
	public void moveRight();
	public void moveLeft();
	public void moveUp();
	public void moveDown();
	public Position getPosition();
}