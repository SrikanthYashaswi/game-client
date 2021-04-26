package com.shrkyash.shootership.gameclient;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class GameClientApplication {
    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(GameClientApplication.class);
        builder.headless(false);
        ConfigurableApplicationContext context = builder.run(args);
    }
}
