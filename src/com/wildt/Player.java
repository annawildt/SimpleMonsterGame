package com.wildt;

public class Player extends Unit{
    private int lives;

    public Player (){
        this.spawnUnit();
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
