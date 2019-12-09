import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MazeTest {

    @Test
    void checkForWin() {
        Player p1 = new Player("pablo");
        Maze maze = new Maze(p1);
        maze.getPlayer1().setLocation(4,4);
        assertTrue(maze.checkForWin());

        p1.setLocation(4,2);
        maze = new Maze(p1);
        assertFalse(maze.checkForWin());
    }

    @Test
    void movePlayerLocation()
    {
        Player p1 = new Player("rob");
        Maze maze = new Maze(p1);

        maze.movePlayerLocation(2);

        int[] arr = maze.getPlayer1().getLocation();
        int r = arr[0];

        assertEquals(1,r);


    }

    @Test
    void pathExists()
    {
        Player p1 = new Player("pablo");
        Maze maze = new Maze(p1);
        assertTrue(maze.pathExists());

        maze.getRoom(0,0).down().setLock(false);
        maze.getRoom(0,1).down().setLock(false);
        maze.getRoom(0,2).down().setLock(false);
        maze.getRoom(0,3).down().setLock(false);
        maze.getRoom(0,4).down().setLock(false);

        assertFalse(maze.pathExists());
    }
}