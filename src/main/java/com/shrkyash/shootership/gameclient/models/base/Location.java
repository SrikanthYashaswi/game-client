package com.shrkyash.shootership.gameclient.models.base;

public class Location {
    private int x;
    private int y;

    public Location() {

    }

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }
}
