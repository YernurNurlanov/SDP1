class TeamAdapter extends TeamWithStrategy {
    private Team adaptedTeam;
    public TeamAdapter(TeamWithNumOfPlayers adaptedTeam) {
        super(adaptedTeam.getName(), TeamAdapter.determineStrategy(adaptedTeam.getPlayers()));
        this.adaptedTeam = adaptedTeam;
    }
    private static String determineStrategy(int players) {
        if (players > 2) {
            return new OffensiveStrategy().play();
        } else {
            return new DefensiveStrategy().play();
        }
    }
}
