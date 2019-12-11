//team: garbage collector

import java.util.ArrayList;


public class RoomFactory 
{
	
	
    private final int MAX_ROW = 5;
    private final int MAX_COL = 5;

    private Door wallRef;
    
    

    public RoomFactory() 
    {

        this.wallRef = new Door(true);

    }


    public Room[][] createSquareRoomMap() 
    {
    	

        Room[][] rooms = new Room[MAX_ROW][MAX_COL];
        int dIndex = 0;


        for (int i = 0; i < MAX_ROW; i++) {

            for (int j = 0; j < MAX_COL; j++) {


                Room nRoom = new Room();


                if (i == 0) {
                    nRoom.setUp(this.wallRef);
                    nRoom.setDown(new Door());
                } else if (i == MAX_ROW - 1) {
                    nRoom.setUp(rooms[i - 1][j].down());
                    nRoom.setDown(this.wallRef);
                } else {
                    nRoom.setUp(rooms[i - 1][j].down());
                    nRoom.setDown(new Door());
                }


                if (j == 0) {
                    nRoom.setLeft(this.wallRef);
                    nRoom.setRight(new Door());
                } else if (j == MAX_COL - 1) {
                    nRoom.setLeft(rooms[i][j - 1].right());
                    nRoom.setRight(this.wallRef);
                } else {
                    nRoom.setLeft(rooms[i][j - 1].right());
                    nRoom.setRight(new Door());
                }


                rooms[i][j] = nRoom;

            }

        }


        return rooms;

    }


}







