//team: garbage collector
//fields: rooms Room[][]
//        Player player
//func:   +Maze(row,column)

public class Maze
{
	
	
	private final MAZE_X =		5;
	private final MAZE_Y =		5;

	
	private ArrayList< TriviaQuestion >		questionList;


    private Player      player1;


    private Room[][]        maze_rooms;	
	
	
	
	public Maze()
	{
		
		player1 =		new Player();
		
		
		createMaze( MAZE_X, MAZE_Y );
		
	}
	
	

    public Maze(int row, col)
	{
		
	
		
    }
	
	

	private createMaze( int row, int col )
	{
		
		maze_rooms =		new Room[ row ][ col ];
		
		
		for( int x = 0; x < row; x++ )
		{
			
			
			for( int y = 0; y < col; y++ )
			{
				
				//make new room object
				
				
				
			}
			
			
		}
		
	}
	
	
	
	public void setQuestionList( ArrayList<TriviaQuestion> qList)
	{
		
		Collections.shuffle( qList );
		
		this.questionList =		qList;
		
	}

}