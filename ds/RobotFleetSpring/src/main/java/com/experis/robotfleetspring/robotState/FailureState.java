package com.experis.robotfleetspring.robotState;

import com.experis.robotfleetspring.IRobot;

public class FailureState implements IRobotState {

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
        return new WorkState();
    }

    @Override
    public IRobotState failure(IRobot robot) {
        return this;
    }
}
