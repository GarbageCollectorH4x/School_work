/*team: garbage collector*/

import java.io.Serializable;

public class TrueFalse extends TriviaQuestion implements Serializable
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