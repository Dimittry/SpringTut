package com.springtut.module2.lesson2.entities;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.sql.DataSource;

public class BaseballGame implements Game {
    private Team homeTeam;
    private Team awayTeam;
    private DataSource dataSource;

    public BaseballGame() {}

    public BaseballGame(Team homeTeam, Team awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    @PostConstruct
    public void startGame() {
        System.out.println("Start game");
    }
    @PreDestroy
    public void endGame() {
        System.out.println("End game");
    }

    @Override
    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }
    @Override
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

    public String toString() {
        return String.format("Game between %s at %s", awayTeam.getName(), homeTeam.getName());
    }
}
