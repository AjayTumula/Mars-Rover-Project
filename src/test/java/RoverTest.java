import org.example.model.plateau.Plateau;

import org.example.model.vehicle.Rover;
import org.example.model.vehicle.Vehicle;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class RoverTest {


    @Test
    public void testMaxXCoordinate() {
        Plateau plateau = new Plateau("5 5");

        assertEquals(5, Plateau.getMaxXCoordinate());

    }

    @Test
    public void testMaxYCoordinate() {
        Plateau plateau = new Plateau("5 5");

        assertEquals(5, Plateau.getMaxYCoordinate());

    }

    @Test
    public void testCheckValidPosition() throws Exception {
        Vehicle vehicle = new Rover();

        assertEquals(true, vehicle.checkValidPosition("0 0 N"));
    }

    @Test
    public void testRoverMovementBasedOnInstructions() throws Exception {
        Vehicle vehicle = new Rover();

        assertEquals("0 0 N", vehicle.getPositionBasedOnInstruction("0 0 S","MRMR"));
    }

    @Test
    public void testSecondRoverMovementBasedOnInstructions() throws Exception {
        Vehicle vehicle = new Rover();

        assertEquals("1 2 N", vehicle.getPositionBasedOnInstruction("1 3 N","LMLMLML"));
    }

}
