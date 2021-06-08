package com.experis.robotfleetspring.weapons;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Saber implements Weapon {

    @Override
    public void doAction() {
        System.out.println("Saber .......");
    }
}
