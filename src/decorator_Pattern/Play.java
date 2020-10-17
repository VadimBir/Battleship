package decorator_Pattern;
import decorator_Pattern.game.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Play extends Menu {
    static Game game = new Game();

    public void Display() throws IOException
    {

        System.out.println("New game");
        game.ChooseBoard();
        game.ShipPlacement(); 
        SaveGame(game);	
        game.GameProcess(game);

    }
    
    public static void SaveGame(Game game) throws IOException
	{
		
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("game.sav"));
        objectOutputStream.writeObject(game);
        objectOutputStream.close();

    }
    public static Game getGame()
    {
        return game;
    }
    
}
