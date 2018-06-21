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

    public void moveMonster(Point player){
        Point monster = this.getPosition();
        int x,y;
        if(monster.x > player.x) {
            x = this.getSpeed() * -1;
        } else if(monster.x < player.x){
            x = this.getSpeed();
        } else {
            x = 0;
        }
        if(monster.y > player.y) {
            y = this.getSpeed() * -1;
        } else if(monster.y < player.y){
            y = this.getSpeed();
        } else {
            y = 0;
        }
        this.move(x,y);
    }
}
