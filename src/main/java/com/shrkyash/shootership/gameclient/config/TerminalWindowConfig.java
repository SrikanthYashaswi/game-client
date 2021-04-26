package com.shrkyash.shootership.gameclient.config;

import com.shrkyash.shootership.gameclient.services.TerminalWindow;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class TerminalWindowConfig {

    private final Properties properties;

    TerminalWindowConfig(Properties properties){
        this.properties = properties;
    }

    @Bean
    public TerminalWindow terminalWindow() throws IOException {
        return new TerminalWindow(properties.getWidth(), properties.getHeight());
    }
}
