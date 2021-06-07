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

    }

}
