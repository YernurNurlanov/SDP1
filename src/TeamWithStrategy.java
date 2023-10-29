public class TeamWithStrategy implements Team {
    private String name;
    private String strategy;
    public TeamWithStrategy(String name, String strategy){
        this.name = name;
        this.strategy = strategy;
    }
    public String getName(){
        return name;
    }
    public String getStrategy(){
        return strategy;
    }
}
