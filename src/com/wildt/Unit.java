package com.wildt;

import java.awt.*;
import java.util.Random;

public class Unit {
    private int x, y;
    private int speed;

    public Point getPosition() {
        Point p = new Point(x, y);
        return p;
    }

    public void setPosition(int dX, int dY) {
        this.x = dX;
        this.y = dY;
    }

    public void setSpeed(int speed) {

        this.speed = speed;
    }

    public int getSpeed() {

        return speed;
    }

    public Point spawnUnit (){
        Random random = new Random();
        int x = random.nextInt(901);
        int y = random.nextInt(601);
        Point p = new Point(x, y);
        return p;

    }
}
