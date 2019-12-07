//team: garbage collector


public abstract class TriviaQuestion
{
	
	

    private String      question;
    private String      answer;
    private String      hint;



	protected boolean     solved;
	
	

    public TriviaQuestion(String q, String a, String h)
	{

        this.question = 	q;
        this.answer =   	a.replaceAll(" ", "").toLowerCase();
        this.hint =			h;
        
    
        this.solved =       false;
		

    }



    public void readQuestion()
    {

        System.out.println( this.question );

    }



    public void readHint()
    {

        System.out.println("HINT: " + this.hint);

    }



    public boolean checkAnswer(String input)
    { 
    	
    	input = input.replaceAll(" ", "");
    	input = input.toLowerCase();

        if( this.answer.equals( input ) )
            this.solved = true;


        return this.solved;


    }



    public boolean isSolved()
    {

        return      this.solved;

    }


    
}//end class TriviaQuestion