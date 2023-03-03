import org.example.model.Controller.RoverMovement;
import org.example.model.enums.DirectionEnum;
import org.example.model.plateau.Plateau;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.example.model.vehicle.Rover;
import org.example.model.vehicle.Vehicle;
import org.junit.jupiter.api.TestMethodOrder;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RoverTest {

    Plateau plateau = new Plateau("5 5");

    @Test
    @Order(1)
    public void testMaxXCoordinate() {
        int result = Plateau.getMaxXCoordinate();
        assertEquals(5, result);
    }

    @Test
    @Order(2)
    public void testMaxYCoordinate() {
        int result = Plateau.getMaxYCoordinate();
        assertEquals(5, result);

    }

    @Test
    @Order(3)
    public void testCheckValidPosition() throws Exception {
        Vehicle vehicle = new Rover();

        assertEquals(true, vehicle.checkValidPosition("0 0 N"));
    }


    @Test
    @Order(4)
    public void testCheckValidCoordinates() throws Exception {
        Vehicle vehicle = new Rover();
        Plateau.getMaxXCoordinate();
        Plateau.getMaxYCoordinate();
        vehicle.splitGivenPositionToCoordinatesAndDirection("0 2 N");

        assertEquals(true,vehicle.checkValidCoordinates());
    }

    @Test
    @Order(5)
    public void testCheckInValidCoordinates() throws Exception {
        Vehicle vehicle = new Rover();
        Plateau.getMaxXCoordinate();
        Plateau.getMaxYCoordinate();
        vehicle.splitGivenPositionToCoordinatesAndDirection("5 6 S");

        Exception exception = assertThrows(Exception.class, () -> vehicle.checkValidCoordinates());

        assertEquals("Given input is outside the plateau range", exception.getMessage());
    }

    @Test
    public void testSpinLeft() throws Exception{
        RoverMovement roverMovement = new RoverMovement();
        String result = roverMovement.spinLeft(0, 0, DirectionEnum.N);
        assertEquals("0 0 W", result);
    }

    @Test
    public void testSpinRight() throws Exception{
        RoverMovement roverMovement = new RoverMovement();
        String result = roverMovement.spinRight(0, 1, DirectionEnum.S);
        assertEquals("0 1 W", result);
    }

    @Test
    public void testMovePosition() throws Exception{
        RoverMovement roverMovement = new RoverMovement();
        String result = roverMovement.movePosition(1, 0, DirectionEnum.E);
        assertEquals("2 0 E", result);
    }

    @Test
    @Order(6)
    public void testFirstRoverMovementBasedOnInstructions() throws Exception {
        Vehicle vehicle = new Rover();

        assertEquals("1 2 N", vehicle.getPositionBasedOnInstruction("1 3 N","LMLMLML"));
    }

    @Test
    @Order(7)
    public void testSecondRoverMovementBasedOnInstructions() throws Exception {
        Vehicle vehicle = new Rover();

        assertEquals("5 3 E", vehicle.getPositionBasedOnInstruction("3 3 E","MMRRMRRM"));
    }

    @Test
    @Order(8)
    public void testThirdRoverMovementBasedOnInstructions() throws Exception {
        Vehicle vehicle = new Rover();

        assertEquals("0 0 N", vehicle.getPositionBasedOnInstruction("0 0 S","MRMR"));
    }

    @Test
    @Order(9)
    public void testFourthRoverMovementForExceptionBasedOnInstructions() throws Exception {
        Vehicle vehicle = new Rover();

        Exception exception = assertThrows(Exception.class, () -> vehicle.getPositionBasedOnInstruction("1 2 W","MRMR"));

        assertEquals("Given position is invalid as there is already a rover at this position. Please start at another position..!!", exception.getMessage());
    }

}
