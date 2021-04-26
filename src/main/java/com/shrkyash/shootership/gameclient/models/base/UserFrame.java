package com.shrkyash.shootership.gameclient.models.base;

public class UserFrame {
    public String userId;

    public ConcreteFrame baseFrame;
    public UserFrame() {

    }

    public UserFrame(String userId, ConcreteFrame baseFrame) {
        this.userId = userId;
        this.baseFrame = baseFrame;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public ConcreteFrame getBaseFrame() {
        return baseFrame;
    }

    public void setBaseFrame(ConcreteFrame baseFrame) {
        this.baseFrame = baseFrame;
    }
}
