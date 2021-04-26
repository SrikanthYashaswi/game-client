package com.shrkyash.shootership.gameclient.models.base;

public abstract class Ship extends Mass {
    private Direction cannonDirection;

    public Ship(int x, int y, String c, int health) {
        super(x, y, c, health);
    }

    public Direction getCannonDirection() {
        return cannonDirection;
    }

    public void setCannonDirection(Direction cannonDirection) {
        this.cannonDirection = cannonDirection;
    }
}
