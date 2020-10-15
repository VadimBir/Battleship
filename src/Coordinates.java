import java.io.Serializable;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Coordinates{
    int x;
    int y;
    int MapSize;
    Scanner myObj = new Scanner(System.in);
    boolean[][] isAlreadyShot;
    public Coordinates(int Mapsize) 
    {
        this.MapSize = Mapsize;
        isAlreadyShot = new boolean[Mapsize][Mapsize];
        for (boolean[] row1 : isAlreadyShot) {
            Arrays.fill(row1, false);
        }
	}
    public void getCoordinates(){
        do{
            System.out.println("Enter X coordinate of where to shoot: ");
            x = myObj.nextInt()-1;         
            System.out.println("Enter Y coordinate of where to shoot: ");
            y = myObj.nextInt()-1;
        }while(isAlreadyShot[y][x]==true);
        isAlreadyShot[y][x]=true;
    }
    public void getAutoCoordinates()
    {
        Random rand = new Random();
        do{
            x=rand.nextInt(MapSize);
            y=rand.nextInt(MapSize);
        }while(isAlreadyShot[y][x]==true);
        isAlreadyShot[y][x]=true;
    }
    

}
