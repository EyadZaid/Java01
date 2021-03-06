package com.experis.robotfleetspring.tools;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Replicator extends ToolBase {

    public Replicator() {
        super(ToolType.LASER_CUTTER.name());
    }
}
