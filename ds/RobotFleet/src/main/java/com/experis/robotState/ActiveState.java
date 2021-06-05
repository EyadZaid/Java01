package com.experis.robotState;

import com.experis.IRobot;

public class ActiveState implements IRobotState {

    @Override
    public IRobotState active(IRobot robot) {
        return this;
    }

    @Override
    public IRobotState reboot(IRobot robot) {
        robot.reboot();
        return new RebootState();
    }

    @Override
    public IRobotState work(IRobot robot) {
        return new WorkState();
    }

    @Override
    public IRobotState failure(IRobot robot) {
        throw new IllegalStateException();
    }
}
