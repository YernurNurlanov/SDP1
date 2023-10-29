public class TeamWithStrategyFactory implements TeamFactory{
    public Team createTeam(String name, Object strategy) {
        return new TeamWithStrategy(name, (String) strategy);
    }
}
