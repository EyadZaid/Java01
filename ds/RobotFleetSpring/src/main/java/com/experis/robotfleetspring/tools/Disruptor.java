package com.experis.robotfleetspring.tools;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Disruptor extends ToolBase {

    public Disruptor() {
        super(ToolType.LASER_CUTTER.name());
    }
}
