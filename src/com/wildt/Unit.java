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
        int x = random.nextInt(101);
        int y = random.nextInt(31);
        Point p = new Point(x, y);
        return p;

    }

    public void move(int x,int y){
        int newX = this.x + x;
        int newY = this.y + y;
        if(newX>=Graphics.WIDTH-1){
            newX = Graphics.WIDTH-1;
        } else if(newX<=1){
            newX = 1;
        }
        if(newY>=Graphics.HEIGHT-1){
            newY = Graphics.HEIGHT-1;
        } else if(newY<=1){
            newY = 1;
        }
        this.setPosition(newX,newY);
    }

    public boolean collision(Point player) {
        boolean collision = false;
        if (this.getPosition().equals(player)) {
            collision = true;
        }
        return collision;
    }
}
