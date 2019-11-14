//team: garbage collector

import java.util.Scanner;

public class Player
{
	

    private String      p_name;
	private Input		p_input;
	
	private int			pos_x;
	private int			pos_y;


    public Player(String name, int px, int py, Input in)
	{
		
        this.p_name =     	name;
		
		
		this.pos_x = 		px
		this.pos_y =		py;
		
		
		this.p_input =		in;
		
		
    }
	
	public Player()
	{
		
		
		this.p_input =		new Input();
		
		this.promptPlayerName();
		
		this.p_name =		this.getStringInput();
		
		
	}
	
	
	public String getStringInput()
	{
		
		String temp = 	this.p_input.kb.nextLine();
		
		
		return 			temp;
		
	}
		

	private void promptPlayerName()
	{
		
		System.out.print("\nEnter player name: ");
		
	}
	
	public int x()
	{
		
		return		this.pos_x;
		
	}
	
	public int y()
	{
		
		return		this.pos_y;
	
	}
	

}