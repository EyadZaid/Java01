//package com.experis.robotfleetspring;
//
//import com.experis.robotfleetspring.tools.ITool;
//import com.experis.robotfleetspring.tools.ToolFactory;
//import com.experis.robotfleetspring.tools.ToolType;
//
//import java.util.HashSet;
//import java.util.Set;
//
//public class RobotFactory {
//    public IRobot getRobot(String name, String callSign, RobotModel model) {
//        ToolFactory toolFactory = new ToolFactory();
//        Set<ITool> tools = new HashSet<>();
//
//        switch (model) {
//            case HAL9000 -> {
//                tools.add(toolFactory.getTool(ToolType.LASER_CUTTER));
//                tools.add(toolFactory.getTool(ToolType.REPLICATOR));
//                tools.add(toolFactory.getTool(ToolType.DISRUPTOR));
//                return new RobotBase(name, callSign, model, tools);
//            }
//
//            case TACHIKOMAS -> {
//                tools.add(toolFactory.getTool(ToolType.LASER_CUTTER));
//                tools.add(toolFactory.getTool(ToolType.DISRUPTOR));
//                return new RobotBase(name, callSign, model, tools);
//            }
//
//            case JOHNNY5 -> {
//                tools.add(toolFactory.getTool(ToolType.LASER_CUTTER));
//                tools.add(toolFactory.getTool(ToolType.STATIC_BRUSH));
//                return new RobotBase(name, callSign, model, tools);
//            }
//
//            case MASCHINENMENSCH -> {
//                tools.add(toolFactory.getTool(ToolType.REPLICATOR));
//                tools.add(toolFactory.getTool(ToolType.DISRUPTOR));
//                return new RobotBase(name, callSign, model, tools);
//            }
//
//            default -> { return null; }
//        }
//    }
//}
