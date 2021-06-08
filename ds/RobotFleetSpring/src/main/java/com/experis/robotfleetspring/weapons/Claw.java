package com.experis.robotfleetspring.weapons;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("claw")
@Scope("prototype")
public class Claw implements Weapon {

    @Override
    public void doAction() {
        System.out.println("Claw .......");
    }
}
