public class TeamWithNumOfPlayersFactory implements TeamFactory {
    public Team createTeam(String name, Object strategy) {
        return new TeamWithNumOfPlayers(name, (int) strategy);
    }
}
