//team: garbage collector



public class Door
{
	
	
	
	private boolean				isLocked;
	private boolean				isPermaLocked;
	

	private boolean				isWall;
	
	
	private TriviaQuestion		question;
	
	
	
	public Door(TriviaQuestion door_question)
	{
		
		this.isLocked =		 	true;
		this.isPermaLocked = 	false;
		

		this.question =			door_question;
		
	}

	

	public Door(boolean wall)
	{
		//pass true if you want to create a wall
		//all other fields in this class wlll be ignored if this value is set to true
		this.isWall =		wall;

	}
	


	public boolean isWall()
	{


		return		this.isWall;


	}

	

	public void readQuestion()
	{

		this.question.readQuestion();

	}
	


	public void readHint()
	{
		if(this.isWall)
			return;

		this.question.readHint();


	}



	public boolean checkAnswer(String input)
	{


		if(this.isWall)
			return false;


		if(!this.isPermaLocked)
		{
			

			this.isLocked = !this.question.checkAnswer(input);


			if( this.isLocked )
				this.isPermaLocked = true;


		}


		return 			this.isLocked;


	}


	
	
	public boolean isLocked()
	{
		

		if(this.isWall)
			return false;
		
		
		if(this.isPermaLocked)
			return this.isPermaLocked;
		
		
		return this.isLocked;
		

	}
	
	
	
}


