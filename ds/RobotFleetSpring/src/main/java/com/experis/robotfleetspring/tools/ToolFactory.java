package com.experis.robotfleetspring.tools;

public class ToolFactory {
    public ITool getTool(ToolType type) {
        switch (type) {
            case LASER_CUTTER -> { return new LaserCutter(); }
            case REPLICATOR -> { return new Replicator(); }
            case DISRUPTOR -> { return new Disruptor(); }
            case STATIC_BRUSH -> { return new StaticBrush(); }
            default -> { return null; }
        }
    }
}
