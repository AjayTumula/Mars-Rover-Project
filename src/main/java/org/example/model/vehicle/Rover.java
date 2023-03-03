package org.example.model.vehicle;

import org.example.model.Controller.RoverMovement;
import org.example.model.Controller.RoverMovementControlIMpl;
import org.example.model.enums.DirectionEnum;
import org.example.model.plateau.Plateau;

import java.util.ArrayList;
import java.util.List;

public class Rover implements Vehicle {

    protected int x_coordinate;

    protected int y_coordinate;
    private String position;
    private String instruction;
    private DirectionEnum direction;
    public static List<String> roverPositions = new ArrayList();
    RoverMovement roverMovement = new RoverMovement();

    @Override
    public String getRoverPosition(int index) {
        String position = null;
        for(int i=0;i<roverPositions.size();i++){
            position = roverPositions.get(index);
        }
        return position;

    }
    @Override
    public void splitGivenPositionToCoordinatesAndDirection(String position) {
        x_coordinate = Integer.parseInt(String.valueOf(position.charAt(0)));
        y_coordinate = Integer.parseInt(String.valueOf(position.charAt(2)));
        direction = DirectionEnum.valueOf(String.valueOf(position.charAt(4)));
    }

    @Override
    public String getPositionBasedOnInstruction(String position, String instruction) throws Exception {
        this.position = position;
        this.instruction = instruction;
        splitGivenPositionToCoordinatesAndDirection(position);
        if (checkValidCoordinates()) {
            if (checkValidPosition(position)) {
                for (int i = 0; i <= instruction.length() - 1; i++) {
                    splitGivenPositionToCoordinatesAndDirection(position);
                    if (instruction.charAt(i) == 'L') {
                        position = roverMovement.spinLeft(x_coordinate, y_coordinate, direction);
                    } else if (instruction.charAt(i) == 'R') {
                        position = roverMovement.spinRight(x_coordinate, y_coordinate, direction);
                    } else if (instruction.charAt(i) == 'M') {
                        if (roverPositions.size() == 0) {
                            position = roverMovement.movePosition(x_coordinate, y_coordinate, direction);
                        } else if (roverPositions.size() > 0) {
                            position = roverMovement.movePosition(x_coordinate, y_coordinate, direction);
                        }
                    }
                }
            }
        }
        roverPositions.add(position);
        return position;
    }

    @Override
    public boolean checkValidCoordinates() throws Exception {
        boolean isValid = false;
        if (x_coordinate <= Plateau.getMaxXCoordinate() && y_coordinate <= Plateau.getMaxYCoordinate()
                && x_coordinate >= Plateau.MIN_X_COORDINATE && y_coordinate >= Plateau.MIN_Y_COORDINATE) {
            isValid = true;
        } else {
            throw new Exception("Given input is outside the plateau range");
        }
        return isValid;
    }

    @Override
    public boolean checkValidPosition(String position) throws Exception {
        boolean isValidPosition = false;
        if (roverPositions.size() > 0) {
            for (int i = 0; i <= roverPositions.size() - 1; i++) {
                if (position.charAt(0) == roverPositions.get(i).charAt(0) && position.charAt(2) == roverPositions.get(i).charAt(2)) {
                    throw new Exception("Given position is invalid as there is already a rover at this position. Please start at another position..!!");
                } else {
                    isValidPosition = true;
                }
            }
        } else {
            isValidPosition = true;
        }
        return isValidPosition;
    }

}





