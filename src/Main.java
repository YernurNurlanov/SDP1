public class Main {
    public static void main(String[] args) {
        FootballLeague league = FootballLeague.getInstance();
        league.addTeam(new FootballLeague.Team("Barcelona", new OffensiveStrategy().play()));
        league.addTeam(new FootballLeague.Team("Manchester United", new DefensiveStrategy().play()));
        for (FootballLeague.Team team : FootballLeague.teams ) {
            System.out.println(team.getName()+" "+team.getStrategy());
        }
    }
}