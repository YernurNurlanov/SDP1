import java.util.Objects;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ans = "";
        while(!Objects.equals(ans, "yes") && !ans.equals("no")){
            System.out.println("Welcome! Here you can create a football league. Ready to start?Yes/No");
            ans = sc.nextLine();
            ans = ans.toLowerCase();
        }
        if (ans.equals("no")){
            System.exit(0);
        }
        FootballLeague league = FootballLeague.getInstance();
        System.out.println("The league has been established.");
        while (true) {
            while (!Objects.equals(ans, "1") && !ans.equals("2") && !ans.equals("3") && !ans.equals("4") && !ans.equals("5")
                    && !ans.equals("6") && !ans.equals("7") && !ans.equals("8")) {
                System.out.println("""
                        Choose one of these actions:(enter the number)
                        1. Add a team and its strategy.
                        2. Add a team and number of players that should be only in the opponent's half.
                        3. Add a subscriber.
                        4. List of teams.
                        5. List of subscribers.
                        6. Delete team.
                        7. Delete subscriber.
                        8. Quit.""");
                ans = sc.nextLine();
            }
            switch (ans) {
                case "1" -> {
                    TeamFactory teamWithStrategyFactory = new TeamWithStrategyFactory();
                    String name;
                    boolean teamExists;
                    do {
                        System.out.println("Please enter the name of the team.");
                        name = sc.nextLine();
                        String finalName = name;
                        teamExists = FootballLeague.teams.stream()
                                .anyMatch(team -> team.name().equals(finalName));
                        if (teamExists) {
                            System.out.println("Team with the name '" + name + "' already exists. Please enter a unique name.");
                        }
                    } while (teamExists);
                    while (!Objects.equals(ans, "offensive") && !ans.equals("defensive")) {
                        System.out.println("Now enter the strategy of the team? offensive/defensive");
                        ans = sc.nextLine();
                        ans = ans.toLowerCase();
                    }
                    FootballStrategy strategy;
                    if (ans.equals("offensive")) {
                        strategy = new OffensiveStrategy();
                    } else {
                        strategy = new DefensiveStrategy();
                    }
                    if (strategy.play().equals("plays offensive football")) {
                        while (!Objects.equals(ans, "yes") && !ans.equals("no")) {
                            System.out.println("Do you want this team to play with pressing? Yes/No");
                            ans = sc.nextLine();
                            ans = ans.toLowerCase();
                        }
                        if (ans.equals("yes")) {
                            strategy = new PressingDecorator(strategy);
                        }
                    }
                    Team team1 = teamWithStrategyFactory.createTeam(name, strategy.play());
                    league.addTeam((TeamWithStrategy) team1);
                    System.out.println("Team " + name + " has been added");
                }
                case "2" -> {
                    TeamFactory teamWithNumOfPlayersFactory = new TeamWithNumOfPlayersFactory();
                    String name;
                    boolean teamExists;
                    do {
                        System.out.println("Please enter the name of the team.");
                        name = sc.nextLine();
                        String finalName = name;
                        teamExists = FootballLeague.teams.stream()
                                .anyMatch(team -> team.name().equals(finalName));
                        if (teamExists) {
                            System.out.println("Team with the name '" + name + "' already exists. Please enter a unique name.");
                        }
                    } while (teamExists);
                    ans = "";
                    while (!ans.equals("0") && !ans.equals("1") && !ans.equals("2") && !ans.equals("3") && !ans.equals("4") && !ans.equals("5") && !ans.equals("6")) {
                        System.out.println("Now enter the number of players that should be only in the opponent's half of the football pitch. [0,6]");
                        ans = sc.nextLine();
                    }
                    Team team2 = teamWithNumOfPlayersFactory.createTeam(name, Integer.parseInt(ans));
                    TeamWithNumOfPlayers.teamsName.add(name);
                    TeamWithNumOfPlayers.teamsPlayers.add(Integer.parseInt(ans));
                    TeamAdapter adaptedTeam2 = new TeamAdapter((TeamWithNumOfPlayers) team2);
                    if (adaptedTeam2.getStrategy().equals("plays offensive football")) {
                        while (!Objects.equals(ans, "yes") && !ans.equals("no")) {
                            System.out.println("Do you want this team to play with pressing? Yes/No");
                            ans = sc.nextLine();
                            ans = ans.toLowerCase();
                        }
                        if (ans.equals("yes")) {
                            FootballStrategy strategy = new OffensiveStrategy();
                            strategy = new PressingDecorator(strategy);
                            adaptedTeam2.setStrategy(strategy);
                        }
                    }
                    ans = "";
                    league.addTeam(adaptedTeam2);
                    System.out.println("Team " + name + " has been added");
                }
                case "3" -> {
                    System.out.println("Please enter the name of subscriber.");
                    ans = sc.nextLine();
                    Observer observer = new LeagueObserver(ans);
                    league.addObserver(observer);
                    System.out.println("Subscriber " + ans + " has been added.");
                    ans = "";
                }
                case "4" -> {
                    int i = 0;
                    System.out.println("List of teams.");
                    int index;
                    boolean teamPrinted = false;
                    for (TeamWithStrategy team : FootballLeague.teams){
                        i++;
                        if (TeamWithNumOfPlayers.teamsName.contains(team.name())){
                            index = TeamWithNumOfPlayers.teamsName.indexOf(team.name());
                            System.out.println(i + ". " + team.name() + " " + team.getStrategy() + ". ( "
                                    + TeamWithNumOfPlayers.teamsPlayers.get(index)
                                    + " players should be only in the opponent's half of the football pitch. )");
                            teamPrinted = true;
                        }
                        if (!teamPrinted) {
                            System.out.println(i + ". " + team.name() + " " + team.getStrategy());
                        } else {
                            teamPrinted = false;
                        }
                    }
                    ans = "";
                }
                case "5" -> {
                    int i = 0;
                    System.out.println("List of subscribers.");
                    for (Observer observer : FootballLeague.observers){
                        i++;
                        System.out.println(i + ". "+ observer.name());
                    }
                    ans = "";
                }
                case "6" -> {
                    int i = 0;
                    int index;
                    System.out.println("List of teams.");
                    for (TeamWithStrategy team : FootballLeague.teams){
                        i++;
                        if (TeamWithNumOfPlayers.teamsName.contains(team.name())){
                            index = TeamWithNumOfPlayers.teamsName.indexOf(team.name());
                            System.out.println(i + ". " + team.name() + " " + team.getStrategy() + ". ( "
                                    + TeamWithNumOfPlayers.teamsPlayers.get(index)
                                    + " players should be only in the opponent's half of the football pitch. )");
                            continue;
                        }
                        System.out.println(i + ". " + team.name() + " " + team.getStrategy());
                    }
                    ans = "0";
                    while (Integer.parseInt(ans) < 1 || Integer.parseInt(ans) > FootballLeague.teams.size()){
                        System.out.println("Enter the number of team you want to delete.");
                        ans = sc.nextLine();
                    }
                    FootballLeague.teams.remove(Integer.parseInt(ans) - 1);
                    System.out.println("Team has been removed");
                    ans = "";
                }
                case "7" -> {
                    int i = 0;
                    System.out.println("List of subscribers.");
                    for (Observer observer : FootballLeague.observers) {
                        i++;
                        System.out.println(i + ". " + observer.name());
                    }
                    ans = "0";
                    while (Integer.parseInt(ans) < 1 || Integer.parseInt(ans) > FootballLeague.observers.size()) {
                        System.out.println("Enter the number of the subscriber you want to delete.");
                        ans = sc.nextLine();
                    }
                    FootballLeague.removeObserver(FootballLeague.observers.get(Integer.parseInt(ans) - 1));
                    System.out.println("Subscriber has been removed");
                    ans = "";
                }
                case "8" -> System.exit(0);
            }
        }
    }
}