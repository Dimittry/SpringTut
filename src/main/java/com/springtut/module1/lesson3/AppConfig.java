package com.springtut.module1.lesson3;

import com.springtut.module1.lesson3.entities.BaseballGame;
import com.springtut.module1.lesson3.entities.Game;
import com.springtut.module1.lesson3.entities.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

//@Configuration
//@ComponentScan(basePackages = "com.springtut.module1.lesson2")
public class AppConfig {
    /*
    @Autowired
    private DataSource dataSource;

    @Autowired @Qualifier("redSox")
    private Team home;
    @Autowired @Qualifier("cubs")
    private Team away;
    @Bean
    public Game game() {
        BaseballGame baseballGame = new BaseballGame(home, away);
        baseballGame.setDataSource(dataSource);
        return baseballGame;
    }
    */
    /*
    @Bean
    public Team redSox() {
        return new RedSox();
    }

    @Bean
    public Team cubs() {
        return new Cubs();
    }
    */
}
