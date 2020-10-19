package decorator_Pattern;
import java.util.Scanner;

public class HowTo extends Menu{
	Scanner userScan = new Scanner(System.in);
    String input="-1";
    public void Display()
    {
        while(!(input.equals("b"))){   
        System.out.println("\t How To Play:");
        System.out.println("1) First choose play.");
        System.out.println("2) Choose the map you would like to play.");
        System.out.println("3) Choose the orientation of how you want to put a ship either horizontal or vertical");
        System.out.println("4) Choose the starting coordinate for the ship placement,\n for example horizontally on X-axis A and Y-axis 2 would put a ship like this:");
        System.out.println("	 Player: \r\n" + 
        		"    [A][B][C][D][E][F][G][H][I][J]\r\n" + 
        		"[ 1][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]\r\n" + 
        		"[ 2][B][B][B][B][ ][ ][ ][ ][ ][ ]");
        System.out.println("5) Choose where you would like to shoot.");
        System.out.println("\t If you missed it would show up as [X]. If it was a hit it would show up as [@].");
        System.out.println("6) Goal of the game is to hit all enemy ships.");
        
        System.out.println("\nEnjoy the game.");
        
        System.out.println("\n \n b: Go back");
            input = userScan.nextLine();
        }
    }
}
