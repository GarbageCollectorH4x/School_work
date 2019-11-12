//team: garbage collector


public class Room{

    private boolean         isLocked;
    private boolean         isPermaLocked;

    private TriviaQuestion  question;


    public Room(TriviaQuestion room_q){

        this.isLocked =         true;
        this.isPermaLocked =    false;

        this.question =         room_q;

    }


}