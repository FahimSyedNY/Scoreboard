import java.awt.desktop.ScreenSleepEvent;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public abstract class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("Scoreboard.txt");
        Scanner s = new Scanner(f);
        String[] game = new String[] {};
        int[] points = new int[] {};
        String[] teams = new String[] {};
        boolean isTeam1 = true;
        int index1 = 0;
        int index2 = 0;
        while (s.hasNextLine()) {
            game = s.nextLine().split(" ");
            if (contains(teams, game[0])) index1 = index(teams, game[0]); else
            if (contains(teams, game[1])) index1 = index(teams, game[1]);
            for (int i = 0; i < game.length - 2; i++) {
                if (isTeam1)
                points[i] = Integer.parseInt(game[i + 2]);
            }
        }
    }
    public static boolean contains(String[] x, String y) {
        for (int i = 0; i < x.length; i++) if (y.equals(x[i])) return true;
        return false;
    }
    public static int index(String[] x, String y) {
        for (int i = 0; i < x.length; i++) if (y.equals(x[i])) return i;
        return -1;
    }
}