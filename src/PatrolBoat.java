import java.io.Serializable;
import java.util.Random;
import java.util.Scanner;

public class PatrolBoat extends Ships{ 
    final static int patrolBoatLen= 2;
    final static String patrolBoatChar = "P";

    PatrolBoat(Board board) {
		super(board, patrolBoatLen, patrolBoatChar);
	} 
}