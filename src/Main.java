import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public abstract class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("Scoreboard.txt");
        Scanner s = new Scanner(f);
        String[] game;
        ArrayList<Integer> wins = new ArrayList<>();
        ArrayList<String> teams = new ArrayList<>();
        int[] index = new int[2];
        while (s.hasNextLine()) {
            boolean isTeam1 = true;
            int[] point = {0, 0};
            game = s.nextLine().split(" ");
            for (int i = 0; i < 2; i++)
                if (teams.contains(game[i])) index[i] = teams.indexOf(game[i]); else {
                    teams.add(game[i]);
                    index[i] = teams.indexOf(game[i]);
                    wins.add(0);
                }
            for (int i = 0; i < game.length - 2; i++)
                if (isTeam1) {
                    point[0] += Integer.parseInt(game[i + 2]);
                    if ("0".equals(game[i + 2])) isTeam1 = false;
                } else {
                    point[1] += Integer.parseInt(game[i + 2]);
                    if ("0".equals(game[i + 2])) isTeam1 = true;
                }
            if (point[0] > point[1]) wins.set(index[0], wins.get(index[0]) + 1);
            if (point[1] > point[0]) wins.set(index[1], wins.get(index[1]) + 1);
        }
        System.out.println(teams);
        System.out.println(wins);
    }
}