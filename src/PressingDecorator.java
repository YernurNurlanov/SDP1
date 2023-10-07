public class PressingDecorator implements FootballStrategy {
    private FootballStrategy decoratedStrategy;
    public PressingDecorator(FootballStrategy decoratedStrategy) {
        this.decoratedStrategy = decoratedStrategy;
    }
    @Override
    public String play() {
        return decoratedStrategy.play() + " with pressing";
    }
}
