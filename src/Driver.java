public class Driver {

	public static void main(String[] args) {
		
//working building board and drawing it using factory mode 
//two boards available 8x8 and 10x10
		BoardFactory boardFactory = new BoardFactory();
		Board board = boardFactory.createBoard("8x8");
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



		//carrier placement
		Carrier carrier = new Carrier(board);

		Command[] CmdArrCarrier;
		CmdArrCarrier = new Command[2];
		CmdArrCarrier[0]= new CarrierHorizontal(carrier, boardTmp/*, inputX, inputY*/);
		CmdArrCarrier[1]= new CarrierVertical(carrier, boardTmp/*, inputX, inputY*/);
		ControlShipPlacement CarrierCtrlArr= new ControlShipPlacement(CmdArrCarrier);
		
		//  make a user input for either horizontal or vertical
		CarrierCtrlArr.CmdArr(1);
		board=boardTmp;
		CarrierCtrlArr.CmdArr(0); // running the command the second time would allow to do a random ship placement for an AI. 
		board=boardTmp;
		//CarrierCtrlArr.CmdArr(1); // this places a ship on coordinates, for now its fixed 
		board.setBoard();





	}
	

}
