public class Main {
    public static void main(String[] args) {
        FootballLeague league = FootballLeague.getInstance();
        FootballStrategy BarcaStrategy = new OffensiveStrategy();
        FootballStrategy ManUtdStrategy = new DefensiveStrategy();
        BarcaStrategy = new PressingDecorator(BarcaStrategy);
        league.addTeam(new FootballLeague.Team("Barcelona", BarcaStrategy.play()));
        league.addTeam(new FootballLeague.Team("Manchester United", ManUtdStrategy.play()));
        for (FootballLeague.Team team : FootballLeague.teams ) {
            System.out.println(team.getName()+" "+team.getStrategy());
        }
    }
}