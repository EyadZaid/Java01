package com.experis.robotfleetspring;

import java.util.ArrayList;
import java.util.List;

public class RobotsFleet {
    private final List<IRobot> fleet;

    public RobotsFleet() {
        this.fleet = new ArrayList<>();
    }

    public void addRobot(IRobot robot) {
        fleet.add(robot);
    }

    public void reboot() {
        for (var r : fleet) {
            r.reboot();
        }
    }

    public void dispatch() {
        for (var r : fleet) {
            r.dispatch();
        }
    }

    public void diagnostics() {
        for (var r : fleet) {
            r.diagnostics();
        }
    }

    @Override
    public String toString() {
        final StringBuilder str = new StringBuilder("RobotsFleet{ ");
        str.append(fleet);
        str.append(" }");
        return str.toString();
    }
}
