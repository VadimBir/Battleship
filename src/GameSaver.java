import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public abstract class GameSaver {
    
    public static void SaveGame(Game game) throws IOException
	{
		
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("game.sav"));
        objectOutputStream.writeObject(game);
        objectOutputStream.close();

	}
}
