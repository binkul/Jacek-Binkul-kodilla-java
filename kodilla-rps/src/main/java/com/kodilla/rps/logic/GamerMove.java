package com.kodilla.rps.logic;

import com.kodilla.rps.game.Languages;
import com.kodilla.rps.inteface.UserInterface;
import com.kodilla.rps.rps.RpsElements;

public class GamerMove implements Movable {
    private Languages languages;

    public GamerMove(Languages languages) {
        this.languages = languages;
    }

    @Override
    public RpsElements getMove() {
        return UserInterface.getKeyValue(languages);
    }
}
