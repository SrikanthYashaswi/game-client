package com.shrkyash.shootership.gameclient.models.base;

public class Pixel extends Location {
    private String character;

    public Pixel() {

    }

    public Pixel(int x, int y, String c) {
        super(x, y);
        this.character = c;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }
}
