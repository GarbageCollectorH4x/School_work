//team: garbage collector

import java.util.ArrayList;

public class DoorFactory
{
    private Door wallRef;

    public DoorFactory()
    {
        this.wallRef = new Door(true);
    }

    public Door createDoor()
    {
        return new Door();
    }

    public Door wall()
    {
        return this.wallRef;
    }

    public ArrayList<Door> createDoorList( int amt)
    {
        ArrayList<Door> temp = new ArrayList<Door>();

        for(int i = 0; i < amt; i++)
        {

            Door newDoor = new Door();
            
            temp.add( newDoor );

        }

        return temp;
    }

    public Door[][] createSquareDoorMap( int row, int col )
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
                	doorMap[i][j] =     this.wallRef;
                }
                else
                {
                    doorMap[i][j] =     new Door(  );
                }

            }

        }

        return doorMap;
    }
}