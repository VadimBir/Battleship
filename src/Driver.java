import decorator_Pattern.*;
import java.util.Random;
import java.util.Scanner;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Driver implements Serializable{

	public static void main(String[] args) throws IOException, ClassNotFoundException {
	
		System.out.println("Working Directory = " + System.getProperty("user.dir"));
		GameMenu();

	}

	public static void GameMenu() throws FileNotFoundException, ClassNotFoundException, IOException
	{
		Scanner userScan = new Scanner(System.in);
		String userinput = "-1";


		while(!(userinput.equals("4"))) {
			
		System.out.println("\t Game Menu:");
		System.out.println("1. Play");
		System.out.println("2. Resume");
		System.out.println("3. How to play \n");
		System.out.println("4. Quit\n");
		userinput= userScan.nextLine();
		callMenuObj(userinput);
		}
	}
	
	public static void callMenuObj(String userInput) throws FileNotFoundException, ClassNotFoundException, IOException
	{
		switch(userInput) {
			case "1":
			Menu play = new Play();
				play.Display(); 
				break;
			case "2":
				Menu resume = new Resume();
				resume.Display();
				break;
			case "3":
			Menu howTo = new HowTo();
				howTo.Display();
				break;
			case "4":
				Menu quit = new Quit();
				quit.Display();
				break;
			default:
				System.out.println("Sorry invalid input please choose an option 1, 2, 3 or 4");
		}
	}
}



