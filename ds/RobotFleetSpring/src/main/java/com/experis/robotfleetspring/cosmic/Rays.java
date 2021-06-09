package com.experis.robotfleetspring.cosmic;

import com.experis.robotfleetspring.RobotsFleet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Rays {
    @Autowired
    private RobotsFleet fleet;

    @Scheduled(fixedRate = 2500)
    public void impact(){

    }

}
