package org.example.model.plateau;

import static java.lang.String.*;

public class Plateau {

    public static int MAX_X_COORDINATE = 5;

    public static int MAX_Y_COORDINATE = 5;

    public static final int MIN_X_COORDINATE = 0;
    public static final int MIN_Y_COORDINATE = 0;

    public static String coordinates;

    public Plateau(String coordinates){
        this.coordinates = coordinates;
    }

    public static int getMaxXCoordinate() {
         MAX_X_COORDINATE = Integer.parseInt(valueOf(coordinates.charAt(0)));
        return MAX_X_COORDINATE;
    }

    public static int getMaxYCoordinate() {
        MAX_Y_COORDINATE = Integer.parseInt(valueOf(coordinates.charAt(0)));
        return MAX_Y_COORDINATE;
    }

}
