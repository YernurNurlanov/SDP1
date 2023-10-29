import java.util.ArrayList;
import java.util.List;
public class FootballLeague {
    private static FootballLeague instance;
    public static List<Team> teams;
    private List<Observer> observers = new ArrayList<>();
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
        notifyObservers(team.getName() + " has been added to the league.");
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
    private void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}

