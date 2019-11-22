package com.kodilla.rps.logic;

import com.kodilla.rps.game.Elements;
import com.kodilla.rps.game.Languages;

public interface Movable {
    Elements getMove(Languages languages);
}
