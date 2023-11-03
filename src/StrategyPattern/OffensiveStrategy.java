package StrategyPattern;

import StrategyPattern.FootballStrategy;

public class OffensiveStrategy implements FootballStrategy {
    public String play() {
        return "plays offensive football";
    }
}
