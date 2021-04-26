package com.shrkyash.shootership.gameclient.models.base;

public abstract class Sprite extends Pixel {
    private boolean active;

    public Sprite(int x, int y, String c) {
        super(x, y, c);
        active = true;
    }

    public void markInactive() {
        this.active = false;
    }

    public boolean isInactive() {
        return !active;
    }

    public void move(Direction direction) {
        switch (direction) {
            case UP: {
                moveUp();
                break;
            }
            case DOWN: {
                moveDown();
                break;
            }
            case LEFT: {
                moveLeft();
                break;
            }
            case RIGHT: {
                moveRight();
                break;
            }
        }
    }

    public void moveUp() {
        setY(getY() - 1);
    }

    public void moveDown() {
        setY(getY() + 1);
    }

    public void moveLeft() {
        setX(getX() - 1);
    }

    public void moveRight() {
        setX(getX() + 1);
    }
}
