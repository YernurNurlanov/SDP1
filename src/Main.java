public class Main {
    public static void main(String[] args) {
        FootballLeague league = FootballLeague.getInstance();
        FootballStrategy BarcaStrategy = new OffensiveStrategy();
        BarcaStrategy = new PressingDecorator(BarcaStrategy);
        Team team1 = new Team("Barcelona", BarcaStrategy.play());
        TeamWithNumOfPlayers team2 = new TeamWithNumOfPlayers("Manchester United", 1);
        league.addTeam(team1);
        TeamAdapter adaptedTeam2 = new TeamAdapter(team2);
        league.addTeam(adaptedTeam2);
        for (Team team : FootballLeague.teams ) {
            System.out.println(team.getName()+" "+team.getStrategy());
        }
    }
}