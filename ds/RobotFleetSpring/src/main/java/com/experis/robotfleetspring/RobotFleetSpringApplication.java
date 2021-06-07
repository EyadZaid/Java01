package com.experis.robotfleetspring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RobotFleetSpringApplication {

    public static void main(String[] args) {

        var ctx = new AnnotationConfigApplicationContext(AppConfiguration.class);
        var fleet = ctx.getBean(RobotsFleet.class);

        System.out.println();
        System.out.println(fleet);

        fleet.reboot();
        System.out.println();
        fleet.dispatch();
        System.out.println();
        fleet.diagnostics();

        //var robot1 = ctx.getBean("robot_HAL9000", RobotBase.class);
        //robots.addRobot(robot1);

        //var robot2 = ctx.getBean("robot_JOHNNY5", RobotBase.class);
        //robots.addRobot(robot2);

//        var robot3 = ctx.getBean("robot_JOHNNY5", RobotBase.class);
//        robot2.setName("Gama");
//        robot2.setCallSign("C");
//        robot3.dispatch();

    }

}
