package com.experis.robotfleetspring;

import com.experis.robotfleetspring.tool.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class ToolsConfiguration {

    @Bean
    @Scope("prototype")
    public Set<ITool> hal9000_tools(LaserCutter laserCutter, Replicator replicator, Disruptor disruptor) {
        Set<ITool> tools = new HashSet<>();
        tools.add(laserCutter);
        tools.add(replicator);
        tools.add(disruptor);
        return tools;
    }

    @Bean
    @Scope("prototype")
    public Set<ITool> tachikomas_tools(LaserCutter laserCutter, Disruptor disruptor) {
        Set<ITool> tools = new HashSet<>();
        tools.add(laserCutter);
        tools.add(disruptor);
        return tools;
    }

    @Bean
    @Scope("prototype")
    public Set<ITool> johnny5_tools(LaserCutter laserCutter, StaticBrush staticBrush) {
        Set<ITool> tools = new HashSet<>();
        tools.add(laserCutter);
        tools.add(staticBrush);
        return tools;
    }

    @Bean
    @Scope("prototype")
    public Set<ITool> maschinenmensch_tools(Replicator replicator, Disruptor disruptor) {
        Set<ITool> tools = new HashSet<>();
        tools.add(replicator);
        tools.add(disruptor);
        return tools;
    }

}
