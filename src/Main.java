import java.io.FileNotFoundException;
import java.io.File;
import java.util.*;

public abstract class Main {
    public static void main(String[] args) throws FileNotFoundException {
        scoreFromFile();

        //AP Test Cases:
        String info;
        Scoreboard game = new Scoreboard("Red", "Blue");
        info = game.getScore(); // Expected: 0 - 0 - Red
        System.out.println(info);
        game.recordPlay(1);
        info = game.getScore(); // Expected: 1 - 0 - Red
        System.out.println(info);
        game.recordPlay(0);
        info = game.getScore(); // Expected: 1 - 0 - Blue
        System.out.println(info);
        info = game.getScore(); // Expected: 1 - 0 - Blue
        System.out.println(info);
        game.recordPlay(3);
        info = game.getScore(); // Expected: 1 - 3 - Blue
        System.out.println(info);
        game.recordPlay(1);
        game.recordPlay(0);
        info = game.getScore(); // Expected: 1 - 4 - Red
        System.out.println(info);
        game.recordPlay(0);
        game.recordPlay(4);
        game.recordPlay(0);
        info = game.getScore(); // Expected: 1 - 8 - Red
        System.out.println(info);
        Scoreboard match = new Scoreboard("Lions", "Tigers");
        info = match.getScore(); // Expected: 0 - 0 - Lions
        System.out.println(info);
        info = game.getScore(); // Expected: 1 - 8 - Red
        System.out.println(info);
    }
    public static void scoreFromFile() throws FileNotFoundException {
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