//team: garbage collector



public class Door
{
	
	
	
	private boolean				isLocked;
	private boolean				isPermaLocked;
	

	private boolean				isWall;
	
	
	
	public Door()
	{
		
		this.isLocked =		 	true;
		this.isPermaLocked = 	false;
		this.isWall = 			false;
		
	}

	

	public Door(boolean wall)
	{
		//pass true if you want to create a wall
		//all other fields in this class wlll be ignored if this value is set to true
		this.isWall =		wall;

	}
	


	public boolean isWall()
	{


		return		this.isWall;


	}

	
	
	public boolean isLocked()
	{
		

		if(this.isWall || this.isPermaLocked)
			return true;
		
		
		return this.isLocked;
		

	}
	
	
	
}


