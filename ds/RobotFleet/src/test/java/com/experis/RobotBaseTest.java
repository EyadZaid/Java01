package com.experis;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RobotBaseTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void createRobotTest() {
        RobotFactory robotFactory = new RobotFactory();
        robotFactory.getRobot("Alfa", "A", RobotModel.HAL9000);
    }
}