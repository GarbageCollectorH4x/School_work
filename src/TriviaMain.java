import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Pattern;

public class TriviaMain
{
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
                if (menuNumber == 1) {
                	
                    movePlayer(maze, qList);
                    maze.enterRoom();//enter room or ask question then enter room also check if we are at E if we are we win.
                    maze.printMazeroom();
                    
                }
                else if(menuNumber == 2)
                {
                    ArrayList<TriviaQuestion>toBeSaved = new ArrayList<TriviaQuestion>();
                    try{

                        while(qList.hasNext())
                        {
                            toBeSaved.add(qList.next());
                        }
                        saveGame(maze,player1,toBeSaved);
                        qList = toBeSaved.iterator();
                        
                    } catch (IOException  e) {
                    	
                        e.printStackTrace();
                        
                    }

                }
                else if(menuNumber == 3)
                {
                    try{
                        ArrayList<TriviaQuestion> listholder = new ArrayList<TriviaQuestion>();
                        ObjectInputStream fileIn = loadGame("SavedGame.txt");
                        maze =  (Maze) fileIn.readObject();
                        player1 = (Player) fileIn.readObject();
                        listholder = (ArrayList<TriviaQuestion>) fileIn.readObject();
                        qList = listholder.iterator();
                    }catch (IOException | ClassNotFoundException e)
                    {
                        System.out.println("no saved Game");
                    }


                }
                else if (menuNumber == 5) {
                    maze.displayTheDungeon();
                }

            } while (menuNumber != 4 && !maze.checkForWin());
        }while(playAgain());
    }

    
    
   private static int menu()
   {
       String input;
       int choice;
       boolean correctinput;
       Scanner kb = new Scanner(System.in);
       
       do
       {
    	   
           System.out.println("1.Move");
           System.out.println("2.Save");
           System.out.println("3.Load");
           System.out.println("4.QUIT");
           input = kb.nextLine();
           
           correctinput = Pattern.matches("[1-5]",input);
           
       }while(!correctinput);
       
       
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
        }while(!correctinput);
        if(again.equals("Y") || again.equals("y"))
        {
            correctinput = true;
        }
        else correctinput = false;
        return correctinput;
    }
    
    
    
    private static void movePlayer(Maze maze, Iterator<TriviaQuestion> qList)
    {
    	
    	
        int choice;
        
        Scanner kb = new Scanner(System.in);
        
        

        	
        System.out.println(" make your move?");
        System.out.println("1) up");
        System.out.println("2) down");
        System.out.println("3) left");
        System.out.println("4) right");
            
            
        choice = kb.nextInt();
        kb.nextLine();
        

        Door door = getDoor(maze, choice);
        
        if( !door.isPermaLocked() )//if door is answered wrong or its a wall
        {
        	
        	if( door.isLocked() )//if question hasnt been asked/answered yet
        	{
        		
        		//answer question
        		TriviaQuestion question = qList.next();
        		
        		question.readQuestion();
        		question.readHint();
        		
        		
        		
        		String input = kb.nextLine();
        		
        		//get player input
        		
        		
        		boolean answer = question.checkAnswer(input); //questionList.checkAnswer();
        		
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
        int newRow;
        int newColumn;
        
    	if(choice==1)
        {
        	
            newRow=r-1;
            maze.getPlayer1().setLocation(newRow,c);
            
        }
        else if(choice==2)
        {
            newRow=r+1;
            maze.getPlayer1().setLocation(newRow,c);
        }
        else if(choice==3)
        {
            newColumn=c-1;
            maze.getPlayer1().setLocation(r,newColumn);
        }
        else if(choice==4)
        {
            newColumn=c+1;
            maze.getPlayer1().setLocation(r,newColumn);
        }
        
    	
    	
    }
    
    
    
    private static Door getDoor(Maze maze, int choice)
    {
    	
    	 int[] loc=maze.getPlayer1().getLocation();
         
         
         int r=loc[0];
         int c=loc[1];

         
         Room room =  maze.getRoom(r, c);
    	
    	if(choice==1)
        {
            return  room.up();

        }
        else if(choice==2)
        {
        	return  room.down();

        }
        else if(choice==3)
        {
        	return  room.left();

        }
        
        
        return  room.right();
        
    	
    
    	
    }
    
    
    
    private static void saveGame(Maze maze, Player p1,ArrayList list) throws IOException
    {
        FileOutputStream fileout = new FileOutputStream("SavedGame.txt");
        ObjectOutputStream objout = new ObjectOutputStream(fileout);
        objout.writeObject(maze);
        objout.writeObject(p1);
        objout.writeObject(list);
        objout.flush();
        objout.close();
    }
    private static ObjectInputStream loadGame(String fileIn) throws IOException
    {
           FileInputStream In = new FileInputStream(fileIn);
        return new ObjectInputStream(In);
    }
}
