package command_Pattern;
import java.io.Serializable;
import java.util.Random;
import java.util.Scanner;

import factory_Pattern.*;

public class Carrier extends Ships{
    final static int carrierLen= 5;
    final static String carrierChar = "C";
    
    public Carrier(Board board) {
		super(board, carrierLen, carrierChar);
	} 
}
