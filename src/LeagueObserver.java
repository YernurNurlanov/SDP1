public record LeagueObserver(String name) implements Observer {
    @Override
    public void update(String message) {
        System.out.println(name + " received an update: " + message);
    }
}
