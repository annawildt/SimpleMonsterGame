package com.wildt;

import java.awt.*;

public class Player extends Unit{
    private int lives;

    public Player (){
        Point p = new Point(spawnUnit());
        this.setPosition(p.x,p.y);
        this.setLife(3);
        this.setSpeed(3);
    }

    public void setLife (int life) {
        lives = life;
    }
    public int getLife() {
        return lives;
    }
}
