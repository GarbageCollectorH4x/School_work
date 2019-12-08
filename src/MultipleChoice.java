/*team: garbage collector*/

import java.util.ArrayList;
import java.util.Collections;

public class MultipleChoice extends TriviaQuestion
{

    private ArrayList<String>   choiceList;

    
    public MultipleChoice(String q, String ans, String hint, 
                        String fa0, String fa1, String fa2){
    	
        super(q,ans,hint);
        this.setChoiceList(ans, fa0, fa1, fa2);
        
    }

    
    private void setChoiceList(String cho1, String cho2,
                                String cho3, String cho4){
        this.choiceList = new ArrayList<String>();
        this.choiceList.add(cho1);
        this.choiceList.add(cho2);
        this.choiceList.add(cho3);
        this.choiceList.add(cho4);

        Collections.shuffle(this.choiceList);
        
    }



    public void readQuestion()
    {

        super.readQuestion();

        for(int i = 0;   i < this.choiceList.size();  i++)
        {

            System.out.println(  (i+1) + ")" + this.choiceList.get( i )  );

        }

    }



    public boolean checkAnswer(String input)
    { 


        int inputNum = Integer.parseInt( input );
        

        if( (inputNum <= this.choiceList.size()) && inputNum > 0 )
        {

            inputNum--;
            super.checkAnswer( this.choiceList.get( inputNum ) );

        }
        else
        {
            System.out.println( "WARNING:INVALID INPUT -> '" + input + "''");
        }


        return      super.isSolved();

    }



}//end MultipleChoice