package org.example.app;

import org.example.model.vehicle.Rover;
import org.example.model.vehicle.Vehicle;

public class Main {
    public static void main(String[] args) throws Exception {
        Vehicle vehicle = new Rover();

        System.out.println(vehicle.getPositionBasedOnInstruction("1 2 N", "LMLMLML")); // 1 1 N
        System.out.println(vehicle.getPositionBasedOnInstruction("3 3 E", "MMRRMRRM")); // 5 3 E
        System.out.println(vehicle.getPositionBasedOnInstruction("0 0 S", "MRMR")); // 0 0 N
        System.out.println(vehicle.getPositionBasedOnInstruction("0 3 E", "MRMRML")); // 0 2 S
        System.out.println(vehicle.getPositionBasedOnInstruction("1 2 W", "MRMR")); // 1 3 E
        System.out.println(vehicle.getPositionBasedOnInstruction("0 3 S", "MRRMLMMMRM")); // 0 5 N
        System.out.println(vehicle.getPositionBasedOnInstruction("5 5 S", "MRMLMLMRMRMMMMLMRMLMM")); // 1 2 S

    }
}