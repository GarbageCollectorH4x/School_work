import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MazeTest {

    @Test
    void checkForWin() {
        Player p1 = new Player("pablo");
        p1.setLocation(4,4);
        Maze maze = new Maze(p1);
        assertTrue(maze.checkForWin());

        p1.setLocation(4,2);
        maze = new Maze(p1);
        assertFalse(maze.checkForWin());
    }

}