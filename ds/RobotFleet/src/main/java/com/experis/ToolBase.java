package com.experis;

public class ToolBase implements ITool{
    private String name;
    private ToolState state;

    public ToolBase(String name) {
        this.name = name;
        state = ToolState.READY;
    }

    @Override
    public void executeFunc() {

    }
}
