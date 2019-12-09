import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class TriviaMainTest {

    Maze maze;
    Player p1;
    Database db;
    Iterator<TriviaQuestion> Qlist;
    @BeforeEach
    void setUp() {
        p1 = new Player("billy");
        maze = new Maze(p1);
        db = new Database();
        Qlist = db.getList().iterator();

    }

    @Test
    void moveBehaviorTest()
    {

    }
}