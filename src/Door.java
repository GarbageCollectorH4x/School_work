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
		this.isPermaLocked = wall;

	}
	


	public boolean isWall()
	{


		return		this.isWall;


	}
	
	
	public void setLock( boolean lock )
	{
		
		//if question was answered right, doors locks will be set to an unlocked state(false)
		this.isPermaLocked = !lock;
		this.isLocked = !lock;
		
	}
	

	public boolean isPermaLocked()
	{
		
		return this.isPermaLocked;
		
	}
	
	
	public boolean canInteract()
	{
		
		return this.isLocked && ( !this.isPermaLocked && !this.isWall );
		
	}
	
	public boolean isLocked()
	{
		

		if(this.isWall || this.isPermaLocked)
			return true;
		
		
		return this.isLocked;
		

	}
	
	
	
}


