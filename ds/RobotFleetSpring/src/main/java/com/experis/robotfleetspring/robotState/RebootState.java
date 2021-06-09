package com.experis.robotfleetspring.robotState;

import com.experis.robotfleetspring.IRobot;
import com.experis.robotfleetspring.robotState.IRobotState;

public class RebootState implements IRobotState {
    @Override
    public void active(IRobot robot) {
        robot.setState(new ActiveState());
    }

    @Override
    public void reboot(IRobot robot) {
        robot.setState(this);
    }

    @Override
    public void work(IRobot robot) {
        throw new IllegalStateException();
    }

    @Override
    public void failure(IRobot robot) {
        throw new IllegalStateException();
    }

    @Override
    public String toString() {
        return "State = Reboot";
    }
}
