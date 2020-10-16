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
        /*
        if(character.getIsPlayerCharacter() ==true){
            if( character.charBoardArr[0][y][x] != " " && character.charBoardArr[0][y][x] != "X"){
                character.charBoardArr[0][y][x] = "@";
                character.shipTilesLeft = character.shipTilesLeft -1;
                if(character.shipTilesLeft == 0){
                    character.setState(character.getLostState());
                }
            }else{
                character.charBoardArr[0][y][x] ="X";
                character.setState(character.getIsCurrentTurnState());
            }
        }else{
        */
            //technically I think I can remove the player check, ... 
    	//the boardArr is not being passed 
    	//char tmpChar = character.charBoardArr[0][y][x].charAt(0);
    	//String toCheckString = String.valueOf(tmpChar);
            if(!character.charBoardArr[0][y][x].equals(" ") && !character.charBoardArr[0][y][x].equals("X") && !character.charBoardArr[0][y][x].equals("@")){
            	//System.out.println("What is it sooting? " + "'" + character.charBoardArr[0][y][x]+ "'" );
            	character.charBoardArr[0][y][x] = "@";
                isHit = true;
                if(character.getIsPlayerCharacter() == false){
                    character.charBoardArr[1][y][x] = "@"; // clean map that would be shown to a human player
                }
                if(isHit == true) {
                	character.shipTilesLeft = character.shipTilesLeft -1;
                	System.out.println("Player? " + character.isPlayerCharacter + "HP? " + character.shipTilesLeft);
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
                /*
                else if(character.charBoardArr[0][y][x] == "X" || character.charBoardArr[0][y][x] == "@"){
            		Coordinates shootTo = new Coordinates(character.charBoardArr.length);
            		if(character.getIsPlayerCharacter() == false){            			
            		shootTo.getAutoCoordinates();
            		gotShot(shootTo.x, shootTo.y);
            		}else {
            			shootTo.getAutoCoordinates(); // change this to non auto coz its a player input 
                		gotShot(shootTo.x, shootTo.y);
            		} 
            	} 
            	*/
                if(character.getIsPlayerCharacter() ==false){
                    character.charBoardArr[1][y][x] ="X";
                }
                character.setState(character.getIsCurrentTurnState());
            }
    }
    /*   
	@Override
	public void shootEnemy(String[][] CharacterBoardArr) {
        System.out.println("Oh oh, its not fair to shoot when its not your turn ...");

		
    }
    */

}
