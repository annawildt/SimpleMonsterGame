package com.wildt;

public class Player extends Unit{
    private int lives;

    public Player (){
        this.setPosition(450, 300);
        this.setLife(3);
    }

    public void setLife (int life) {
        lives = life;
    }
    public int getLife() {
        return lives;
    }
}
