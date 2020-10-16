import java.io.Serializable;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Coordinates extends Driver{
    int x;
    int y;
    int mapSize;
    boolean[][] isAlreadyShot;
    boolean backToMenu = false;
    public Coordinates(int mapsize) 
    {
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
                }while (!Ships.isNumeric(tmpInput) && !tmpInput.equals("b"));
	        	if(tmpInput.equals("b")) {
	        		backToMenu = true;	
	        		return;
	        	}
        		x = Integer.parseInt(tmpInput)-1;  
	  
            }while(mapSize<=x || x>=mapSize || x<0 );
            tmpInput = "Null";
                
            do {
	        	do {
	            	System.out.println("Enter Y coordinate of where to shoot: (b) go to main menu");
	            	tmpInput = myObj.nextLine();
	            }while (!Ships.isNumeric(tmpInput) && !tmpInput.equals("b"));
	        	if(tmpInput.equals("b")) {
	        		backToMenu = true;	
	        		return;
	        	}
	            y = Integer.parseInt(tmpInput)-1;  
            }while(mapSize<=y || y>=mapSize || y<0);
            tmpInput = "Null";
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
    

}
