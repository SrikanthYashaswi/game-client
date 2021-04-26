package com.shrkyash.shootership.gameclient.services;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.shrkyash.shootership.gameclient.models.base.BaseFrame;
import com.shrkyash.shootership.gameclient.models.base.GameInput;
import com.shrkyash.shootership.gameclient.models.base.GameWindow;
import com.shrkyash.shootership.gameclient.models.base.Pixel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class TerminalWindow implements GameWindow {
    private Screen screen;
    private Logger logger = LoggerFactory.getLogger(TerminalWindow.class);

    public TerminalWindow(int width, int height) throws IOException {
        Terminal terminal = new DefaultTerminalFactory().setInitialTerminalSize(new TerminalSize(width, height)).createTerminal();
        screen = new TerminalScreen(terminal);
    }

    @Override
    public void print(int x, int y, String str) {
        TextGraphics tg = screen.newTextGraphics();
        tg.putString(x, y, str);
    }

    @Override
    public void print(BaseFrame frame) {
        for (Pixel pixel : frame.getPixels()) {
            print(pixel.getX(), pixel.getY(), pixel.getCharacter());
        }
    }

    @Override
    public void shutDown() {
        try {
            screen.stopScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            screen.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void refresh() {
        try {
            screen.refresh();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public GameInput getInputAsync() {
        try {
            return GameInputTranslator.getInput(screen.pollInput());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return GameInput.UNDEFINED;
    }

    @Override
    public void clearScreen() {
        screen.clear();
    }

    @Override
    public void gotoxy(int x, int y) {
        screen.setCursorPosition(new TerminalPosition(x, y));
        refresh();
    }

    public void start() throws IOException {
        screen.startScreen();
    }
}
