import java.util.ArrayList;
import java.util.List;

public record TeamWithNumOfPlayers(String name, int players) implements Team {
    public static List<String> teamsName = new ArrayList<>();
    public static List<Integer> teamsPlayers = new ArrayList<>();
}
