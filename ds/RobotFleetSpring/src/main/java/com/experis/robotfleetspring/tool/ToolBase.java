package com.experis.robotfleetspring.tool;

import org.springframework.stereotype.Component;

@Component
public class ToolBase implements ITool {
    private ToolType type;
    private ToolState state;

    public ToolBase(ToolType type) {
        this.type = type;
        state = ToolState.READY;
    }

    public ToolBase() {

    }

    public ToolType getType() {
        return type;
    }

    public ToolState getState() {
        return state;
    }

    public void setState(ToolState state) {
        this.state = state;
    }

    public void setType(ToolType type) {
        this.type = type;
    }

    @Override
    public void executeFunc() {

    }
}
