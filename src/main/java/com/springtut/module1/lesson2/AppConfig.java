package com.springtut.module1.lesson2;

import com.springtut.module1.lesson2.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com.springtut.module1.lesson2")
public class AppConfig {
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
