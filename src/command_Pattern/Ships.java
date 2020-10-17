package command_Pattern;
import java.util.Random;
import java.util.Scanner;

import factory_Pattern.*;

abstract public class Ships extends Board{

    int shipLen= 1;
    String shipChar = "Err";
    private int inputY;
    private int inputX;
    public boolean shipError= true;
    Board board;
    private int PlayerPlacement=1;
    String[][][] someBoardArr;


    Ships(Board board, int someShipLen, String somShipChar)
    {
        shipLen = someShipLen;
        shipChar = somShipChar;
        this.board = board;
        someBoardArr = new String[2][board.boardCol.length][board.boardRow.length];
    }

    public Board Horizontal(Board board)
    {
        boardSplit();
        while(shipError==true){
            do{
                getCoordinates();
                System.out.println("Coord: " + inputX + " " + inputY);
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
                while (!isNumeric(tmpInput)) {
                    System.out.println("Enter X coordinate: ");
                    tmpInput = myObj.nextLine();
                }
                newX = Integer.parseInt(tmpInput);  
                tmpInput = "Null"  ;             
                inputX = newX-1;
            }while(newX<=0);
            do{
                while (!isNumeric(tmpInput)) {
                    System.out.println("Enter Y coordinate: ");
                    tmpInput = myObj.nextLine();
                }
                newY = Integer.parseInt(tmpInput);
                tmpInput = "Null" ;                // make a hash map for [A-n]=[1-n] this would allow user to choose coodrinate via letter input for Y coordinate. 
            	inputY = newY-1;
            }while(newY<=0);
        } else {
            Random rand = new Random();
            inputX=rand.nextInt(board.boardCol.length);
            inputY=rand.nextInt(board.boardRow.length);
        }
    }

    public void checkHorizontalCollision(String[][] someBoardArr, int X, int Y)
    {
        for(int i =0; i<shipLen; i++){
            if(someBoardArr[Y+i][X]!=" "){
                shipError=true; 
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
