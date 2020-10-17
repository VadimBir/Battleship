package command_Pattern;
import java.io.Serializable;
import java.util.Random;
import java.util.Scanner;

import factory_Pattern.*;

public class PatrolBoat extends Ships{ 
    final static int patrolBoatLen= 2;
    final static String patrolBoatChar = "P";

    public PatrolBoat(Board board) {
		super(board, patrolBoatLen, patrolBoatChar);
	} 
}