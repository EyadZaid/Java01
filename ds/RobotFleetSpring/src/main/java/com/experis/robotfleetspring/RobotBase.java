package com.experis.robotfleetspring;

import com.experis.robotfleetspring.tools.ITool;
import com.experis.robotfleetspring.robotState.ActiveState;
import com.experis.robotfleetspring.robotState.IRobotState;
import com.experis.robotfleetspring.weapons.Weapon;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@Scope("prototype")
public class RobotBase implements IRobot {
    private String name;
    private String callSign;
    private IRobotState state;
    private RobotModel model;
    private Set<ITool> tools;
    private Set<Weapon> weapons;

    public RobotBase(String name, String callSign, RobotModel model, Set<ITool> tools, Set<Weapon> weapons) {
        this.name = name;
        this.callSign = callSign;
        this.model = model;
        this.tools = tools;
        this.weapons = weapons;
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

    public Set<ITool> getTools() {
        return tools;
    }

    public void setTools(Set<ITool> tools) {
        this.tools = tools;
    }

    public Set<Weapon> getWeapons() {
        return weapons;
    }

    public void setWeapons(Set<Weapon> weapons) {
        this.weapons = weapons;
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
        return "Robot{" +
                "name='" + name + '\'' +
                ", callSign='" + callSign + '\'' +
                ", model=" + model +
                '}';
    }
}
