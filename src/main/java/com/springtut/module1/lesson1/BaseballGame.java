package com.springtut.module1.lesson1;

public class BaseballGame implements Game {
    private Team homeTeam;
    private Team awayTeam;

    public BaseballGame() {}

    public BaseballGame(Team homeTeam, Team awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    public String playGame() {
        return Math.random() < 0.5 ? getHomeTeam().getName()
                : getAwayTeam().getName() ;
    }
}
