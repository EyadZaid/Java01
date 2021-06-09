package com.experis.robotfleetspring.robotState;

import com.experis.robotfleetspring.IRobot;

public interface IRobotState {
    void active(IRobot robot);

    void reboot(IRobot robot);

    void work(IRobot robot);

    void failure(IRobot robot);

}
