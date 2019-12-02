import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Pattern;

public class TriviaMain
{
	//enter this string to cheat when asked question.
	private final static String _CHEAT_ = "1337";
	
	
	public static class instructPrint
	{
		
		public static void playerMoveset()
		{
			
			System.out.println(" make your move?");
	        System.out.println("1) up");
	        System.out.println("2) down");
	        System.out.println("3) left");
	        System.out.println("4) right");
			
		}
		
		
		public static void menuChoices()
		{
			
			System.out.println("1.Move");
	        System.out.println("2.Save");
	        System.out.println("3.Load");
	        System.out.println("4.QUIT");
	        
		}
		
		
	}
	
    public static void main(String[] args)
    {
    	
        do {
        	
        	Database db = new Database();
        	Iterator<TriviaQuestion> qList = db.getList().iterator();
        	
            Player player1 = new Player();
            Maze maze = new Maze(player1);
            
            int menuNumber;
            
            
            maze.printMazeroom();
            
            
            do {
            	
                menuNumber = menu();
                
                switch(menuNumber)
                {
                case 1:
                	moveBehavior(maze, qList);
                	break;
                case 2:
                	saveBehavior( maze, player1 );
                	break;
                	
                	
                /////load game behavior/////
                case 3:
                	try{
                    	
                        ObjectInputStream fileIn = loadGame("SavedGame.txt");
                        maze =  (Maze) fileIn.readObject();
                        player1 = (Player) fileIn.readObject();
                    }catch (IOException | ClassNotFoundException e)
                    
                    {
                    	
                        System.out.println("no saved Game");
                        
                    }
                	break;
                /////load game behavior//////
                	
                	
                case 5:
                	maze.displayTheDungeon();
                	break;
                
                }
                

            } while ( menuNumber != 4 && !maze.checkForWin() );
        
            
        }while( playAgain() );
    
    }

    
    private static void moveBehavior(Maze maze, Iterator<TriviaQuestion> qList)
    {
    	
    	movePlayer(maze, qList);
        maze.enterRoom();//enter room or ask question then enter room also check if we are at E if we are we win.
        maze.printMazeroom();
    	
    }
    
    private static void saveBehavior(Maze maze, Player player1)
    {
    	
    	try{
        	
            saveGame(maze,player1);
            
        } catch (IOException | ClassNotFoundException e) {
        	
            e.printStackTrace();
            
        }
    	
    }
    
    
    
   private static int menu()
   {
	   
       String input;
       int choice;
       boolean correctinput;
       Scanner kb = new Scanner(System.in);
       
       
       do
       {
    	   
    	   instructPrint.menuChoices();
    	   
           input = kb.nextLine();
           
           correctinput = Pattern.matches( "[1-5]", input );
           
       }while( !correctinput );
       
       
       choice= Integer.parseInt(input);
       
       
       return choice;
       
   }
   
   

    private static boolean playAgain()
    {
    	
        String again;
        boolean correctinput;
        Scanner kb = new Scanner(System.in);
        
        
        do{
        	
            System.out.println("Play again (y/n)?");
            
            again = kb.nextLine();
            correctinput = Pattern.matches("[YyNn]",again);
            
            
        }while( !correctinput );
        
        
        if( again.equals("Y") || again.equals("y") )
        {
        	
            correctinput = true;
            
        }
        else 
        	correctinput = false;
        
        
        return correctinput;
        
        
    }
    
    
    
    private static void movePlayer(Maze maze, Iterator<TriviaQuestion> qList)
    {
    	
    	
        int choice;
        
        Scanner kb = new Scanner(System.in);
        
        /*System.out.println(" make your move?");
        System.out.println("1) up");
        System.out.println("2) down");
        System.out.println("3) left");
        System.out.println("4) right");*/
        instructPrint.playerMoveset();
            
            
        choice = kb.nextInt();
        kb.nextLine();
        

        Door door = getDoor( maze, choice );
        
        if( !door.isPermaLocked() )//if door is answered wrong or its a wall
        {
        	
        	if( door.isLocked() )//if question hasnt been asked/answered yet
        	{
        		
        		//question answer behavior// 
        		TriviaQuestion question = qList.next();
        		
        		question.readQuestion();
        		question.readHint();
        		
        		String input = kb.nextLine();
        		boolean answer = question.checkAnswer(input);
        		//question answer behavior//
        		
        		
        		//CHEAT BYPASS. WILL ANSWER QUESTION RIGHT.//
        		if( input.equals( _CHEAT_ ) )
        			answer = true;
        		
        		
        		door.setLock( answer );
        		
        		
        	}
        	
        	
        	if( !door.isLocked() )//if question has been answered correctly
        	{
        		
        		setPlayerLoc(choice, maze);
        		
        	}
        	
        	
        }
        else
        {
        	
        	System.out.println("You cannot move there!");
        	
        }
        
        
    }
    
    
    private static void setPlayerLoc(int choice, Maze maze)
    {
    	
    	int[] loc=maze.getPlayer1().getLocation();
        int r=loc[0];
        int c=loc[1];
        
        
        switch(choice)
        {
        case 1:
        	r--;
        	break;
        	
        case 2:
        	r++;
        	break;
        	
        case 3:
        	c--;
        	break;
	
        case 4:
        	c++;
        	break;
        
        }
        
        
        maze.getPlayer1().setLocation(r, c);        
    	
    	
    }
    
    
    
    private static Door getDoor(Maze maze, int choice)
    {
    	
    	 int[] loc=maze.getPlayer1().getLocation();
         
         
         int r=loc[0];
         int c=loc[1];

         
        Room room =  maze.getRoom(r, c);
        Door door = room.right();//default choice
        
        switch(choice)
        {
        
        case 1:
        	door = room.up();
        	break;
        	
        case 2:
        	door = room.down();
        	break;
        	
        case 3:
        	door = room.left();
        	break;
        
        }
    	
        
        return door;
        
    	
    }
    
    
    
    private static void saveGame(Maze maze, Player p1) throws IOException, ClassNotFoundException
    {
        FileOutputStream fileout = new FileOutputStream("SavedGame.txt");
        ObjectOutputStream objout = new ObjectOutputStream(fileout);
        objout.writeObject(maze);
        objout.writeObject(p1);
        objout.flush();
        objout.close();
    }
    
    //save functionality
    /*
    
   	private static saveQList(qList){
   	
   		ArrayList<TriviaQuestion> toBeSaved = new ArrayList<TriviaQuestion>();
   		
   		while( qList.hasNext() )
   		{
   		
   			toBeSaved.add( qList.next() );
   		
   		}
   		
   		qList = toBeSaved.iterator();
   		
   	}
    
    */
    
    
    private static ObjectInputStream loadGame(String fileIn) throws IOException
    {
           FileInputStream In = new FileInputStream(fileIn);
        return new ObjectInputStream(In);
    }
}
