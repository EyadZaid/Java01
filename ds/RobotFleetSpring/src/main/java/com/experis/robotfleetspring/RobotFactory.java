package com.experis.robotfleetspring;

import com.experis.robotfleetspring.tool.ITool;
import com.experis.robotfleetspring.tool.ToolFactory;
import com.experis.robotfleetspring.tool.ToolType;

import java.util.ArrayList;
import java.util.List;

public class RobotFactory {
    public IRobot getRobot(String name, String callSign, RobotModel model) {
        ToolFactory toolFactory = new ToolFactory();
        List<ITool> tools = new ArrayList<>();

        switch (model) {
            case HAL9000 -> {
                tools.add(toolFactory.getTool(ToolType.LASER_CUTTER));
                tools.add(toolFactory.getTool(ToolType.REPLICATOR));
                tools.add(toolFactory.getTool(ToolType.DISRUPTOR));
                return new RobotBase(name, callSign, model, tools);
            }

            case TACHIKOMAS -> {
                tools.add(toolFactory.getTool(ToolType.LASER_CUTTER));
                tools.add(toolFactory.getTool(ToolType.DISRUPTOR));
                return new RobotBase(name, callSign, model, tools);
            }

            case JOHNNY5 -> {
                tools.add(toolFactory.getTool(ToolType.LASER_CUTTER));
                tools.add(toolFactory.getTool(ToolType.STATIC_BRUSH));
                return new RobotBase(name, callSign, model, tools);
            }

            case MASCHINENMENSCH -> {
                tools.add(toolFactory.getTool(ToolType.REPLICATOR));
                tools.add(toolFactory.getTool(ToolType.DISRUPTOR));
                return new RobotBase(name, callSign, model, tools);
            }

            default -> { return null; }
        }
    }
}
