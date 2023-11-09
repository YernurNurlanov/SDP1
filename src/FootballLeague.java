import java.util.ArrayList;
import java.util.List;
public class FootballLeague {
    private static FootballLeague instance;
    public static List<TeamWithStrategy> teams;
    public static List<Observer> observers = new ArrayList<>();
    private FootballLeague() {
        teams = new ArrayList<>();
    }
    public static FootballLeague getInstance(){
        if (instance == null) {
            instance = new FootballLeague();
        }
        return instance;
    }
    public void addTeam(TeamWithStrategy team){
        teams.add(team);
        notifyObservers(team.name() + " has been added to the league.");
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }
    public static void removeObserver(Observer observer) {
        observers.remove(observer);
    }
    private void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}

