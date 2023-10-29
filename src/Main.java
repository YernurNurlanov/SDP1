public class Main {
    public static void main(String[] args) {
        FootballLeague league = FootballLeague.getInstance();

        Observer observer1 = new LeagueObserver("Observer 1");
        Observer observer2 = new LeagueObserver("Observer 2");
        league.addObserver(observer1);
        league.addObserver(observer2);

        FootballStrategy BarcaStrategy = new OffensiveStrategy();
        BarcaStrategy = new PressingDecorator(BarcaStrategy);
        Team team1 = new Team("Barcelona", BarcaStrategy.play());
        TeamWithNumOfPlayers team2 = new TeamWithNumOfPlayers("Manchester United", 3);
        league.addTeam(team1);

        league.removeObserver(observer2);
        TeamAdapter adaptedTeam2 = new TeamAdapter(team2);
        league.addTeam(adaptedTeam2);


    }
}