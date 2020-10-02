import java.util.Random;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		
//working building board and drawing it using factory mode 
//two boards available 8x8 and 10x10
		BoardFactory boardFactory = new BoardFactory();
		Board board = boardFactory.createBoard("10x10");
		Board boardTmp = board;
		//Board boardEnemy = boardFactory.createBoard("8x8");
		board.setBoard();
		//board.setBoard();

		System.out.println(" ");
		//Board board2 = boardFactory.createBoard("10x10");
		//board2.setBoard();
		board.boardArrPlayer[4][4]="D";
		board.boardArrEnemy[4][5]="@";
		//board.boardArr[4][5]="@";
		board.setBoard();
//---------------------------
		
		//user input
		//... here inputs: // no input here because to check errors it would be easier to do it during ship placement
		//int inputX =2;
		//int inputY =2;


		//(C-Carries B-Battleship D-Destroyer S-Submarine P-Patrol_Boat)(H-hori V-vert)(A-..)(1-..)

		
		Random rand = new Random(); // to make horizontal or vertical to be random for AI
		

//carrier placement ----------------------------------------------------------------
		Carrier carrier = new Carrier(board);
		Command[] CmdArrCarrier;
		CmdArrCarrier = new Command[2];
		CmdArrCarrier[0]= new CarrierHorizontal(carrier, boardTmp);
		CmdArrCarrier[1]= new CarrierVertical(carrier, boardTmp);
		ControlShipPlacement CarrierCtrlArr= new ControlShipPlacement(CmdArrCarrier);
		
		//  make a user input for either horizontal or vertical
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
//All ships are being placed 


	
	} //end of main
	


}
