package com.shrkyash.shootership.gameclient.models.base;

import java.util.List;

public class ConcreteFrame implements BaseFrame {
    private List<Pixel> pixels;


    public ConcreteFrame() {
    }

    public ConcreteFrame(List<Pixel> pixels) {
        this.pixels = pixels;
    }

    @Override
    public List<Pixel> getPixels() {
        return this.pixels;
    }

    public void setPixels(List<Pixel> pixels) {
        this.pixels = pixels;
    }
}
