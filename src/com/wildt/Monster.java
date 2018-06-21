package com.wildt;

import java.awt.*;
import java.util.Random;

public class Monster extends Unit {
    public Monster() {
        Point p = spawnUnit();
        this.setPosition(p.x,p.y);
        Random random = new Random();
        this.setSpeed(random.nextInt(2)+1);
        


    }
}
