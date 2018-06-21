package com.wildt;

import java.awt.*;

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
}
