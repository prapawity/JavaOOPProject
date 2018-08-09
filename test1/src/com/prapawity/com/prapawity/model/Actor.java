package com.prapawity.com.prapawity.model;

public class Actor {
    private int x;
    private int y;

    public Actor(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public  void  move(int dx, int dy){
        x+= dx;
        y += dy;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
