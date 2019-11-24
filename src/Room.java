//team: garbage collector


public class Room
{	


	private Door[]			doors;

	//the door array represents each room, each index position is as follows:
	//
	//		   up
	//		|--0--|
	// left 3     1  right
	//		|--2--|
	//		  down
	//


    public Room(Door[] ds)
	{

		this.doors =	ds;

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
	

	public void setUp(Door door)
	{
		this.doors[0] =	door;
	}

	public void setDown(Door door)
	{
		this.doors[2] =	door;
	}

	public void setLeft(Door door)
	{
		this.doors[3] =	door;
	}

	public void setRight(Door door)
	{
		this.doors[1] =	door;
	}


	
	
	public String[] draw()
	{

		//each string is a row, each character is a column of a row.
		String[] temp 	= new String[3];

		temp[0] 		+= "*";
		temp[0]			+= ( doors[0].isWall() ? "*" : "-");
		temp[0] 		+= "*";

		temp[1]			+= ( doors[3].isWall() ? "*" : "|");
		temp[1]			+= " ";
		temp[1]			+= ( doors[1].isWall() ? "*" : "|");

		temp[2] 		+= "*";
		temp[2]			+= ( doors[2].isWall() ? "*" : "-");
		temp[2]			+= "*";

		return 			temp;

	}


}