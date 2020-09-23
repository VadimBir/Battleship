public class Driver {

	public static void main(String[] args) {
		
//working building board and drawing it using factory mode 
//two boards available 8x8 and 10x10
		BoardFactory boardFactory = new BoardFactory();
		Board board = boardFactory.createBoard("8x8");
		//Board boardEnemy = boardFactory.createBoard("8x8");
		board.setBoard();
		//board.setBoard();

		System.out.println(" ");
		//Board board2 = boardFactory.createBoard("10x10");
		//board2.setBoard();
		
		board.boardArrEnemy[4][5]="@";
		//board.boardArr[4][5]="@";
		board.setBoard();
//---------------------------
		
		//user input
		//... here inputs: 
		//(C-Carries B-Battleship D-Destroyer S-Submarine P-Patrol_Boat)(H-hori V-vert)(A-..)(1-..)

		Carrier playerCarrier = new Carrier();

		Command[] CmdArrCarrier;
		CmdArrCarrier = new Command[2];
		CmdArrCarrier[0]= new CarrierHorizontal(playerCarrier);
		CmdArrCarrier[1]= new CarrierVertical(playerCarrier, board);

		ControlShipPlacement CarrierCtrlArr= new ControlShipPlacement(CmdArrCarrier);

		CarrierCtrlArr.CmdArr(1); // this places a ship on coordinates, for now its fixed 
		board.setBoard();





	}
	

}
