package com.experis.robotfleetspring;

import com.experis.robotfleetspring.tools.ITool;
import com.experis.robotfleetspring.weapons.Weapon;

import java.util.Set;

public class RobotBuilder {

    public static IRobot build(String name, String callSign, RobotModel model, Set<ITool> tools,
                               Set<Weapon> weapons) {
        var robot = new RobotBase();
        robot.setName(name);
        robot.setCallSign(callSign);
        robot.setModel(model);
        robot.setTools(tools);
        robot.setWeapons(weapons);
        return robot;
    }
}
