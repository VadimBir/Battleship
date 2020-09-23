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
		
		board.boardArrEnemy[4][5]="@";
		//board.boardArr[4][5]="@";
		board.setBoard();
//---------------------------
		
		//user input
		//... here inputs: 
		int inputX =2;
		int inputY =2;
		//(C-Carries B-Battleship D-Destroyer S-Submarine P-Patrol_Boat)(H-hori V-vert)(A-..)(1-..)

		Carrier playerCarrier = new Carrier();

		Command[] CmdArrCarrier;
		CmdArrCarrier = new Command[2];
		CmdArrCarrier[0]= new CarrierHorizontal(playerCarrier, boardTmp, inputX, inputY);
		CmdArrCarrier[1]= new CarrierVertical(playerCarrier, boardTmp, inputX, inputY);
		ControlShipPlacement CarrierCtrlArr= new ControlShipPlacement(CmdArrCarrier);
		boolean carrierError = true;
		CarrierCtrlArr.CmdArr(1);
		while (carrierError == false){
			
			if(boardTmp==null){
				boardTmp=board;
			}else{
				carrierError = false;
				board=boardTmp;
			}
		}
		//CarrierCtrlArr.CmdArr(1); // this places a ship on coordinates, for now its fixed 
		board.setBoard();





	}
	

}
