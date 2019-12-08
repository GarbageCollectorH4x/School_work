//team: garbage collector

import java.io.Serializable;

public class RoomFactory implements Serializable
{
    private final int MAX_ROW = 5;
    private final int MAX_COL =  5;

    private DoorFactory doorMaker;

    public RoomFactory()
    {

        this.doorMaker = new DoorFactory();

    }

    
    public Room[][] createSquareRoomMap(  )
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
        
        int dIndex = 0;


        for(int i = 0; i < MAX_ROW; i++)
        {

            for(int j = 0; j < MAX_COL; j++)
            {


                Room nRoom = new Room();


                if( i == 0 )
                {
                	//System.out.println("i=0 : " + i);
                    nRoom.setUp( this.doorMaker.wall() );
                    nRoom.setDown( this.doorMaker.createDoor() );
                }
                else if( i == MAX_ROW - 1 )
                {
                	//System.out.println("i=" + i);
                    nRoom.setUp( rooms[i-1][j].down() );
                    nRoom.setDown( this.doorMaker.wall() );
                }
                else
                {
                	//System.out.println("i="+ i);
                    nRoom.setUp( rooms[i-1][j].down() );
                    nRoom.setDown( this.doorMaker.createDoor() );
                }


                if( j == 0 )
                {
                	//System.out.println("j=0 : " + j);
                    nRoom.setLeft( this.doorMaker.wall() );
                    nRoom.setRight( this.doorMaker.createDoor() );
                }
                else if( j == MAX_COL - 1 )
                {
                    nRoom.setLeft( rooms[i][j-1].right() );
                    nRoom.setRight( this.doorMaker.wall() );
                }
                else
                {
                    nRoom.setLeft( rooms[i][j-1].right() );
                    nRoom.setRight( this.doorMaker.createDoor() );
                }                

                
                rooms[i][j] =   nRoom;

            }

        }



        return rooms;
        
    }

    



}







