//team: garbage collector

import java.io.Serializable;
import java.util.Scanner;

public class Player implements Serializable {

    private String p_name;
    private int[] location;

    public Player()
    {
        this.p_name = readPlayerName();
        location = new int[2];
    }
    public Player(String name)
    {
        this.p_name = name;
        location = new int[2];
    }

    private static String readPlayerName()
    {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter player name.");
        return input.nextLine();
    }
    public void setLocation(int x, int y)
    {
        int [] newloc = new int[2];
        newloc[0] = x;
        newloc[1] = y;
        location = newloc;
    }
    public int[] getLocation()
    {
        return location;
    }
    public String getP_name()
    {
        return this.p_name;
    }
}