/*team: garbage collector*/

public class TrueFalse implements TriviaQuestion
{



    TrueFalse(String q, char ans, String hint)
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