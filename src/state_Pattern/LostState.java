package state_Pattern;
import java.io.Serializable;

public class LostState implements State, Serializable{
	GameCharacter character;
	public LostState(GameCharacter gameCharacter) {
		this.character = gameCharacter;
	}
	@Override
	public void shootEnemy(GameCharacter enemy, int x, int y) {
		System.out.println("Player that is lost cant shoot other players");
		
	}
	@Override
	public void gotShot(int x, int y) {
		System.out.println("Player that is lost cant get shot");
		
	}
    
}
