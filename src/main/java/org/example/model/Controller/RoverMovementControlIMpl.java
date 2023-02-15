package org.example.model.Controller;

import org.example.model.enums.DirectionEnum;

public abstract class RoverMovementControlIMpl implements RoverMovementControl {

    protected String position;

    @Override
    public String spinLeft(int x, int y, DirectionEnum direction) {
        if (direction.equals(DirectionEnum.N)) {
            direction = DirectionEnum.W;
        } else if (direction.equals(DirectionEnum.S)) {
            direction = DirectionEnum.E;
        } else if (direction.equals(DirectionEnum.E)) {
            direction = DirectionEnum.N;
        } else if (direction.equals(DirectionEnum.W)) {
            direction = DirectionEnum.S;
        }
        position = getCurrentPositionAsString(x, y, direction);
        return position;
    }

    @Override
    public String spinRight(int x, int y, DirectionEnum direction) {
        if (direction.equals(DirectionEnum.N)) {
            direction = DirectionEnum.E;
        } else if (direction.equals(DirectionEnum.S)) {
            direction = DirectionEnum.W;
        } else if (direction.equals(DirectionEnum.E)) {
            direction = DirectionEnum.S;
        } else if (direction.equals(DirectionEnum.W)) {
            direction = DirectionEnum.N;
        }
        position = getCurrentPositionAsString(x, y, direction);
        return position;
    }

    @Override
    public String getCurrentPositionAsString(int x, int y, DirectionEnum direction) {
        position = x + " " + y + " " + direction;
        return position;
    }
}
