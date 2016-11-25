package com.springtut.module2.lesson2;

import com.springtut.module2.lesson2.entities.BaseballGame;
import com.springtut.module2.lesson2.entities.Game;
import com.springtut.module2.lesson2.entities.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import javax.sql.DataSource;
import java.util.List;

@Configuration
@ComponentScan(basePackages = "com.springtut.module2.lesson2")
@EnableAspectJAutoProxy
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
    @Bean //(initMethod="startGame", destroyMethod = "endGame")
//    @Scope("prototype")
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
