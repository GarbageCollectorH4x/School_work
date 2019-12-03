/*team: garbage collector*/

import java.io.Serializable;

public class ShortAnswer extends TriviaQuestion implements Serializable
{


    public ShortAnswer(String q, String ans, String hint)
    {

        super(q, ans, hint);



    }

    

    public boolean checkAnswer(String ans)
    {
    	
        //needs to implement a way to check short answers
    	System.out.println("ShortAnswer.checkAnswer() NOT FINISHED!!!");
    	return false;

    }


    

}