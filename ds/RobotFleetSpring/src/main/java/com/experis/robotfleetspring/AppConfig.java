package com.experis.robotfleetspring;

import com.experis.robotfleetspring.tools.ITool;
import com.experis.robotfleetspring.weapons.Weapon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import java.util.*;

@Configuration
@ComponentScan
@PropertySource("classpath:application.properties")
public class AppConfig {
    @Autowired
    RobotsFleet fleet;

    @Bean
    public List<IRobot> robot_hal9000(@Value("${robots.hal9000.names:robot}") String name,
                                      @Value("${robots.hal9000.callSign:callSign}") String callSign,
                                      @Value("${fleet.perType.size:0}") int size,
                                      Set<ITool> hal9000_tools, Set<Weapon> hal9000_weapons){

        List<IRobot> robots = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            robots.add(RobotBuilder.build(name + i, callSign + i, RobotModel.HAL9000,
                    hal9000_tools, hal9000_weapons));
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
                    tachikomas_tools, tachikomas_weapons));
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
                    johnny5_tools, johnny5_weapons));
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
                    maschinenmensch_tools, maschinenmensch_weapons));
        }
        fleet.addListOfRobots(robots);
        return robots;
    }


//    @Bean
//    public Map<RobotModel, Set<ITool>> robotTools(Set<ITool> hal9000_tools,
//                                                  Set<ITool> tachikomas_tools,
//                                                  Set<ITool> johnny5_tools,
//                                                  Set<ITool> maschinenmensch_tools) {
//        Map<RobotModel, Set<ITool>> map = new HashMap<>();
//        map.put(RobotModel.HAL9000, hal9000_tools);
//        map.put(RobotModel.TACHIKOMAS, tachikomas_tools);
//        map.put(RobotModel.JOHNNY5, johnny5_tools);
//        map.put(RobotModel.MASCHINENMENSCH, maschinenmensch_tools);
//        return map;
//    }
//
//    @Bean
//    public Map<RobotModel, Set<Weapon>> robotWeapons(Set<Weapon> hal9000_weapons,
//                                                  Set<Weapon> tachikomas_weapons) {
//        Map<RobotModel, Set<Weapon>> map = new HashMap<>();
//        map.put(RobotModel.HAL9000, hal9000_weapons);
//        map.put(RobotModel.TACHIKOMAS, tachikomas_weapons);
//        return map;
//    }
}
