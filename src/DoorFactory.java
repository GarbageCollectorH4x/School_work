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
    

}