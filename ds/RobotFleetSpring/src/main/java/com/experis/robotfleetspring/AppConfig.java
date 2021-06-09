package com.experis.robotfleetspring;

import com.experis.robotfleetspring.tools.ITool;
import com.experis.robotfleetspring.weapons.Weapon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.*;

@Configuration
@ComponentScan
@EnableScheduling
@PropertySource("classpath:application.properties")
public class AppConfig {

    @Autowired
    private RobotsFleet fleet;

    @Bean
    public List<IRobot> robot_hal9000(@Value("${robots.hal9000.names:robot}") String name,
                                      @Value("${robots.hal9000.callSign:callSign}") String callSign,
                                      @Value("${fleet.perType.size:0}") int size,
                                      Set<ITool> hal9000_tools){

        List<IRobot> robots = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            robots.add(RobotBuilder.build(name + i, callSign + i, RobotModel.HAL9000,
                    hal9000_tools));
        }
        fleet.addListOfRobots(robots);
        return robots;
    }


    @Bean
    public List<IRobot> robot_tachikomas(@Value("${robots.tachikomas.names:robot}") String name,
                                      @Value("${robots.tachikomas.callSign:callSign}") String callSign,
                                      @Value("${fleet.perType.size:0}") int size,
                                      Set<ITool> tachikomas_tools, Set<Weapon> tachikomas_weapons){

        List<IRobot> robots = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            robots.add(RobotBuilder.build(name + i, callSign + i, RobotModel.TACHIKOMAS,
                    tachikomas_tools));
        }
        fleet.addListOfRobots(robots);
        return robots;
    }


    @Bean
    public List<IRobot> robot_johnny5(@Value("${robots.johnny5.names:robot}") String name,
                                         @Value("${robots.johnny5.callSign:callSign}") String callSign,
                                         @Value("${fleet.perType.size:0}") int size,
                                         Set<ITool> johnny5_tools, Set<Weapon> johnny5_weapons){

        List<IRobot> robots = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            robots.add(RobotBuilder.build(name + i, callSign + i, RobotModel.JOHNNY5,
                    johnny5_tools));
        }
        fleet.addListOfRobots(robots);
        return robots;
    }


    @Bean
    public List<IRobot> robot_maschinenmensch(@Value("${robots.maschinenmensch.names:robot}") String name,
                                      @Value("${robots.maschinenmensch.callSign:callSign}") String callSign,
                                      @Value("${fleet.perType.size:0}") int size,
                                      Set<ITool> maschinenmensch_tools, Set<Weapon> maschinenmensch_weapons){

        List<IRobot> robots = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            robots.add(RobotBuilder.build(name + i, callSign + i, RobotModel.MASCHINENMENSCH,
                    maschinenmensch_tools));
        }
        fleet.addListOfRobots(robots);
        return robots;
    }

}
