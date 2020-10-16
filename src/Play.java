import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Play extends Menu {

    public void Display() throws IOException
    {

        System.out.println("New game");
        Game game = new Game();
        game.ChooseBoard();
        game.ShipPlacement(); 
        SaveGame(game);	
        game.GameProcess();

    }
    
    public static void SaveGame(Game game) throws IOException
	{
		
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("game.sav"));
        objectOutputStream.writeObject(game);
        objectOutputStream.close();

	}
    
}
