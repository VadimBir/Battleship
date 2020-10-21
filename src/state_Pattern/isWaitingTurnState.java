package state_Pattern;
import java.io.Serializable;

public class isWaitingTurnState implements State, Serializable{
    
    GameCharacter character;
    int shipTilesLeft;
    boolean isHit = false;
    

    public isWaitingTurnState(GameCharacter character)
    {
        this.character = character;
    }
    public void shootEnemy(GameCharacter enemy, int x, int y)
    {
        System.out.println("Oh oh, its not fair to shoot when its not your turn ...");

    }
    public void gotShot(int x, int y) //[y][x]
    {
        
            if(!character.charBoardArr[0][y][x].equals(" ") && !character.charBoardArr[0][y][x].equals("X") && !character.charBoardArr[0][y][x].equals("@")){
            	
            	character.charBoardArr[0][y][x] = "@";
                isHit = true;
                if(character.getIsPlayerCharacter() == false){
                    character.charBoardArr[1][y][x] = "@"; // clean map that would be shown to a human player
                }
                if(isHit == true) {
                	character.shipTilesLeft = character.shipTilesLeft -1;
                	//System.out.println("Player? " + character.isPlayerCharacter + "HP? " + character.shipTilesLeft);
                	isHit = false;
                }
                if(character.shipTilesLeft == 0){
                    character.setState(character.getLostState());
                }else{
                    character.setState(character.getIsCurrentTurnState());
                }
            }else{
                if (character.charBoardArr[0][y][x] != "X" && character.charBoardArr[0][y][x] != "@") {
                    character.charBoardArr[0][y][x] ="X";            		
                }  
                
                if(character.getIsPlayerCharacter() ==false){
                    character.charBoardArr[1][y][x] ="X";
                }
                character.setState(character.getIsCurrentTurnState());
            }
    }
    

}
