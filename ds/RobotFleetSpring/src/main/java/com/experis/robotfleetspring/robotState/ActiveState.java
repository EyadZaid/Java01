package com.experis.robotfleetspring.robotState;

import com.experis.robotfleetspring.IRobot;

public class ActiveState implements IRobotState {

    @Override
    public void active(IRobot robot) {
        robot.setState(this);
    }

    @Override
    public void reboot(IRobot robot) {
        robot.setState(new RebootState());
    }

    @Override
    public void work(IRobot robot) {
        robot.setState(new WorkState());
    }

    @Override
    public void failure(IRobot robot) {
        robot.setState(new FailureState());
    }

    @Override
    public String toString() {
        return "State = Active";
    }
}
