//team: garbage collector



public class Door
{
	
	
	
	private boolean				isLocked;
	private boolean				isPermaLocked;
	
	
	
	private TriviaQuestion		question;
	
	
	
	public Door(TriviaQuestion door_question)
	{
		
		this.isLocked =		 	true;
		this.isPermaLocked = 	false;
		
		this.question =			door_question;
		
	}
	
	
	
	public TriviaQuestion getQuestion()
	{
		
		return			this.question;
		
	}
	
	
	
	public boolean isLocked()
	{
		
		if(isPermaLocked)
			return isPermaLocked;
		
		
		return isLocked;
		
	}
	
	
	
}


