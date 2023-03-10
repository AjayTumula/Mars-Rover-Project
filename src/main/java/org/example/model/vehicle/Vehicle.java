package org.example.model.vehicle;

public interface Vehicle {

    void splitGivenPositionToCoordinatesAndDirection(String position);

    String getPositionBasedOnInstruction(String position, String instruction) throws Exception;

    boolean checkValidCoordinates() throws Exception;

    boolean checkValidPosition(String position) throws Exception;

}
