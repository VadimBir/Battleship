import java.io.Serializable;
import java.util.Random;
import java.util.Scanner;

public class Game implements Serializable{
	
	BoardFactory boardFactory;
	Board board;
	Board boardTmp;
	Random rand; // to make horizontal or vertical to be random for AI
    
    Game()
    {
    	this.boardFactory = new BoardFactory();
    	this.board = boardFactory.createBoard("10x10");
    	this.boardTmp = board;
    	this.rand = new Random();
    }

    public void ChooseBoard()
    {

		board.setBoard();


		System.out.println(" ");

		board.setBoard();
		
    }
    public void ShipPlacement()
    {
    	//carrier placement ----------------------------------------------------------------
    			Carrier carrier = new Carrier(board);
    			Command[] CmdArrCarrier;
    			CmdArrCarrier = new Command[2];
    			CmdArrCarrier[0]= new CarrierHorizontal(carrier, boardTmp);
    			CmdArrCarrier[1]= new CarrierVertical(carrier, boardTmp);
    			ControlShipPlacement CarrierCtrlArr= new ControlShipPlacement(CmdArrCarrier);
    			
    			//  make a user input for either horizontal or vertical
    			System.out.println("Please choose the way you want to put the Carreir Ship: ");
    			System.out.println("1 Horizontal.");
    			System.out.println("2 Vertical.");

    			CarrierCtrlArr.CmdArr(1);
    			board=boardTmp;
    			CarrierCtrlArr.CmdArr(rand.nextInt(2)); // running the command the second time would allow to do a random ship placement for an AI. 
    			board=boardTmp;

    			board.setBoard();
    	//-----------------------------------------------------------------
    	//battleship placement ----------------------------------------------------------------
    		
    		Battleship battleship = new Battleship(board);

    		Command[] CmdArrBattleship;
    		CmdArrBattleship = new Command[2];
    		CmdArrBattleship[0]= new BattleshipHorizontal(battleship, boardTmp);
    		CmdArrBattleship[1]= new BattleshipVertical(battleship, boardTmp);
    		ControlShipPlacement BattleshipCtrlArr= new ControlShipPlacement(CmdArrBattleship);

    		//  make a user input for either horizontal or vertical
    		BattleshipCtrlArr.CmdArr(1);
    		board=boardTmp;
    		BattleshipCtrlArr.CmdArr(rand.nextInt(2)); // running the command the second time would allow to do a random ship placement for an AI. 
    		board=boardTmp;
    		board.setBoard();
    	//-----------------------------------------------------------------


    	//Destroyer placement ----------------------------------------------------------------
    		
    		Destroyer destroyer = new Destroyer(board);

    		Command[] CmdArrDestroyer;
    		CmdArrDestroyer = new Command[2];
    		CmdArrDestroyer[0]= new DestroyerHorizontal(destroyer, boardTmp);
    		CmdArrDestroyer[1]= new DestroyerVertical(destroyer, boardTmp);
    		ControlShipPlacement DestroyerCtrlArr= new ControlShipPlacement(CmdArrDestroyer);

    		//  make a user input for either horizontal or vertical
    		DestroyerCtrlArr.CmdArr(1);
    		board=boardTmp;
    		DestroyerCtrlArr.CmdArr(rand.nextInt(2)); // running the command the second time would allow to do a random ship placement for an AI. 
    		board=boardTmp;
    		board.setBoard();
    	//-----------------------------------------------------------------

    	//Submarine placement ----------------------------------------------------------------
    		
    		Submarine submarine = new Submarine(board);

    		Command[] CmdArrSubmarine;
    		CmdArrSubmarine = new Command[2];
    		CmdArrSubmarine[0]= new SubmarineHorizontal(submarine, boardTmp);
    		CmdArrSubmarine[1]= new SubmarineVertical(submarine, boardTmp);
    		ControlShipPlacement SubmarineCtrlArr= new ControlShipPlacement(CmdArrSubmarine);

    		//  make a user input for either horizontal or vertical
    		SubmarineCtrlArr.CmdArr(1);
    		board=boardTmp;
    		SubmarineCtrlArr.CmdArr(rand.nextInt(2)); // running the command the second time would allow to do a random ship placement for an AI. 
    		board=boardTmp;
    		board.setBoard();
    	//-----------------------------------------------------------------

    	//PatrolBoat placement ----------------------------------------------------------------
    		
    		PatrolBoat patrolBoat = new PatrolBoat(board);

    		Command[] CmdArrPatrolBoat;
    		CmdArrPatrolBoat = new Command[2];
    		CmdArrPatrolBoat[0]= new PatrolBoatHorizontal(patrolBoat, boardTmp);
    		CmdArrPatrolBoat[1]= new PatrolBoatVertical(patrolBoat, boardTmp);
    		ControlShipPlacement PatrolBoatCtrlArr= new ControlShipPlacement(CmdArrPatrolBoat);

    		//  make a user input for either horizontal or vertical
    		PatrolBoatCtrlArr.CmdArr(1);
    		board=boardTmp;
    		PatrolBoatCtrlArr.CmdArr(rand.nextInt(2)); // running the command the second time would allow to do a random ship placement for an AI. 
    		board=boardTmp;
    		board.setBoard();
    		
    	//-----------------------------------------------------------------
    	//All ships are being placed ^^^^
    }
    
    public void GameProcess()
    {
    	board.setBoard();
    	// Game process here 

    		Coordinates shootTo = new Coordinates(board.boardCol.length);
    		Coordinates shootToEnemy = new Coordinates(board.boardCol.length);
    		// length to find limit may be add input of board of player and make an algorith for AI
    		GameCharacter player = new GameCharacter(board.boardArrPlayer, true);
    		//player.isPlayerCharacter = true;
    		GameCharacter enemy = new GameCharacter(board.boardArrEnemy, false);
    		//enemy.isPlayerCharacter = false;
    		
    		
    		
    		//loop Part 
    		while(player.getState()!=player.getWinState() && player.getState()!=player.getLostState()){

    			shootTo.getAutoCoordinates(); //getCoordinates();
    			System.out.println("Location: " + shootTo.x + " and " + shootTo.y + "StateP: " + player.getState().toString() + " HP: " + player.shipTilesLeft);
    			player.shootEnemy(enemy, shootTo.x, shootTo.y);
    			
    			shootToEnemy.getAutoCoordinates();
    			System.out.println("Location: " + shootTo.x + " and " + shootTo.y + " StateE: " + enemy.getState().toString() + " HP: " + enemy.shipTilesLeft);
    			enemy.shootEnemy(player, shootTo.x, shootTo.y);
    			board.boardArrPlayer = player.charBoardArr[0];
    			board.boardArrEnemy  = enemy.charBoardArr[1];  
    			board.setBoard();
    			
    			if (player.shipTilesLeft==1) {
    				System.out.println("Player Nearly Lost");
    			}

    		}
    		System.out.println("After Game Loop");
    		System.out.println("Location: " + shootTo.x + " and " + shootTo.y + "StateP: " + player.getState().toString());
    		System.out.println("Location: " + shootTo.x + " and " + shootTo.y + "StateE: " + enemy.getState().toString());
    		
    		if(player.getState()==player.getWinState()) {
    			System.out.println("Player Has Won !!!!!!!!!!!!!");
    		}
    		if(player.getState()==player.getLostState()) {
    			System.out.println("Player Has Lost !!!!!!!!!!!!!");
    		}
    }



}
