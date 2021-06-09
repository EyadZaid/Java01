package com.experis.robotfleetspring;

import com.experis.robotfleetspring.tools.ITool;
import com.experis.robotfleetspring.weapons.Weapon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class RobotBuilder {
//    @Autowired
//    @QuantumWeapon
//    private static Set<Weapon> weapons;

    public static IRobot build(String name, String callSign, RobotModel model, Set<ITool> tools) {
        var robot = new RobotBase();
        robot.setName(name);
        robot.setCallSign(callSign);
        robot.setModel(model);
        robot.setTools(tools);
        //robot.setWeapons(weapons);
        return robot;
    }
}
