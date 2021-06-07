package com.experis.robotfleetspring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RobotFleetSpringApplication {

    public static void main(String[] args) {

        var ctx = new AnnotationConfigApplicationContext(AppConfiguration.class);

        System.out.println("\n\nUp and ready");

        var robot1 = ctx.getBean("robot_HAL9000", RobotBase.class);
        robot1.setName("Alfa");
        robot1.setCallSign("A");
        robot1.dispatch();
        robot1.reboot();

        var robot2 = ctx.getBean("robot_JOHNNY5", RobotBase.class);
        robot2.setName("Beta");
        robot2.setCallSign("B");
        robot2.dispatch();

        var robot3 = ctx.getBean("robot_JOHNNY5", RobotBase.class);
        robot2.setName("Gama");
        robot2.setCallSign("C");
        robot3.dispatch();

    }

}
