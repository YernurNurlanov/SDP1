public class PressingDecorator extends OffensiveDecorator{
    public PressingDecorator(FootballStrategy decoratedStrategy) {
        this.decoratedStrategy=decoratedStrategy;
    }
    public String play(){
        return decoratedStrategy.play()+" with pressing";
    }
}
