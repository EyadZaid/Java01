package com.experis;

import com.experis.robotState.ActiveState;
import com.experis.robotState.IRobotState;

import java.util.ArrayList;
import java.util.List;

public class RobotBase implements IRobot{
    private final String name;
    private final String callSign;
    private IRobotState state;
    private final RobotModel model;
    private final List<ITool> tools;

    public RobotBase(String name, String callSign, RobotModel model, List<ITool> tools) {
        this.name = name;
        this.callSign = callSign;
        this.model = model;
        this.tools = tools;
        state = new ActiveState();
    }

    @Override
    public void dispatch() {

    }

    @Override
    public void reboot() {

    }

    @Override
    public void diagnostics() {

    }
}
