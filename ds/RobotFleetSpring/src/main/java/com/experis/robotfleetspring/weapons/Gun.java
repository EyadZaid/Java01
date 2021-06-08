package com.experis.robotfleetspring.weapons;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("gun")
@Scope("prototype")
public class Gun implements Weapon {

    @Override
    public void doAction() {
        System.out.println("Gun .......");
    }
}
