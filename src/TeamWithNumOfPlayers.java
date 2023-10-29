public class TeamWithNumOfPlayers implements Team{
    private String name;
    private int players;
    public TeamWithNumOfPlayers(String name, int players){
        this.name = name;
        this.players = players;
    }
    public String getName(){
        return name;
    }
    public int getPlayers(){
        return players;
    }
}
