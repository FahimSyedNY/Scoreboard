import java.io.FileNotFoundException;
import java.io.File;
import java.util.*;

public abstract class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("Scoreboard.txt");
        Scanner s = new Scanner(f);
        String[] game;
        Map<String, Integer> scores = new HashMap<>();
        while (s.hasNextLine()) {
            boolean isTeam1 = true;
            int[] point = {0, 0};
            game = s.nextLine().split(" ");
            scores.putIfAbsent(game[0], 0);
            scores.putIfAbsent(game[1], 0);
            for (int i = 0; i < game.length - 2; i++)
                if (isTeam1) {
                    point[0] += Integer.parseInt(game[i + 2]);
                    if ("0".equals(game[i + 2])) isTeam1 = false;
                } else {
                    point[1] += Integer.parseInt(game[i + 2]);
                    if ("0".equals(game[i + 2])) isTeam1 = true;
                }
            if (point[0] > point[1]) scores.put(game[0], scores.get(game[0]) + 1);
            if (point[1] > point[0]) scores.put(game[1], scores.get(game[1]) + 1);
        }
        List<Map.Entry<String, Integer>> sortResult = scores.entrySet()
                .stream().sorted(Map.Entry.comparingByValue()).toList();
        System.out.println(sortResult);
    }
}