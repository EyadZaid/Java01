package com.experis.robotfleetspring.tools;

public class ToolBase implements ITool {
    private String name;
    private ToolState state;

    public ToolBase(String name) {
        state = ToolState.READY;
        this.name = name;

    }

    public ToolState getState() {
        return state;
    }

    public void setState(ToolState state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void executeFunc() {

    }
}
