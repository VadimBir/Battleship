import java.io.Serializable;
import java.util.Random;
import java.util.Scanner;

public class Submarine extends Ships{ 
    final static int submarineLen= 3;
    final static String submarineChar = "S";

    Submarine(Board board) {
		super(board, submarineLen, submarineChar);
	} 
}
