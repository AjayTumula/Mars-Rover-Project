# Mars-Rover-Project
**Overview**

This repository is an implementation of Mars Rover Kata. The main goal of this project is to move Rovers on the surface of the Mars. The surface of the mars is considered
as a rectangular grid. The rovers move on the surface are based on the instructions provided by the user and the initial input is provided by the user. Many vehicles like
rovers and robots move on the Mars surface. They move left, right, and move forward based on the user's instruction. The position of the rover is described by the x,y coordinates and the four cardinal
compass points such as N,S,W,E which represent the North, South, East, and West directions.

**Design**
The UML diagram shows the plan of the project, it is in the main folder of the project.

The Vehicle interface consists of methods that has the movement functionalities of the rover. This interface has a rover class which implements all the functionailities declared in the interface class and moves the rover based on the user inputs such as position and instructions.

There is also a Plateau class which is designed to implement the rectangular grid using the coordinates. All the controls to the rover are in the controller package which has the RoverMovementControl interface which implements the methods for the movement of the rover in left, right and move directions. The abstarct class RoverMOvementControlImpl implements this interface class and implements the logic for the movement of rover. The child classes FirstRoverMovement and MovementForOtherRovers extends this abstract class and represent the logic for movement of the rover.


**Instruction To Run**
Step 1 - Fork the repository to your github account.
Step 2 - Clone the repository.
Step 3 - Open the repository in your IDE and run the test cases using mvn tests.
Step 4 - The test run successfully and the application run successfuly.


**Future Thoughts**
Different type of Vehicles
Different form of plateau
Overcome the obstacles.


