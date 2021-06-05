package com.experis;

public class ToolFactory {
    public ITool getTool(ToolName name) {
        switch (name) {
            case LASER_CUTTER -> { return new ToolBase(ToolName.LASER_CUTTER.toString()); }
            case REPLICATOR -> { return new ToolBase(ToolName.REPLICATOR.toString()); }
            case DISRUPTOR -> { return new ToolBase(ToolName.DISRUPTOR.toString()); }
            case STATIC_BRUSH -> { return new ToolBase(ToolName.STATIC_BRUSH.toString()); }
            default -> { return null; }
        }
    }
}
