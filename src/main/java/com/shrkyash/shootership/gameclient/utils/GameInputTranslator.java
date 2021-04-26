package com.shrkyash.shootership.gameclient.utils;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.shrkyash.shootership.gameclient.models.base.GameInput;

public class GameInputTranslator {
    private GameInputTranslator() {
    }

    public static GameInput getInput(KeyStroke keyStroke) {
        if (keyStroke == null) {
            return GameInput.UNDEFINED;
        }
        KeyType inputKeyType = keyStroke.getKeyType();
        switch (inputKeyType) {
            case ArrowUp:
                return GameInput.UP;
            case ArrowDown:
                return GameInput.DOWN;
            case ArrowLeft:
                return GameInput.LEFT;
            case ArrowRight:
                return GameInput.RIGHT;
            case Character:
                if (keyStroke.getCharacter().equals('s')) {
                    return GameInput.SHOOT;
                }
                if (keyStroke.getCharacter().equals('S')) {
                    return GameInput.POWER_SHOOT;
                }
                if (keyStroke.getCharacter().equals('q')) {
                    return GameInput.QUIT;
                }
                if (keyStroke.getCharacter().equals('c')) {
                    return GameInput.CLEAR_SCREEN;
                }
                if (keyStroke.getCharacter().equals('p')) {
                    return GameInput.TOGGLE;
                }
                break;
        }
        return GameInput.UNDEFINED;
    }
}
