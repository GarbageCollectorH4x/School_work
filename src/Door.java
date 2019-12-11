
import java.io.Serializable;


public class Door implements Serializable 
{


    private boolean isLocked;
    private boolean isPermaLocked;


    private boolean isWall;


    
    public Door() 
    {
    	
    	
        this.isLocked = true;
        this.isPermaLocked = false;
        this.isWall = false;
        
        
    }

    

    public Door(boolean wall) 
    {
    	
        this.isWall = wall;
        this.isPermaLocked = wall;

    }

    

    public boolean isWall() {
        return this.isWall;
    }


    
    public void setLock(boolean lock) 
    {

        this.isPermaLocked = !lock;
        this.isLocked = !lock;

    }


    
    public boolean isPermaLocked() 
    {

        return this.isPermaLocked;

    }


    
    public boolean canInteract() 
    {

        return this.isLocked && (!this.isPermaLocked && !this.isWall);

    }

    
    
    public boolean isLocked() 
    {


        if (this.isWall || this.isPermaLocked)
            return true;


        return this.isLocked;


    }


}


