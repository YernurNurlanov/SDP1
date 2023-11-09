class TeamAdapter extends TeamWithStrategy {
    public TeamAdapter(TeamWithNumOfPlayers adaptedTeam) {
        super(adaptedTeam.name(), TeamAdapter.determineStrategy(adaptedTeam.players()));
    }
    private static String determineStrategy(int players) {
        if (players > 2) {
            return new OffensiveStrategy().play();
        } else {
            return new DefensiveStrategy().play();
        }
    }
}
