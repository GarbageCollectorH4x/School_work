//team: garbage collector


public class Room
{

	

    private boolean         opened;



    private Door[]			doors;



    public Room()
	{

        this.isLocked =         true;
        this.isPermaLocked =    false;


    }


	
	public Door up()
	{
		
		return			doors[0];
		
	}
	
	
	
	public Door right()
	{
		
		return			doors[1];
	
	}
	
	
	
	public Door down()
	{
		
		return			doors[2];
		
	}
	
	
	
	public Door left()
	{
		
		return			doors[3];
		
	}
	
	
	

}