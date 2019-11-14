//team: garbage collector

public class TriviaQuestion
{
	
	

    private String      question;
    private String      answer;
    private String      hint;
	
	
	
	private String[]	filler_answer;
	


    public TriviaQuestion(String q, String a, String h, String fa0, String fa1, String fa2)
	{

        this.question = 	q;
        this.answer =   	a;
		this.hint =			h;
		
		
		this.filler_answer = 	new String[]{ fa0, fa1, fa2 };

    }



}//end class TriviaQuestion