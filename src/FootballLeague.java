import java.util.ArrayList;
import java.util.List;
public class FootballLeague {
    private static FootballLeague instance;
    public static List<Team> teams;
    private FootballLeague() {
        teams = new ArrayList<>();
    }
    public static FootballLeague getInstance(){
        if (instance == null) {
            instance = new FootballLeague();
        }
        return instance;
    }
    public void addTeam(Team team){
        teams.add(team);
    }
}

