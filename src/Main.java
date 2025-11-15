import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileNotFoundException;

public abstract class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("Scoreboard.txt");
        Scanner s = new Scanner(f);
        String[] game;
        int[] wins = new int[] {};
        String[] teams = new String[] {};
        int index1;
        int index2;
        while (s.hasNextLine()) {
            boolean isTeam1 = true;
            int point1 = 0;
            int point2 = 0;
            game = s.nextLine().split(" ");
            if (contains(teams, game[0])) index1 = index(teams, game[0]); else {
                teams = addElement(teams, game[0]);
                index1 = index(teams, game[0]);
                wins = addElement(wins, 0);
            }
            if (contains(teams, game[1])) index2 = index(teams, game[1]); else {
                teams = addElement(teams, game[1]);
                index2 = index(teams, game[1]);
                wins = addElement(wins, 0);
            }
            for (int i = 0; i < game.length - 2; i++) {
                if (isTeam1) {
                    point1 += Integer.parseInt(game[i + 2]);
                    if ("0".equals(game[i + 2])) isTeam1 = false;
                } else {
                    point2 += Integer.parseInt(game[i + 2]);
                    if ("0".equals(game[i + 2])) isTeam1 = true;
                }
            }
            if (point1 > point2) wins[index1]++;
            if (point2 > point1) wins[index2]++;
        }
        System.out.println(Arrays.toString(teams));
        System.out.println(Arrays.toString(wins));
    }
    public static boolean contains(String[] x, String y) {
        for (String s : x) if (y.equals(s)) return true;
        return false;
    }
    public static int index(String[] x, String y) {
        for (int i = 0; i < x.length; i++) if (y.equals(x[i])) return i;
        return -1;
    }
    public static String[] addElement(String[] x, String y) {
        String[] temp = new String[x.length + 1];
        System.arraycopy(x, 0, temp, 0, x.length);
        temp[x.length] = y;
        return temp;
    }
    public static int[] addElement(int[] x, int y) {
        int[] temp = new int[x.length + 1];
        System.arraycopy(x, 0, temp, 0, x.length);
        temp[x.length] = y;
        return temp;
    }
}