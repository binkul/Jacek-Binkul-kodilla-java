package com.kodilla.rps.logic;

import com.kodilla.rps.game.Elements;
import com.kodilla.rps.game.Languages;
import com.kodilla.rps.inteface.UserInterface;

public class Gamer implements Movable{

    @Override
    public Elements getMove(Languages languages) {
        return UserInterface.getKeyValue(languages);
    }
}
