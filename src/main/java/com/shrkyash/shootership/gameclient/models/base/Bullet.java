package com.shrkyash.shootership.gameclient.models.base;

public abstract class Bullet extends Mass {
    private Direction travelDirection;

    public Bullet(int x, int y, String character, int power, Direction travelDirection) {
        super(x, y, character, power);
        this.travelDirection = travelDirection;
    }

    public Direction getTravelDirection() {
        return travelDirection;
    }
}
