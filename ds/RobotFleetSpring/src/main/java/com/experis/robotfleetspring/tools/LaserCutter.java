package com.experis.robotfleetspring.tools;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class LaserCutter extends ToolBase{

    public LaserCutter() {
        super(ToolType.LASER_CUTTER.name());
    }
}
