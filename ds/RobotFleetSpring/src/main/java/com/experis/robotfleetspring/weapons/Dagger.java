package com.experis.robotfleetspring.weapons;

import com.experis.robotfleetspring.QuantumWeapon;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@QuantumWeapon
public class Dagger implements Weapon {

    @Override
    public void doAction() {
        System.out.println("Dagger .......");
    }
}
