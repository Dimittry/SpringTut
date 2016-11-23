package com.springtut.module1.lesson1;

import org.springframework.context.annotation.*;
import com.springtut.module1.lesson1.entities.*;

import javax.sql.DataSource;

@Configuration
@Import(InfrastructureConfig.class)
public class AppConfig {
    @Bean
    public Game game(DataSource dataSource) {
        BaseballGame baseballGame = new BaseballGame(redSox(), cubs());
        baseballGame.setDataSource(dataSource);
        return baseballGame;
    }

    @Bean
    public Team redSox() {
        return new RedSox();
    }

    @Bean
    public Team cubs() {
        return new Cubs();
    }
}
