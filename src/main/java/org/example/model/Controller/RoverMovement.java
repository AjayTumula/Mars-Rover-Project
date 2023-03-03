package org.example.model.Controller;

import org.example.model.enums.DirectionEnum;
import org.example.model.plateau.Plateau;
import org.example.model.vehicle.Rover;

public class RoverMovement extends RoverMovementControlIMpl{
    boolean flag = false;
    @Override
    public String movePosition(int x, int y, DirectionEnum direction) {
        flag = true;
        if(Rover.roverPositions.size() == 0){
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
        }
        else {
            for (int i = 0; i <= Rover.roverPositions.size() - 1; i++) {
                if (direction.equals(DirectionEnum.N)) {
                    if ((y < Plateau.MAX_Y_COORDINATE)
                            && ((y + 1 != Integer.parseInt(String.valueOf(Rover.roverPositions.get(i).charAt(2))))
                            || (x != Integer.parseInt(String.valueOf(Rover.roverPositions.get(i).charAt(0)))))) {
                        if (i == Rover.roverPositions.size() - 1 && flag == true) {
                            y = y + 1;
                        }
                    } else {
                        flag = false;
                        y = y;
                    }
                } else if (direction.equals(DirectionEnum.S)) {
                    if ((y > Plateau.MIN_Y_COORDINATE)
                            && ((y - 1 != Integer.parseInt(String.valueOf(Rover.roverPositions.get(i).charAt(2))))
                            || (x != Integer.parseInt(String.valueOf(Rover.roverPositions.get(i).charAt(0)))))) {
                        if (i == Rover.roverPositions.size() - 1 && flag == true) {
                            y = y - 1;
                        }
                    } else {
                        flag = false;
                        y = y;
                    }
                } else if (direction.equals(DirectionEnum.E)) {
                    if ((x < Plateau.MAX_X_COORDINATE)
                            && ((x + 1 != Integer.parseInt(String.valueOf(Rover.roverPositions.get(i).charAt(0))))
                            || (y != Integer.parseInt(String.valueOf(Rover.roverPositions.get(i).charAt(2)))))) {
                        if (i == Rover.roverPositions.size() - 1 && flag == true) {
                            x = x + 1;
                        }
                    } else {
                        flag = false;
                        x = x;
                    }
                } else if (direction.equals(DirectionEnum.W)) {
                    if ((x > Plateau.MIN_X_COORDINATE)
                            && ((x - 1 != Integer.parseInt(String.valueOf(Rover.roverPositions.get(i).charAt(0))))
                            || (y != Integer.parseInt(String.valueOf(Rover.roverPositions.get(i).charAt(2)))))) {
                        if (i == Rover.roverPositions.size() - 1 && flag == true) {
                            x = x - 1;
                        }
                    } else {
                        flag = false;
                        x = x;
                    }
                }
                position = getCurrentPositionAsString(x, y, direction);
            }
        }
        return position;
    }
}

