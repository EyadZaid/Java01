package com.experis.robotState;

import com.experis.IRobot;

public class WorkState implements IRobotState {
    @Override
    public IRobotState active(IRobot robot) {
        return new ActiveState();
    }

    @Override
    public IRobotState reboot(IRobot robot) {
        return new RebootState();
    }

    @Override
    public IRobotState work(IRobot robot) {
        return this;
    }

    @Override
    public IRobotState failure(IRobot robot) {
        return new FailureState();
    }
}
