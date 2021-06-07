package com.experis.robotfleetspring;

import com.experis.robotfleetspring.tool.ITool;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

import java.util.Set;

@Configuration
@ComponentScan
@PropertySource("classpath:application.properties")
public class AppConfiguration {
    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public IRobot robot_HAL9000(@Value("${robots.hal9000.names:robot}") String name,
                                @Value("${robots.hal9000.callSign:callSign}") String callSign,
                                Set<ITool> hal9000_tools){
        var robot = new RobotBase();
        robot.setName(name);
        robot.setCallSign(callSign);
        robot.setModel(RobotModel.HAL9000);
        robot.setTools(hal9000_tools);
        return robot;
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public IRobot robot_Tachikomas(@Value("${robots.tachikomas.names:robot}") String name,
                                   @Value("${robots.tachikomas.callSign:callSign}") String callSign,
                                   Set<ITool> tachikomas_tools){
        var robot = new RobotBase();
        robot.setName(name);
        robot.setCallSign(callSign);
        robot.setModel(RobotModel.TACHIKOMAS);
        robot.setTools(tachikomas_tools);
        return robot;
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public IRobot robot_Johnny5(@Value("${robots.johnny5.names:robot}") String name,
                                @Value("${robots.johnny5.callSign:callSign}") String callSign,
                                Set<ITool> johnny5_tools){
        var robot = new RobotBase();
        robot.setName(name);
        robot.setCallSign(callSign);
        robot.setModel(RobotModel.JOHNNY5);
        robot.setTools(johnny5_tools);
        return robot;
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public IRobot robot_Maschinenmensch(@Value("${robots.maschinenmensch.names:robot}") String name,
                                        @Value("${robots.maschinenmensch.callSign:callSign}") String callSign,
                                        Set<ITool> maschinenmensch_tools){
        var robot = new RobotBase();
        robot.setName(name);
        robot.setCallSign(callSign);
        robot.setModel(RobotModel.MASCHINENMENSCH);
        robot.setTools(maschinenmensch_tools);
        return robot;
    }
}
