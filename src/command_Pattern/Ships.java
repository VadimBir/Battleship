package command_Pattern;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import factory_Pattern.*;
import decorator_Pattern.*;

abstract public class Ships extends Board implements Serializable{

    int shipLen= 1;
    String shipChar = "Err";
    private int inputY;
    private int inputX;
    public boolean shipError= true;
    Board board;
    public String boardCol[];
    private int PlayerPlacement=1;
    String[][][] someBoardArr;
    //String[] boardCol;


    Ships(Board board, int someShipLen, String somShipChar)
    {
        shipLen = someShipLen;
        shipChar = somShipChar;
        this.board = board;
        this.boardCol = board.boardCol;
        someBoardArr = new String[2][board.boardCol.length][board.boardRow.length];
    }

    public Board Horizontal(Board board)
    {
        boardSplit();
        while(shipError==true){
            do{
                getCoordinates();
                System.out.println("Coord: " + inputX + " " + inputY);
                if(board.boardCol.length<(inputY)+shipLen || inputX>board.boardCol.length) {
                	System.out.println("Oops seems like ship is going to be out of boundaries");                	
                }
                
            }while(board.boardCol.length<(inputY)+shipLen || inputX>board.boardCol.length);
            checkHorizontalCollision(someBoardArr[PlayerPlacement], inputX, inputY);
        }
        System.out.println("Place Horizontally ... 5 ");
        this.board = board;
        for(int i=0; i<shipLen; i++){
            someBoardArr[PlayerPlacement][inputY][inputX]=shipChar;
            inputY++;
        }
        PlayerPlacement = 0;
        shipError = true;
        return board;

    }
    public Board Vertical(Board board) 
    {
    	boardSplit();
        while(shipError==true){
            do{
                getCoordinates();
                System.out.println("Coord: " + inputX + " " + inputY);
                if(board.boardCol.length<(inputX+shipLen) || inputY>board.boardCol.length) {
                	System.out.println("Oops seems like ship is going to be out of boundaries");                	
                }
            }while(board.boardCol.length<(inputX+shipLen) || inputY>board.boardCol.length);
            System.out.println("Check: " + (inputX+shipLen) + "Boardlen" + board.boardCol.length + " " + board.boardRow.length);
            checkVerticalCollision(someBoardArr[PlayerPlacement], inputX, inputY);
        }
        System.out.println("Place Vertically ... 5 ");    
        this.board = board;
        for(int i=0; i<shipLen; i++){
            someBoardArr[PlayerPlacement][inputY][inputX]=shipChar;
            inputX++;
        }
        PlayerPlacement = 0;
        shipError = true;
        return board;

    }
    public void getCoordinates()
    {
    	int newX;
        int newY;
        String tmpInput = "Null";
        if(PlayerPlacement == 1){
            Scanner myObj = new Scanner(System.in);
            do{
                while (!isNumeric(tmpInput) || tmpInput.length()!=1) {
                    System.out.println("Enter starting X coordinate of where you want to place the ship: "); // canceled idea -> make a hash map for [A-n]=[1-n] this would allow user to choose coodrinate via letter input for Y coordinate.
                    tmpInput = myObj.nextLine();
                    tmpInput = alphaToNum(tmpInput);
                    
                }
                newX = Integer.parseInt(tmpInput);  
                tmpInput = "Null"  ;             
                inputX = newX-1;
            }while(newX<=0);
            do{
                while (!isNumeric(tmpInput) || tmpInput.length()!=1) {
                    System.out.println("Enter Y coordinate of where you want to place the ship: ");
                    tmpInput = myObj.nextLine();
                    if(!isNumeric(tmpInput) || tmpInput.length()!=1 || tmpInput.equals("0")) {
                    	System.out.println("Sorry invalid input. Please type a number, for example: '1' or '3' ");
                    }
                }
                
                newY = Integer.parseInt(tmpInput);
                tmpInput = "Null" ;                 
            	inputY = newY-1;
            }while(newY<=0);
        } else {
            Random rand = new Random();
            inputX=rand.nextInt(board.boardCol.length);
            inputY=rand.nextInt(board.boardRow.length);
        }
    }
    public String alphaToNum(String strInput)
    {
    	boolean charFound = false;
    	String xCoordinate = "";
    	int tmpInt = 0;
    	for(int i = 0; i<boardCol.length; i++) {
    		if(strInput.equals(boardCol[i])) {
    			tmpInt=i+1; // + 1 because later it would be -1
    			xCoordinate=String.valueOf(tmpInt);
    			charFound = true;
    		}
    	}
    	if (!charFound) {
    		System.out.println("Sorry invalid input. Please type a character, for example: 'A' or 'C' ");
    	}
    	charFound = false;
    	return xCoordinate; 

    	
    	
    }

    public void checkHorizontalCollision(String[][] someBoardArr, int X, int Y)
    {
        for(int i =0; i<shipLen; i++){
            if(someBoardArr[Y+i][X]!=" "){
                shipError=true; 
                System.out.println("Oops, seems like there is a collision with some other ship");
                return;
            }else{
                shipError=false;
            }
        }
    }
    public void checkVerticalCollision(String[][] someBoardArr, int X, int Y)
    {
        for(int i =0; i<shipLen; i++){
            if(someBoardArr[Y][X+i]!=" "){
                shipError=true;
                System.out.println("Oops, seems like there is a collision with some other ship");
                return;
            }else{
                shipError=false;
            }
        }
    }
    public void boardSplit()
    {
        someBoardArr[1] = board.boardArrPlayer;
        someBoardArr[0] = board.boardArrEnemy;
    }


    public boolean getErrorStatus()
    {
        return shipError;
    }
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
