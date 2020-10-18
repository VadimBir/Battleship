package command_Pattern;
import java.io.Serializable;
import java.util.Random;
import java.util.Scanner;

import factory_Pattern.*;

public class Destroyer extends Ships{ 
    final static int destroyerLen= 3;
    final static String destroyerChar = "D";

    public Destroyer(Board board) {
		super(board, destroyerLen, destroyerChar);
	} 
}

