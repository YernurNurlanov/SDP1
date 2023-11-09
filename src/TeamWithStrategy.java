public class TeamWithStrategy implements Team {
    private final String name;
    private String strategy;
    public TeamWithStrategy(String name, String strategy){
        this.name = name;
        this.strategy = strategy;
    }
    public String name(){
        return name;
    }
    public void setStrategy(FootballStrategy strategy) {
        this.strategy = strategy.play();
    }
    public String getStrategy(){
        return strategy;
    }
}
