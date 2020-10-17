package command_Pattern;
import java.io.Serializable;
import java.util.Random;
import java.util.Scanner;

import factory_Pattern.*;

public class Submarine extends Ships{ 
    final static int submarineLen= 3;
    final static String submarineChar = "S";

    public Submarine(Board board) {
		super(board, submarineLen, submarineChar);
	} 
}
