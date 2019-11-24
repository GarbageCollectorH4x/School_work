//team: garbage collector

import java.util.ArrayList;

public class TriviaQuestion
{
	
	

    private String      question;
    private String      answer;
    private String      hint;



    private ArrayList<String>   choiceList;



	private boolean     solved;
	
	


    public TriviaQuestion(String q, String a, String h, String fa0, String fa1, String fa2)
	{

        this.question = 	q;
        this.answer =   	a;
        this.hint =			h;
        
    
        this.solved =       false;
		
    
        this.choiceList = new ArrayList<String>();
        this.choiceList.add( answer );
        this.choiceList.add( fa0 );
        this.choiceList.add( fa1 );
        this.choiceList.add( fa2 );

    
        Collections.shuffle( this.choiceList );

    }



    public void readQuestion()
    {

        System.out.println( question );


        
        for(int i = 0;   i < this.choiceList.size();  i++)
        {

            System.out.println(  (i+1) + ")" + this.choiceList.get( i )  );

        }

    }



    public void readHint()
    {

        System.out.println("HINT: " + this.hint);

    }



    public boolean checkAnswer(String input)
    { 


        int inputNum = Integer.parseInt( input );
        

        if( (inputNum <= this.choiceList.size()) && inputNum > 0 )
        {
            

            inputNum--;


            if( this.answer.equals( this.choiceList.get( inputNum ) ) )
            {


                this.solved = true;
            
            
            }


        }
        else
        {


            System.out.println( "WARNING:INVALID INPUT -> '" + input + "''");


        }


        return      this.solved;


    }



    public boolean isSolved()
    {

        return      this.solved;

    }

}//end class TriviaQuestion