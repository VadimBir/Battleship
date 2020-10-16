import java.util.Scanner;

public class HowTo extends Menu{
	Scanner userScan = new Scanner(System.in);
    String input="-1";
    public void Display()
    {
        while(!(input.equals("b"))){   
        System.out.println("\t How To Play:");
        System.out.println("...");

        
        System.out.println("\n \n b: Go back");
            input = userScan.nextLine();
        }






        //Explain how to play the game here

    }
}
