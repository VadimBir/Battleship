import java.util.Scanner;

public class isCurrentTurnState implements State{
    
    GameCharacter character;
    int shipTilesLeft;

    public isCurrentTurnState(GameCharacter character)
    {
        this.character = character;
    }
    public void shootEnemy(GameCharacter enemy, int x, int y)
    {
        System.out.println("Shoot enemy method ...");
        //System.out.println("Please enter the Row where you want to shoot:");

        enemy.gotShot(x,y);
        character.setState(character.getIsWaitingState());


    }
    public void gotShot(int x, int y)
    {
        System.out.println("Ooops you it seems like you cant get shot when its your turn.");
    }


}
