package com.experis.robotfleetspring;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RobotsFleet {
    private final List<IRobot> robots;

    public RobotsFleet(List<IRobot> robots) {
        this.robots = robots;
    }

    public void reboot() {
        for (var r : robots) {
            r.reboot();
        }
    }

    public void dispatch() {
        for (var r : robots) {
            r.dispatch();
        }
    }

    public void diagnostics() {
        for (var r : robots) {
            r.diagnostics();
        }
    }

    @Override
    public String toString() {
        final StringBuilder str = new StringBuilder("RobotsFleet{ ");
        str.append(robots);
        str.append(" }");
        return str.toString();
    }
}
