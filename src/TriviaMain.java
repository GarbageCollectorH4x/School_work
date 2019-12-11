/*
 * 
 * !!!CHEATS!!!
 * When prompted with a question, type '1337' to automatically get question right and unlock door.
 * At player menu, when the "Move" option is presented, enter '5' to print the entire map.  
 * !!!CHEATS!!!
 * 
 */




import java.io.*;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Pattern;

public class TriviaMain implements Serializable 
{
	
	
    private final static String _CHEAT_ = "1337";

    
    
    public static void main(String[] args) 
    {//start main
    	
    	
        int mainMenuChoice = 0;
        
        while (mainMenuChoice != 3) 
        {
        	
            mainMenuChoice = mainMenu();
            
            if (mainMenuChoice == 1) 
            {

                do 
                {

                    Database db = new Database();
                    Iterator<TriviaQuestion> qList = db.getList().iterator();

                    Player player1 = new Player();
                    Maze maze = new Maze(player1);

                    
                    int menuNumber;

                    maze.printMazeroom();
                    System.out.println();

                    do 
                    {

                        menuNumber = menu();

                        
                        switch (menuNumber) 
                        {
                            case 1:
                                moveBehavior(maze, qList);
                                break;
                            case 2:
                                saveBehavior(maze, player1);
                                break;

                            case 3:
                                try 
                                {

                                    ObjectInputStream fileIn = loadGame("SavedGame.txt");
                                    maze = (Maze) fileIn.readObject();
                                    player1 = (Player) fileIn.readObject();
                                    
                                } catch (IOException | ClassNotFoundException e) 
                                {

                                    System.out.println("no saved Game");

                                }
                                break;

                            case 5:
                                maze.displayTheDungeon();
                                break;

                        }


                    } while (menuNumber != 4 && !maze.checkForWin() && maze.pathExists());


                } while (playAgain());

            }

            if (mainMenuChoice == 2) 
            {
            	
                Database dbNewUpload = new Database();
                dbNewUpload = databaseUpload();
                
            }


        }
        
        System.out.println("goodbye");
        
        
    }

    
    
    public static void playerMoveset() 
    {

    	
        System.out.println("make your move?");
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

    private static void moveBehavior(Maze maze, Iterator<TriviaQuestion> qList) 
    {

    	
        movePlayer(maze, qList);
        maze.enterRoom();
        maze.printMazeroom();
        System.out.println();

    }

    private static void saveBehavior(Maze maze, Player player1) 
    {

        try 
        {

            saveGame(maze, player1);

        } catch (IOException e) 
        {

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

            menuChoices();

            input = kb.nextLine();

            correctinput = Pattern.matches("[1-5]", input);

        } while (!correctinput);


        choice = Integer.parseInt(input);


        return choice;

    }

    
    
    private static boolean playAgain() 
    {

        String again;
        boolean correctinput;
        Scanner kb = new Scanner(System.in);


        do 
        {

            System.out.println("\nPlay again (y/n)?");

            again = kb.nextLine();
            correctinput = Pattern.matches("[YyNn]", again);


        } while (!correctinput);


        if (again.equals("Y") || again.equals("y")) 
        {

            correctinput = true;

        } else
            correctinput = false;


        return correctinput;


    }

    
    
    private static void movePlayer(Maze maze, Iterator<TriviaQuestion> qList) 
    {

        String ans;
        boolean choice;
        Scanner kb = new Scanner(System.in);
        
        
        do 
        {
            playerMoveset();
            ans = kb.nextLine();
            choice = Pattern.matches("[1-4]", ans);
        } while (!choice);
        
        
        int num = Integer.parseInt(ans);

        Door door = getDoor(maze, num);

        if (!door.isPermaLocked()) 
        {

            if (door.isLocked()) 
            {


                TriviaQuestion question = qList.next();

                question.readQuestion();
                question.readHint();

                String input = kb.nextLine();
                boolean answer = question.checkAnswer(input);


                if (input.equals(_CHEAT_))
                    answer = true;


                door.setLock(answer);

                if (answer) {
                    System.out.println("Correct!");
                } else {
                    System.out.println("Incorrect!");
                }
                
            }

            if (!door.isLocked()) 
            {

                maze.movePlayerLocation(num);

            }


        } else 
        {

            System.out.println("You cannot move there!");

        }


    }

    
    
    private static Door getDoor(Maze maze, int choice) 
    {

    	
        int[] loc = maze.getPlayer1().getLocation();


        int r = loc[0];
        int c = loc[1];


        Room room = maze.getRoom(r, c);
        Door door = room.right();//default choice

        switch (choice) {

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

    
    
    private static void saveGame(Maze maze, Player p1) throws IOException 
    {
    	
        FileOutputStream fileout = new FileOutputStream("SavedGame.txt");
        ObjectOutputStream objout = new ObjectOutputStream(fileout);
        
        objout.writeObject(maze);
        objout.writeObject(p1);
        objout.flush();
        objout.close();
        
    }

    
    
    private static ObjectInputStream loadGame(String fileIn) throws IOException 
    {
    	
        FileInputStream In = new FileInputStream(fileIn);
        return new ObjectInputStream(In);
        
    }

    
    
    private static Database databaseUpload() 
    {//start db upload method
    	
        Database db = new Database();
        String input;
        int choice;
        boolean correctinput;
        Scanner kb = new Scanner(System.in);

        do 
        {

            System.out.println("What table would you like to upload to?");
            System.out.println("1.Mulitple Choice");
            System.out.println("2.True/False");
            System.out.println("3.ShortAnswer");
            input = kb.nextLine();

            correctinput = Pattern.matches("[1-3]", input);

        } while (!correctinput);


        choice = Integer.parseInt(input);
        String ques, ans, hint, fa1, fa2, fa3;
        
        if (choice == 1) 
        {
        	
            System.out.println("Enter the question.");
            ques = kb.nextLine();
            System.out.println("Enter the correct answer.");
            ans = kb.nextLine();
            System.out.println("Enter a hint.");
            hint = kb.nextLine();
            System.out.println("Enter a wrong answer.");
            fa1 = kb.nextLine();
            System.out.println("Enter another wrong answer.");
            fa2 = kb.nextLine();
            System.out.println("Enter another wrong answer.");
            fa3 = kb.nextLine();

            db.addMultiChoiceQuestion(ques, ans, fa1, fa2, fa3, hint);
        } else if (choice == 2) 
        {
        
        	System.out.println("Enter the question.");
            ques = kb.nextLine();
            System.out.println("Enter the correct answer.");
            ans = kb.nextLine();
            System.out.println("Enter a hint.");
            hint = kb.nextLine();

            db.addTrueFalseQuestion(ques, ans, hint);
            
        } else if (choice == 3) 
        {
        	
            System.out.println("Enter the question.");
            ques = kb.nextLine();
            System.out.println("Enter the correct answer.");
            ans = kb.nextLine();
            System.out.println("Enter a hint.");
            hint = kb.nextLine();

            db.addShortAnsQuestion(ques, ans, hint);
            
        }

        
        return db;
        
        
    }

    
    
    private static int mainMenu() 
    {
    	
    	
        String input;
        int choice;
        boolean correctinput;
        Scanner kb = new Scanner(System.in);

        do 
        {

            System.out.println("1.Start Game");
            System.out.println("2.Load to DB");
            System.out.println("3.Quit");
            input = kb.nextLine();

            correctinput = Pattern.matches("[1-3]", input);

        } while (!correctinput);


        choice = Integer.parseInt(input);


        return choice;

    }
    
    

}