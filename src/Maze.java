//team: garbage collector
//fields: rooms Room[][]
//        Player player
//func:   +Maze(row,column)

import java.io.Serializable;

public class Maze implements Serializable {

    private Player player1;

    private Room[][] maze;

    public Maze(Player player)
    {
    	RoomFactory rm = new RoomFactory();
        this.maze = rm.createSquareRoomMap();
        setPlayer1(player);
        playerPlacement();
        setExit();
    }


    public Player getPlayer1() {
        return player1;
    }

    private void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    private void playerPlacement()
    {
        int row = 0;
        int column = 0;
        setPlayerLocation(row,column);
    }
    
    
    public void printMazeroom()
    {
        int[] heroloc=player1.getLocation();

        int r=heroloc[0];
        int c=heroloc[1];
        String room[] = maze[r][c].draw();
        System.out.println(room[0]);
        System.out.println(room[1]);
        System.out.println(room[2]);
    }
    
    
    public void displayTheDungeon()
    {

        int[] herolocation=player1.getLocation();
        maze[herolocation[0]][herolocation[1]].setShowHero('H');
        
        
        for(int r=0;r<5;r++)
        {
        	
        	
            String[] rowstr= new String[3];
            
            
            rowstr[0]="";
            rowstr[1]="";
            rowstr[2]="";
            
            
            for(int c=0;c<5;c++)
            {
      
                rowstr[0]+=maze[r][c].row0();
                rowstr[1]+=maze[r][c].row1();
                rowstr[2]+=maze[r][c].row2();
                
            }
            for(int x=0;x<3;x++)
            {
            	
                System.out.println(rowstr[x]);
                
            }
        }
        
        maze[herolocation[0]][herolocation[1]].setShowHero(' ');
    }
    
    
    private void setExit()
    {
    	
    	
        maze[4][4].setShowHero('E');
        
        
    }

    private void setPlayerLocation(int row, int column)
    {

        player1.setLocation(row, column);
        maze[row][column].visit();

    }

    public void movePlayerLocation(int x)
    {

        int[] loc= player1.getLocation();
        int r=loc[0];
        int c=loc[1];


        switch(x)
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


        player1.setLocation(r, c);
        maze[r][c].visit();

    }
    
    
    public void enterRoom()
    {
    	
    	
        int[] loc=player1.getLocation();
        
        int r=loc[0];
        int c=loc[1];
        
        maze[r][c].visit();
        
        if(maze[r][c].getShowHero() == 'E')
        {


            if(checkForWin())
            {

                System.out.println("congrats " + player1.getP_name() + " you win");

            }
            else
                System.out.println("You are not at the end yet.");

        }
    

    }



    public boolean checkForWin()
    {


        int[] loc = player1.getLocation();

        return loc[0] == 4 && loc[1] == 4;


    }
    
    public int checkPossMoves()
    {
    	int count = 0;
    	
    	
    	for(int i = 0; i < this.maze.length; i++)
    	{
    		
    		for(int j = 0; j < this.maze[i].length; j++)
    		{
    			
    			if( this.maze[i][j].hasBeenVisited() )
    				count += this.maze[i][j].availInteractions();
    			
    		}
    		
    	}
    	if(count == 0)
        {
            System.out.println("UH OH NO MORE POSSIBLE WAYS TO EXIT MAZE. " + player1.getP_name() + " YOU LOSE!");
        }
    	
    	return count;
    	
    }
    
    
    public Room getRoom(int x, int y)
    {
    	
    	return this.maze[x][y];
    	
    }
}