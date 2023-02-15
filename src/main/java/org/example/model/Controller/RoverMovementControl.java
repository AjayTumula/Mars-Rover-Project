package org.example.model.Controller;

import org.example.model.enums.DirectionEnum;

public interface RoverMovementControl {
    String spinLeft(int x, int y, DirectionEnum direction);

    String spinRight(int x, int y, DirectionEnum direction);

    String movePosition(int x, int y, DirectionEnum direction);

    String getCurrentPositionAsString(int x, int y, DirectionEnum direction);
}
