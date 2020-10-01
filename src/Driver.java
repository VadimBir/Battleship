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


//testing zone so OOP 

		



//carrier placement ----------------------------------------------------------------
		Carrier carrier = new Carrier(board);
		Command[] CmdArrCarrier;
		CmdArrCarrier = new Command[2];
		CmdArrCarrier[0]= new CarrierHorizontal(carrier, boardTmp/*, inputX, inputY*/);
		CmdArrCarrier[1]= new CarrierVertical(carrier, boardTmp/*, inputX, inputY*/);
		ControlShipPlacement CarrierCtrlArr= new ControlShipPlacement(CmdArrCarrier);
		
		//  make a user input for either horizontal or vertical
		CarrierCtrlArr.CmdArr(1);
		board=boardTmp;
		//make below to be rand, either 1 or 0 
		CarrierCtrlArr.CmdArr(0); // running the command the second time would allow to do a random ship placement for an AI. 
		board=boardTmp;

		board.setBoard();
//-----------------------------------------------------------------
//battleship placement ----------------------------------------------------------------
	/*
	Battleship battleship = new Battleship(board);

	Command[] CmdArrBattleship;
	CmdArrBattleship = new Command[2];
	CmdArrBattleship[0]= new BattleshipHorizontal(battleship, boardTmp);
	CmdArrBattleship[1]= new BattleshipVertical(battleship, boardTmp);
	ControlShipPlacement BattleshipCtrlArr= new ControlShipPlacement(CmdArrBattleship);

	//  make a user input for either horizontal or vertical
	BattleshipCtrlArr.CmdArr(1);
	board=boardTmp;
	//make below to be rand, either 1 or 0 
	BattleshipCtrlArr.CmdArr(0); // running the command the second time would allow to do a random ship placement for an AI. 
	board=boardTmp;

	board.setBoard();
	*/




	}
	

}
