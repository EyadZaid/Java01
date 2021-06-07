package com.experis.robotfleetspring.tool;

public class ToolFactory {
    public ITool getTool(ToolType type) {
        switch (type) {
            case LASER_CUTTER -> { return new ToolBase(ToolType.LASER_CUTTER); }
            case REPLICATOR -> { return new ToolBase(ToolType.REPLICATOR); }
            case DISRUPTOR -> { return new ToolBase(ToolType.DISRUPTOR); }
            case STATIC_BRUSH -> { return new ToolBase(ToolType.STATIC_BRUSH); }
            default -> { return null; }
        }
    }
}
