import java.io.Serializable;

public class WinState implements State, Serializable{
	GameCharacter character;
	public WinState(GameCharacter gameCharacter) {
		this.character = gameCharacter;
	}
	@Override
	public void shootEnemy(GameCharacter enemy, int x, int y) {
		System.out.println("Player that is Won cant shoot other players");
		
	}
	@Override
	public void gotShot(int x, int y) {
		System.out.println("Player that Won cant get shot");
		
	}
}
