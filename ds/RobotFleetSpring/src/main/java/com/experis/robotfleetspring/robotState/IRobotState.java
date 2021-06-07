package com.experis.robotfleetspring.robotState;

import com.experis.robotfleetspring.IRobot;

public interface IRobotState {
    IRobotState active(IRobot robot);

    IRobotState reboot(IRobot robot);

    IRobotState work(IRobot robot);

    IRobotState failure(IRobot robot);
}
