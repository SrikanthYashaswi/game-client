package com.shrkyash.shootership.gameclient.models.base;

public abstract class Mass extends Sprite {
    protected int health;

    public Mass(int x, int y, String c, int health) {
        super(x, y, c);
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public void impact(int power) {
        if ((this.health - power) <= 0) {
            this.health = 0;
            this.markInactive();
        } else {
            this.health -= power;
        }
    }
}
