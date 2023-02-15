package org.example.model.Controller;

import org.example.model.enums.DirectionEnum;
import org.example.model.plateau.Plateau;

public class FirstRoverMovement extends RoverMovementControlIMpl{

    @Override
    public String movePosition(int x, int y, DirectionEnum direction) {
        if (direction.equals(DirectionEnum.N)) {
            if (y < Plateau.MAX_Y_COORDINATE) {
                y = y + 1;
            } else {
                y = y;
            }
        } else if (direction.equals(DirectionEnum.S)) {
            if ((y > Plateau.MIN_Y_COORDINATE)) {
                y = y - 1;
            } else {
                y = y;
            }
        } else if (direction.equals(DirectionEnum.E)) {
            if (x < Plateau.MAX_X_COORDINATE) {
                x = x + 1;
            } else {
                x = x;
            }
        } else if (direction.equals(DirectionEnum.W)) {
            if (x > Plateau.MIN_X_COORDINATE) {
                x = x - 1;
            } else {
                x = x;
            }
        }
        position = getCurrentPositionAsString(x, y, direction);
        return position;
    }

    }


