public class Main {
    public static void main(String[] args) {
        FootballLeague league = FootballLeague.getInstance();

        Observer observer1 = new LeagueObserver("Observer 1");
        Observer observer2 = new LeagueObserver("Observer 2");
        league.addObserver(observer1);
        league.addObserver(observer2);

        TeamFactory teamWithNumOfPlayersFactory = new TeamWithNumOfPlayersFactory();
        TeamFactory teamWithStrategyFactory = new TeamWithStrategyFactory();
        FootballStrategy BarcaStrategy = new OffensiveStrategy();
        BarcaStrategy = new PressingDecorator(BarcaStrategy);
        Team team1 = teamWithStrategyFactory.createTeam("Barcelona", BarcaStrategy.play());
        Team team2 = teamWithNumOfPlayersFactory.createTeam("Manchester United", 3);
        league.addTeam(team1);

        league.removeObserver(observer2);
        TeamAdapter adaptedTeam2 = new TeamAdapter((TeamWithNumOfPlayers) team2);
        league.addTeam(adaptedTeam2);


    }
}