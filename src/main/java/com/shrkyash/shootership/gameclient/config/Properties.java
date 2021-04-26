package com.shrkyash.shootership.gameclient.config;

import com.shrkyash.shootership.gameclient.models.base.User;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

@Configuration
public class Properties {

    private final String id;

    private final User user;

    public Properties() {
        id = UUID.randomUUID().toString();
        this.user = new User(id);
    }

    public User getUser() {
        return user;
    }

    public int getWidth() {
        return 60;
    }

    public int getHeight() {
        return 30;
    }

    public String getId() {
        return id;
    }
}
