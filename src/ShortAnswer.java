/*team: garbage collector*/

public class ShortAnswer extends TriviaQuestion
{


    public ShortAnswer(String q, String ans, String hint)
    {

        super(q, ans, hint);

    }

    

    public boolean checkAnswer(String ans)
    {
    	
    	ans = ans.replaceAll(" ", "");
    	ans = ans.toLowerCase();
    	
    	return super.checkAnswer(ans);

    }


}