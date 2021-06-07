package com.experis.robotfleetspring;

import com.experis.robotfleetspring.tool.ITool;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Configuration
@ComponentScan
@PropertySource("classpath:application.properties")
public class AppConfiguration {

    @Bean
    public RobotsFleet createFleet(@Value("${robots.names:robot}") String name,
                                   @Value("${robots.callSign:callSign}") String callSign,
                                   @Value("${fleet.perType.size:0}") int size,
                                   Map<RobotModel, Set<ITool>> robotTools) {
        RobotsFleet fleet = new RobotsFleet();
        for (int i=1; i<=size; i++) {
            fleet.addRobot(robot_hal9000(name + i, callSign + i, robotTools.get(RobotModel.HAL9000)));
            fleet.addRobot(robot_tachikomas(name + i, callSign + i, robotTools.get(RobotModel.TACHIKOMAS)));
            fleet.addRobot(robot_johnny5(name + i, callSign + i, robotTools.get(RobotModel.JOHNNY5)));
            fleet.addRobot(robot_maschinenmensch(name + i, callSign + i, robotTools.get(RobotModel.MASCHINENMENSCH)));
        }
        return fleet;
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public IRobot robot_hal9000(String name, String callSign, Set<ITool> hal9000_tools){
        var robot = new RobotBase();
        robot.setName("hal9000_" + name);
        robot.setCallSign(callSign);
        robot.setModel(RobotModel.HAL9000);
        robot.setTools(hal9000_tools);
        return robot;
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public IRobot robot_tachikomas(String name, String callSign, Set<ITool> tachikomas_tools){
        var robot = new RobotBase();
        robot.setName("tachikomas_" + name);
        robot.setCallSign(callSign);
        robot.setModel(RobotModel.TACHIKOMAS);
        robot.setTools(tachikomas_tools);
        return robot;
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public IRobot robot_johnny5(String name, String callSign, Set<ITool> johnny5_tools){
        var robot = new RobotBase();
        robot.setName("johnny5_" + name);
        robot.setCallSign(callSign);
        robot.setModel(RobotModel.JOHNNY5);
        robot.setTools(johnny5_tools);
        return robot;
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public IRobot robot_maschinenmensch(String name, String callSign, Set<ITool> maschinenmensch_tools){
        var robot = new RobotBase();
        robot.setName("maschinenmensch_" + name);
        robot.setCallSign(callSign);
        robot.setModel(RobotModel.MASCHINENMENSCH);
        robot.setTools(maschinenmensch_tools);
        return robot;
    }

    @Bean
    public Map<RobotModel, Set<ITool>> robotTools(Set<ITool> hal9000_tools,
                                                  Set<ITool> tachikomas_tools,
                                                  Set<ITool> johnny5_tools,
                                                  Set<ITool> maschinenmensch_tools) {
        Map<RobotModel, Set<ITool>> map = new HashMap<>();
        map.put(RobotModel.HAL9000, hal9000_tools);
        map.put(RobotModel.TACHIKOMAS, tachikomas_tools);
        map.put(RobotModel.JOHNNY5, johnny5_tools);
        map.put(RobotModel.MASCHINENMENSCH, maschinenmensch_tools);
        return map;
    }
}
