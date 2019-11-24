//team: garbage collector

import java.util.ArrayList;

import javax.lang.model.util.ElementScanner6;


public class RoomFactory
{
    private final int MAX_ROW = 4;
    private final int MAX_COL =  4;

    private DoorFactory doorMaker;

    public RoomFactory()
    {

        this.doorMaker = new DoorFactory();

    }

    
    public Room[][] createSquareRoomMap( ArrayList<TriviaQuestion> questions )
    {

        //this equation will give us how many doors total we need to make a square map
        //int totalDoorAmt = ( (MAX_COL - 1) * MAX_ROW ) + ((MAX_COL - 1) * MAX_ROW); //4X4 = 24 doors

        //int totalRoomAmt = MAX_ROW * MAX_COL;

        //tab: Top And Bottom
        //int tabWalls = MAX_COL * 2;

        //lar: Left And Right
        //int larWalls = MAX_ROW * 2;

        Room[][] rooms = new Room[MAX_ROW][MAX_COL];

        
        //this is assuming there are enough questions/doors to fill a square
        ArrayList<Door> dList = this.doorMaker.createDoorList( questions );
        int dIndex = 0;


        for(int i = 0; i < MAX_ROW; i++)
        {

            for(int j = 0; i < MAX_COL; j++)
            {


                Room nRoom = new Room();


                if( i == 0 )
                {
                    nRoom.setUp( this.doorMaker.wall() );
                    nRoom.setDown( dList.get( dIndex++ ) );
                }
                else if( i == MAX_ROW - 1 )
                {
                    nRoom.setUp( rooms[i-1][j].down() );
                    nRoom.setDown( this.doorMaker.wall() );
                }
                else
                {
                    nRoom.setUp( rooms[i-1][j].down() );
                    nRoom.setDown( dList.get( dIndex++ ) );
                }


                if( j == 0 )
                {
                    nRoom.setLeft( this.doorMaker.wall() );
                    nRoom.setRight( dList.get( dIndex++ ) );
                }
                else if( j == MAX_COL - 1 )
                {
                    nRoom.setLeft( rooms[i][j-1].right() );
                    nRoom.setRight( this.doorMaker.wall() );
                }
                else
                {
                    nRoom.setLeft( rooms[i][j-1].right() );
                    nRoom.setRight( dList.get( dIndex++ ) );
                }                


                rooms[i][j] =   nRoom;

            }

        }



        return rooms;
        
    }

    



}







