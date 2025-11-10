import java.awt.desktop.ScreenSleepEvent;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("Scoreboard.txt");
        Scanner s = new Scanner(f);
        String[] game = new String[] {};
        int[] points = new int[0];
        while (s.hasNextLine()) {
            game = s.nextLine().split(" ");
            points = new int[game.length - 2];
            for (int i = 0; i < game.length - 2; i++) {
                points[i] = Integer.parseInt(game[i + 2]);
            }
        }
        System.out.print(game[0]);
        System.out.print(game[1]);
        System.out.print(game[2]);
        System.out.print(game[3]);
        System.out.print(game[4]);
        System.out.print(game[5]);
        System.out.print(game[6]);
        System.out.print(game[7]);
        System.out.print(game[8]);
        System.out.print(game[9]);
        System.out.print(game[10]);
        System.out.print(game[11]);
        System.out.print(game[12]);
    }
}