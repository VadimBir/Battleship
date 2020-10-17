package decorator_Pattern;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Resume extends Menu{
    
    static Scanner userScan = new Scanner(System.in);
    static String input="-1";

    public void Display() throws FileNotFoundException, ClassNotFoundException, IOException
    {

        System.out.println("Reading Save file...");
        SaveFileCheck();
    }

    public static void SaveFileCheck() throws FileNotFoundException, ClassNotFoundException, IOException
	{
		String curPath;
		final String fileName="game";		
		Path directoryPath = Paths.get("");
		curPath =directoryPath.toAbsolutePath().toString();
		File fileCheck=new File(directoryPath+fileName+".sav");
		
		if(fileCheck.exists()==true) {
			System.out.println("There is a Save File !!");
		}else {
			System.out.println("No save File");
		}
		
		
        Game game = null;
		if (fileCheck.exists()==true) {
            while(!(input.equals("Y")) && !(input.equals("N"))){   
            System.out.println("Do you want to resume the game? (Y/N)");
            input = userScan.nextLine();
            }
            if (input.equals("Y")){
                game = ReadSaveGame(); 
                game.gameLoaded = true;
        		game.GameProcess(game);
            }
            input = "-1";
		}
		return;
	}

    public static Game ReadSaveGame() throws FileNotFoundException, IOException, ClassNotFoundException
	{

		ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("game.sav"));
        Object game = objectInputStream.readObject();
        objectInputStream.close();
		return (Game) game;
		
	}


}
