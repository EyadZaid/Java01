package com.experis.robotfleetspring;

import com.experis.robotfleetspring.tools.ITool;
import com.experis.robotfleetspring.robotState.ActiveState;
import com.experis.robotfleetspring.robotState.IRobotState;
import com.experis.robotfleetspring.weapons.Weapon;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;
import java.util.Set;

public class RobotBase implements IRobot {
    private String name;
    private String callSign;
    private IRobotState state;
    private RobotModel model;
    private Set<ITool> tools;

    @Autowired
    @QuantumWeapon
    private Set<Weapon> weapons;

    public RobotBase(String name, String callSign, RobotModel model, Set<ITool> tools) {
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
    public void setState(IRobotState state) {
        this.state = state;
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
    public void raysImpact() {
        Random rnd = new Random();
        int number = rnd.nextInt(100);
        if (number < 10) {
            state.failure(this);
            System.out.println("\n" + this);
        }
    }

    @Override
    public String toString() {
        return "Robot{" +
                "name='" + name + '\'' +
                ", callSign='" + callSign + '\'' +
                ", model=" + model +
                ", " + state +
                '}';
    }
}
