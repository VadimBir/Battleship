import java.util.Arrays;

public class GameCharacter {
    State iscurrentturnState;
    State iswaitingState;
    State winState;
    State lostState;
    State state;

    int shipTilesLeft = 17;
//double check num !!!!!!!! -----------------------------------------
    
    String[][][] charBoardArr;
    GameCharacter otherCharacter;
    boolean isPlayerCharacter;


    public GameCharacter(String[][] someCharBoardArr, boolean whoIsCharacter)
    {
        iscurrentturnState = new isCurrentTurnState(this);
        iswaitingState = new isWaitingTurnState(this);
        winState = new WinState(this);
        lostState = new LostState(this);
        this.isPlayerCharacter = whoIsCharacter;
        
        this.charBoardArr = new String[2][someCharBoardArr.length][someCharBoardArr.length];
        
        for (int i= 0; i < someCharBoardArr.length; i++){
            for (int j = 0; j < someCharBoardArr.length; j++){
                this.charBoardArr[0][i][j]=someCharBoardArr[i][j];
            }
        }
        for (int i= 0; i < someCharBoardArr.length; i++){
            for (int j = 0; j < someCharBoardArr.length; j++){
                this.charBoardArr[1][i][j]=" ";
            }
        }

        
        //System.arraycopy(someCharBoardArr, 0, this.charBoardArr[0], 0, someCharBoardArr.length);
        //this.charBoardArr[0] = charBoardArr;
        //this.charBoardArr[1] = charBoardArr;
        //for (String[] row1 : someCharBoardArr) {
        //    Arrays.fill(row1, " ");
        //}
        //System.arraycopy(someCharBoardArr, 0, this.charBoardArr, 0, someCharBoardArr.length);
        if(isPlayerCharacter==true){
            state = iscurrentturnState;
        }else{
            state = iswaitingState;
        }

    }

    public void setState(State state)
    {
        this.state = state;
    }
    public State getState()
    {
        return state;
    }
    public void getStringState()
    {
        state.				// check last version 


    }
    public State getLostState()
    {
        return lostState;
    }
    public State getWinState()
    {
        return winState;
    }
    public State getIsCurrentTurnState()
    {
        return iscurrentturnState;
    }
    public State getIsWaitingState()
    {
        return iswaitingState;
    }

    public void setIsPlayerCharacter(boolean isHuman)
    {
        this.isPlayerCharacter=isHuman;
    }
    public boolean getIsPlayerCharacter()
    {
        return isPlayerCharacter;
    }
    public String[][][] getCharBoardArr()
    {
        return charBoardArr;
    }

	public void shootEnemy(GameCharacter enemy, int x, int y) {
		this.otherCharacter = enemy;
		state.shootEnemy(enemy, x, y);
		
	}
	public void gotShot(int x, int y) {
		state.gotShot(x, y);
	}



}


