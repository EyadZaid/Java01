package com.experis.robotfleetspring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RobotFleetSpringApplication {

    public static void main(String[] args) {

        var ctx = new AnnotationConfigApplicationContext(AppConfiguration.class);

        System.out.println("\n\nUp and ready");

        var robot1 = ctx.getBean("robotAlfa", RobotBase.class);
        robot1.dispatch();
        robot1.reboot();

        var robot2 = ctx.getBean("robotBeta", RobotBase.class);
        robot2.dispatch();

        var robot3 = ctx.getBean("robotBeta", RobotBase.class);
        robot3.dispatch();

    }

}
