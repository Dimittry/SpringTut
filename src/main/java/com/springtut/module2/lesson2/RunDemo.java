package com.springtut.module2.lesson2;

import com.springtut.module2.lesson2.entities.Game;
import com.springtut.module2.lesson2.entities.Team;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RunDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        Team royals = context.getBean("royals", Team.class);
        Team cubs = context.getBean("cubs", Team.class);

        Game game = context.getBean("game", Game.class);
        game.playGame();
        //System.out.println(game);

//        Game game2 = context.getBean("game", Game.class);
//        game2.setAwayTeam(royals);
//        System.out.println(game2);
//        game.setAwayTeam(cubs);
//        System.out.println(game);
//        System.out.println(game.playGame());
//
//        System.out.println("There are " + context.getBeanDefinitionCount() + " beans");
//        for(String name : context.getBeanDefinitionNames()) {
//            System.out.println(name);
//        }
        context.close();
    }
}
