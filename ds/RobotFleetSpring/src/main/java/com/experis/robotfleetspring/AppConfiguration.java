package com.experis.robotfleetspring;

import com.experis.robotfleetspring.robotState.ActiveState;
import com.experis.robotfleetspring.tool.ITool;
import com.experis.robotfleetspring.tool.ToolBase;
import com.experis.robotfleetspring.tool.ToolType;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan
public class AppConfiguration {

    @Bean
    @Scope("prototype")
    public ITool replicator() {
        return new ToolBase(ToolType.REPLICATOR);
    }

    @Bean
    @Scope("prototype")
    public ITool disruptor() {
        return new ToolBase(ToolType.DISRUPTOR);
    }

    @Bean
    @Scope("prototype")
    public ITool laser() {
        return new ToolBase(ToolType.LASER_CUTTER);
    }

    public List<ITool> tools() {
        var tools = new ArrayList<ITool>();
        tools.add(laser());
        tools.add(replicator());
        tools.add(disruptor());
        return tools;
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public IRobot robot_HAL9000(){
        var tools = tools();
        var robot = new RobotBase();
        robot.setModel(RobotModel.HAL9000);
        robot.setTools(tools);
        return robot;
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public IRobot robot_JOHNNY5(){
        var tools = tools();
        var robot = new RobotBase();

        robot.setModel(RobotModel.JOHNNY5);
        robot.setTools(tools);
        return robot;
    }

}
