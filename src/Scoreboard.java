public class Scoreboard {
    private String[] team = new String[2];
    private int[] point = {0, 0};
    private boolean isTeam1 = true;
    public Scoreboard(String one, String two) {
        team[0] = one;
        team[1] = two;
    }
    public void recordPlay(int x) {
        if (isTeam1) {
            point[0] += x;
            if (0 == x) isTeam1 = false;
        } else {
            point[1] += x;
            if (0 == x) isTeam1 = true;
        }
    }
    public String getScore() {
        String active;
        if (isTeam1) active = team[0]; else active = team[1];
        return point[0] + " - " + point[1] + " - " + active;
    }
}
