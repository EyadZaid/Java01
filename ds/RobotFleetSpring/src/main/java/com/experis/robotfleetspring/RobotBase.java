package com.experis.robotfleetspring;

import com.experis.robotfleetspring.tool.ITool;
import com.experis.robotfleetspring.robotState.ActiveState;
import com.experis.robotfleetspring.robotState.IRobotState;

import java.util.List;

public class RobotBase implements IRobot {
    private String name;
    private String callSign;
    private IRobotState state;
    private RobotModel model;
    private List<ITool> tools;

    public RobotBase(String name, String callSign, RobotModel model, List<ITool> tools) {
        this.name = name;
        this.callSign = callSign;
        this.model = model;
        this.tools = tools;
        state = new ActiveState();
    }

    public RobotBase() {
        state = new ActiveState();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCallSign() {
        return callSign;
    }

    public void setCallSign(String callSign) {
        this.callSign = callSign;
    }

    public IRobotState getState() {
        return state;
    }

    public void setState(IRobotState state) {
        this.state = state;
    }

    public RobotModel getModel() {
        return model;
    }

    public void setModel(RobotModel model) {
        this.model = model;
    }

    public List<ITool> getTools() {
        return tools;
    }

    public void setTools(List<ITool> tools) {
        this.tools = tools;
    }

    @Override
    public void dispatch() {
        state.work(this);
        System.out.println("Robot " + name + " is in active duty");
        state.active(this);
    }

    @Override
    public void reboot() {
        state.reboot(this);
        System.out.println("Robot " + name + " is rebooting");
        state.active(this);
    }

    @Override
    public void diagnostics() {
        state.failure(this);
        System.out.println("Robot " + name + " was diagnosed");
        state.active(this);
    }

    @Override
    public String toString() {
        return "RobotBase{" +
                "name='" + name + '\'' +
                ", callSign='" + callSign + '\'' +
                ", model=" + model +
                '}';
    }
}
