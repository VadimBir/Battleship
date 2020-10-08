import java.util.Random;
import java.util.Scanner;

public class Coordinates {
    int x;
    int y;
    int MapSize;
    Scanner myObj = new Scanner(System.in);
    public Coordinates(int Mapsize) 
    {
    	this.MapSize = Mapsize;
	}
    public void getCoordinates(){
        System.out.println("Enter X coordinate of where to shoot: ");
        x = myObj.nextInt()-1;         
        System.out.println("Enter Y coordinate of where to shoot: ");
        y = myObj.nextInt()-1;
    }
    public void getAutoCoordinates()
    {
    	Random rand = new Random();
    	x=rand.nextInt(MapSize);
        y=rand.nextInt(MapSize);
    }
    

}
