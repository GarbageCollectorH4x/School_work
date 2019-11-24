//team: garbage collector

import java.util.ArrayList;

import javax.lang.model.util.ElementScanner6;

public class DoorFactory
{


    private Door wallRef;



    public DoorFactory()
    {

        this.wallRef = new Door(true);

    }



    public Door createDoor(TriviaQuestion question)
    {
        
        return new Door(question);

    }



    public Door wall()
    {

        return this.wallRef;

    }



    public ArrayList<Door> createDoorList(ArrayList<TriviaQuestion> questions)
    {

        ArrayList<Door> temp = new ArrayList<Door>();

        for(TriviaQuestion q : questions)
        {

            Door newDoor = new Door(q);
            
            temp.add( newDoor );

        }

        return temp;

    }



    public Door[][] createSquareDoorMap( ArrayList<TriviaQuestion> questions, int row, int col )
    {

        Door[][] doorMap =      new Door[ row+2 ][ col+2 ];


        int qIndex = 0;
        
        
        for( int i = 0; i < row+1; i++ )
        {


            for( int j = 0; j < col+1; j++ )
            {

                if( i == 0 
                ||  i == row+1 
                ||  j == 0 
                ||  j == col+1  )
                {

                    doopMap[i][j] =     this.wallRef;

                }
                else
                {
                    
                    doorMap[i][j] =     new Door( questions.get(qIndex++) );

                }

            }

        }


        return doorMap;

    }

    

}