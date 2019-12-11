//team: garbage collector

import java.io.Serializable;
 
public class Room implements Serializable
{	


	private Door[]			doors;
	
	private Character		space;
	
	private boolean			visited;

	//the door array represents each room, each index position is as follows:
	//
	//		   up
	//		|--0--|
	// left 3     1  right
	//		|--2--|
	//		  down
	//


    public Room()
	{
    	
    	this.space = ' ';
    	this.doors = new Door[4];
    	this.visited = false;
	
    }
    
    

    public void visit()
    {
    	this.visited = true;
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


	public void setShowHero(Character show)
	{
		
		this.space = show;
		
	}
	
	
	public boolean hasBeenVisited()
	{
		return this.visited;
	}
	
	
	public int availInteractions()
	{
		int count = 0;
		
		for(int i = 0; i < this.doors.length; i++)
		{
			if( this.doors[i].canInteract())
				count++;
		}
		
		return count;
	}
	
	
	
	public Character getShowHero()
	{
		return this.space;
	}
	
	
	
	public String row0()
	{
		
		String temp = "";
		
		temp 		+= "*";
		temp		+= ( doors[0].isWall() ? "*" : "-");
		temp 		+= "*";
		
		return temp;
		
	}
	
	
	
	public String row1()
	{
		
		String temp = "";
		
		temp		+= ( doors[3].isWall() ? "*" : "|");
		temp		+= this.space;
		temp		+= ( doors[1].isWall() ? "*" : "|");
		
		return temp;
		
	}
	
	
	
	public String row2()
	{
		
		String temp = "";
		
		temp		+= "*";
		temp		+= ( doors[2].isWall() ? "*" : "-");
		temp		+= "*";
		
		return temp;
		
	}
	
	
	
	public String[] draw()
	{

		//each string is a row, each character is a column of a row.
		String[] temp 	= new String[3];

		temp[0] 		= this.row0();
		temp[1]			= this.row1();
		temp[2] 		= this.row2();

		return 			temp;

	}
	
	

	public boolean canGo(int dir)
	{
		
		return this.doors[dir].canInteract();
		
	}
	
	

}