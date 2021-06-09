package com.experis.robotfleetspring;

import com.experis.robotfleetspring.robotState.IRobotState;

public interface IRobot {
    void dispatch();

    void reboot();

    void diagnostics();

    void raysImpact();

    void setState(IRobotState state);

}
