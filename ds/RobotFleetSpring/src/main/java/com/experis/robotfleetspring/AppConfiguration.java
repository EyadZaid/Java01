package com.experis.robotfleetspring;

import com.experis.robotfleetspring.robotState.ActiveState;
import com.experis.robotfleetspring.tool.ITool;
import com.experis.robotfleetspring.tool.ToolBase;
import com.experis.robotfleetspring.tool.ToolType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan
@PropertySource("classpath:application.properties")
public class AppConfiguration {

    ///--------------------------------------------------------------------------
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
    ///--------------------------------------------------------------------------



    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public IRobot robot_HAL9000(@Value("${robots.hal9000.names:robot}") String name,
                                @Value("${robots.hal9000.callSign:callSign}") String callSign){
        var tools = tools();
        var robot = new RobotBase();
        robot.setName(name);
        robot.setCallSign(callSign);
        robot.setModel(RobotModel.HAL9000);
        robot.setTools(tools);
        return robot;
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public IRobot robot_Tachikomas(@Value("${robots.tachikomas.names:robot}") String name,
                                   @Value("${robots.tachikomas.callSign:callSign}") String callSign){
        var tools = tools();
        var robot = new RobotBase();
        robot.setName(name);
        robot.setCallSign(callSign);
        robot.setModel(RobotModel.TACHIKOMAS);
        robot.setTools(tools);
        return robot;
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public IRobot robot_Johnny5(@Value("${robots.johnny5.names:robot}") String name,
                                @Value("${robots.johnny5.callSign:callSign}") String callSign){
        var tools = tools();
        var robot = new RobotBase();
        robot.setName(name);
        robot.setCallSign(callSign);
        robot.setModel(RobotModel.JOHNNY5);
        robot.setTools(tools);
        return robot;
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public IRobot robot_Maschinenmensch(@Value("${robots.maschinenmensch.names:robot}") String name,
                                        @Value("${robots.maschinenmensch.callSign:callSign}") String callSign){
        var tools = tools();
        var robot = new RobotBase();
        robot.setName(name);
        robot.setCallSign(callSign);
        robot.setModel(RobotModel.MASCHINENMENSCH);
        robot.setTools(tools);
        return robot;
    }
}
