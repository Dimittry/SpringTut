package com.springtut.module1.lesson2;

import com.springtut.module1.lesson2.entities.*;
import com.sun.tracing.dtrace.Attributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.util.List;

@Configuration
@ComponentScan(basePackages = "com.springtut.module1.lesson2")
public class AppConfig {
    @Autowired
    private DataSource dataSource;
    /*
    @Autowired @Qualifier("redSox")
    private Team home;
    @Autowired @Qualifier("cubs")
    private Team away;
    */
    @Autowired
    private List<Team> teams;
    @Bean @Scope("prototype")
    public Game game() {
        //BaseballGame baseballGame = new BaseballGame(home, away);
        BaseballGame baseballGame = new BaseballGame(teams.get(0), teams.get(1));
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
