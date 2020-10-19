package decorator_Pattern.game;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import command_Pattern.*;
import factory_Pattern.Board;

public class Coordinates implements Serializable{
    int x;
    int y;
    int mapSize;
    boolean[][] isAlreadyShot;
    boolean backToMenu = false;
    String[] boardCol;
    public Coordinates(int mapsize, String[] boardCol) 
    {
    	this.boardCol = boardCol;
        this.mapSize = mapsize;
        isAlreadyShot = new boolean[mapsize][mapsize];
        for (boolean[] row1 : isAlreadyShot) {
            Arrays.fill(row1, false);
        }
	}
    public void getCoordinates(){
    	Scanner myObj = new Scanner(System.in);
    	String tmpInput = "Null";
        do{
            do {
	        	do {
	            	System.out.println("Enter X coordinate of where to shoot: (b) go to main menu");
                    tmpInput = myObj.nextLine();
                    if(!(tmpInput.equals("b"))) {
                    	tmpInput = alphaToNum(tmpInput);                    	
                    }
                    if(!Ships.isNumeric(tmpInput) && !tmpInput.equals("b")) {
                    	System.out.println("Sorry input is not a character, please try again.");
                    }
                }while (!Ships.isNumeric(tmpInput) && !tmpInput.equals("b"));
	        	if(tmpInput.equals("b")) {
	        		backToMenu = true;	
	        		return;
	        	}
        		x = Integer.parseInt(tmpInput)-1;  
	            if(mapSize<=y || y>=mapSize || y<0) {
	            	System.out.println("Sorry seems like character is out of boundaries, please try again.");
	            }
            }while(mapSize<=x || x>=mapSize || x<0 );
            tmpInput = "Null";
                
            do {
	        	do {
	            	System.out.println("Enter Y coordinate of where to shoot: (b) go to main menu");
	            	tmpInput = myObj.nextLine();
	            	if((!Ships.isNumeric(tmpInput) && !tmpInput.equals("b")) || tmpInput.length()!=1 ) {
                    	System.out.println("Sorry input is not a number, please try again.");
                    }
	            }while ((!Ships.isNumeric(tmpInput) && !tmpInput.equals("b")) || tmpInput.length()!=1 );
	        	if(tmpInput.equals("b")) {
	        		backToMenu = true;	
	        		return;
	        	}
	            y = Integer.parseInt(tmpInput)-1;  
	            if(mapSize<=y || y>=mapSize || y<0) {
	            	System.out.println("Sorry seems like value is out of boundaries, please try again.");
	            }
            }while(mapSize<=y || y>=mapSize || y<0);
            tmpInput = "Null";
            if(isAlreadyShot[x][y]==true) {
            	System.out.println("Opps, seems like you already shot there.");
            }
        }while(isAlreadyShot[y][x]==true);
        isAlreadyShot[y][x]=true;
    }
    public void getAutoCoordinates()
    {
        Random rand = new Random();
        do{
            x=rand.nextInt(mapSize);
            y=rand.nextInt(mapSize);
        }while(isAlreadyShot[y][x]==true);
        isAlreadyShot[y][x]=true;
    }
    
    public String alphaToNum(String strInput)
    {
    	//Ships toGetvarShips = new Ships;
    	
    	String xCoordinate = "";
    	int tmpInt = 0;
    	for(int i = 0; i<boardCol.length; i++) {
    		if(strInput.equals(boardCol[i])) {
    			tmpInt=i+1; // + 1 because later it would be -1
    			xCoordinate=String.valueOf(tmpInt);
    		}
    	}
    	return xCoordinate; 
    }

}
