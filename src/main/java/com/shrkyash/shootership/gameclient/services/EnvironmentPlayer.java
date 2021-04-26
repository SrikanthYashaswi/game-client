package com.shrkyash.shootership.gameclient.services;

import com.shrkyash.shootership.gameclient.models.base.BaseFrame;
import com.shrkyash.shootership.gameclient.models.base.GameInput;
import com.shrkyash.shootership.gameclient.models.base.Pixel;
import com.shrkyash.shootership.gameclient.config.Properties;
import com.shrkyash.shootership.gameclient.pubsub.MessageDispatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class EnvironmentPlayer extends Thread {

    private final Logger logger = LoggerFactory.getLogger(EnvironmentPlayer.class);
    private final MessageDispatcher messageDispatcher;
    private final TerminalWindow terminalWindow;
    private BaseFrame lastFrame;
    private boolean isRunning = true;

    public EnvironmentPlayer(Properties properties,TerminalWindow terminalWindow, MessageDispatcher messageDispatcher) throws IOException {
        this.terminalWindow = terminalWindow;
        this.messageDispatcher = messageDispatcher;
        lastFrame = () -> List.of(new Pixel(5, 5, "Loading...." + properties.getId()));
        this.start();
        this.terminalWindow.start();
    }

    public void setLastFrame(BaseFrame newFrame) {
        this.lastFrame = newFrame;
    }

    @Override
    public void run() {
        while (isRunning) {
            final var input = terminalWindow.getInputAsync();
            if (!GameInput.UNDEFINED.equals(input)) {
                this.messageDispatcher.dispatchGameInput(input);
            }
            if (GameInput.QUIT.equals(input)) {
                this.isRunning = false;
                this.terminalWindow.shutDown();
                System.exit(0);
            }
            terminalWindow.clearScreen();
            terminalWindow.print(lastFrame);
            terminalWindow.refresh();
            sleep();
        }
    }

    private void sleep() {
        try {
            Thread.sleep(40);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
