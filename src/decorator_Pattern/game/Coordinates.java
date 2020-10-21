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
    String[] boardRow;
    public Coordinates(int mapsize, String[] boardCol, String[] boardRow) 
    {
    	this.boardCol = boardCol;
    	this.boardRow = boardRow;
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
                    	tmpInput = alphaToNum(tmpInput, boardCol);                    	
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
                    if(!(tmpInput.equals("b"))) {
                    	tmpInput = alphaToNum(tmpInput, boardRow);                    	
                    }
                    if(!Ships.isNumeric(tmpInput) && !tmpInput.equals("b")) {
                    	System.out.println("Sorry input is not a character, please try again.");
                    }
                }while (!Ships.isNumeric(tmpInput) && !tmpInput.equals("b"));
	            	/*
	            	if((!Ships.isNumeric(tmpInput) && !tmpInput.equals("b")) || tmpInput.length()!=1 ) { // bug with len = 1 coz it can be len 2 ex. 10 
                    	System.out.println("Sorry input is not a number, please try again.");
                    }
	            }while ((!Ships.isNumeric(tmpInput) && !tmpInput.equals("b")) || tmpInput.length()!=1 );
	            	 */
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
    
    public String alphaToNum(String strInput, String[] boardAxis)
    {
    	//Ships toGetvarShips = new Ships;
    	
    	String axisCoordinate = "";
    	int tmpInt = 0;
    	for(int i = 0; i<boardAxis.length; i++) {
    		if(strInput.equals(boardAxis[i].replaceAll("\s+", ""))) {
    			tmpInt=i+1; // + 1 because later it would be -1
    			axisCoordinate=String.valueOf(tmpInt);
    		}
    	}
    	return axisCoordinate; 
    }
    
    

}
