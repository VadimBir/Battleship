package command_Pattern;
import java.io.Serializable;
import java.util.Random;
import java.util.Scanner;

import factory_Pattern.*;


public class Battleship extends Ships { 
    final static int carrierLen= 4;
    final static String carrierChar = "B";

    public Battleship(Board board) {
		super(board, carrierLen, carrierChar);
		
	}
}
