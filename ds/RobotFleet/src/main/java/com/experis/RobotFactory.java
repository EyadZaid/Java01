package com.experis;

import java.util.ArrayList;
import java.util.List;

public class RobotFactory {
    public IRobot getRobot(String name, String callSign, RobotModel model) {
        ToolFactory toolFactory = new ToolFactory();
        List<ITool> tools = new ArrayList<>();

        switch (model) {
            case HAL9000 -> {
                tools.add(toolFactory.getTool(ToolName.LASER_CUTTER));
                tools.add(toolFactory.getTool(ToolName.REPLICATOR));
                tools.add(toolFactory.getTool(ToolName.DISRUPTOR));
                return new RobotBase(name, callSign, model, tools);
            }

            case TACHIKOMAS -> {
                tools.add(toolFactory.getTool(ToolName.LASER_CUTTER));
                tools.add(toolFactory.getTool(ToolName.DISRUPTOR));
                return new RobotBase(name, callSign, model, tools);
            }

            case JOHNNY5 -> {
                tools.add(toolFactory.getTool(ToolName.LASER_CUTTER));
                tools.add(toolFactory.getTool(ToolName.STATIC_BRUSH));
                return new RobotBase(name, callSign, model, tools);
            }

            case MASCHINENMENSCH -> {
                tools.add(toolFactory.getTool(ToolName.REPLICATOR));
                tools.add(toolFactory.getTool(ToolName.DISRUPTOR));
                return new RobotBase(name, callSign, model, tools);
            }

            default -> { return null; }
        }
    }
}
