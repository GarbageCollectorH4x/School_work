/*team: garbage collector*/

public class TrueFalse extends TriviaQuestion
{



    TrueFalse(String q, String ans, String hint)
    {
        super(q,ans,hint);
    }



    public void readQuestion()
    {
        
        super.readQuestion();

        System.out.println("T/F");

    }



    public boolean checkAnswer(String ans)
    {
        
        return super.checkAnswer(ans);

    }



}