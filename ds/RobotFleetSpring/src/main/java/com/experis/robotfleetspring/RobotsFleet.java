package com.experis.robotfleetspring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class RobotsFleet implements BeanFactoryAware, ApplicationContextAware {
    private final List<IRobot> fleet;
    //private BeanFactory beanFactory;

    public RobotsFleet() {
        this.fleet = new ArrayList<>();
    }

    public void addRobot(IRobot robot) {
        fleet.add(robot);
    }

    public void addListOfRobots(List<IRobot> robots) {
        fleet.addAll(robots);
    }

    //------ Merge to one function
    public void reboot() {
        for (var r : fleet) {
            r.reboot();
        }
    }

    public void dispatch() {
        for (var r : fleet) {
            r.dispatch();
        }
    }

    public void diagnostics() {
        for (var r : fleet) {
            r.diagnostics();
        }
    }
    //------------


    public List<IRobot> getFleet() {
        return fleet;
    }

    @Override
    public String toString() {
        final StringBuilder str = new StringBuilder("RobotsFleet{ \n");
        for (var r : fleet) {
            str.append(r);
            str.append("\n");
        }
        str.append("}");
        return str.toString();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {

    }
}
