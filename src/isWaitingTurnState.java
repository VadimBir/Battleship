public class isWaitingTurnState implements State{
    
    GameCharacter character;
    int shipTilesLeft;
    

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
            if( character.charBoardArr[0][y][x] != " " && character.charBoardArr[0][y][x] != "X"){
                character.charBoardArr[0][y][x] = "@";
                if(character.getIsPlayerCharacter() == false){
                    character.charBoardArr[1][y][x] = "@"; // clean map that would be shown to a human player
                }
                character.shipTilesLeft = character.shipTilesLeft -1;
                if(character.shipTilesLeft == 0){
                    character.setState(character.getLostState());
                }else{
                    character.setState(character.getIsCurrentTurnState());
                }
            }else{
                character.charBoardArr[0][y][x] ="X";
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
