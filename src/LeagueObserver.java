public class LeagueObserver implements Observer{
    private String name;
    public LeagueObserver(String name) {
        this.name = name;
    }
    @Override
    public void update(String message) {
        System.out.println(name + " received an update: " + message);
    }
}
