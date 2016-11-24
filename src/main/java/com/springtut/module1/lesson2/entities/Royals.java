package com.springtut.module1.lesson2.entities;

import org.springframework.stereotype.Component;

@Component
public class Royals implements Team {
    @Override
    public String getName() {
        return "Kansas City Royals";
    }
}
