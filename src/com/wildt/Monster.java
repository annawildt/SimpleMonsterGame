package com.wildt;

public class Monster extends Unit {
    public Monster() {
        Point p = spawnUnit();
        this.setPosition(p.x,p.y);
        Random random = new Random();
        this.setSpeed(random.nextInt(2)+1);
        


    }
}
