package state_Pattern;
import java.io.Serializable;
import java.util.Scanner;

public class isCurrentTurnState implements State, Serializable{
    
    GameCharacter character;
    int shipTilesLeft;

    public isCurrentTurnState(GameCharacter character)
    {
        this.character = character;
    }
    public void shootEnemy(GameCharacter enemy, int x, int y)
    {

        //System.out.println("Shoot enemy method ...");

        enemy.gotShot(x,y);
        if (enemy.shipTilesLeft ==0) {
        	enemy.setState(enemy.getLostState());
        	character.setState(character.getWinState());
        	return;
        }
        character.setState(character.getIsWaitingState());


    }
    public void gotShot(int x, int y)
    {
        System.out.println("Ooops you it seems like you cant get shot when its your turn.");
    }


}
