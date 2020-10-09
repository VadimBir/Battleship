import java.util.Random;
import java.util.Scanner;
import java.awt.print.Printable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Driver implements Serializable{

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		//final Path path = Files.createTempFile("gameSave", ".save");
		//String current = System.getProperty("user.dir")+"\\gameSave.save";
		//System.out.println(current);
		//boolean saveExists = false;
		String curPath;
		final String fileName="game";		
		Path directoryPath = Paths.get("");
		curPath =directoryPath.toAbsolutePath().toString();
		
		File fileCheck=new File(directoryPath+fileName+".sav");
		/*
		boolean testFile=fileCheck.exists();
//assign folder path 
		String toFilePath=curPath+ File.separator +fileName; //path to inward the folder
		
		//File tempFile = new File(current);
		*/
		//saveExists = tempFile.exists();
		if(fileCheck.exists()==true) {
			System.out.println("There is a Save File !!");
		}else {
			System.out.println("No save File");
		}
		
		
		System.out.println("Working Directory = " + System.getProperty("user.dir"));
		//Driver obj = new Driver();

		
		Game game = new Game();
		if (fileCheck.exists()==true) {
			game = ReadSaveGame();
		}else {
			game.ChooseBoard();
			game.ShipPlacement();
			
		}
		//SaveGame(game);
		System.out.println(" ");
		game.GameProcess();
	}
	
	public static void SaveGame(Game game) throws IOException
	{
		
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("game.sav"));
        objectOutputStream.writeObject(game);
        objectOutputStream.close();

		
		
		/*
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(System.getProperty("user.dir")+ "\\gameSave.save")); 
			oos.writeObject(game);
			System.out.println("Done");
			*/
		
	}
	public static Game ReadSaveGame() throws FileNotFoundException, IOException, ClassNotFoundException
	{
		
		//Game game = null;
		
		ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("game.sav"));
        Object game = objectInputStream.readObject();
        objectInputStream.close();
		return (Game) game;
		
	}
	
}


		/*
//two boards available 8x8 and 10x10
		BoardFactory boardFactory = new BoardFactory();
		Board board = boardFactory.createBoard("10x10");
		Board boardTmp = board;

		board.setBoard();


		System.out.println(" ");

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


// Game process here 
// Do State Pattern here

	Coordinates shootTo = new Coordinates(board.boardCol.length);
	Coordinates shootToEnemy = new Coordinates(board.boardCol.length);
	// length to find limit may be add input of board of player and make an algorith for AI
	GameCharacter player = new GameCharacter(board.boardArrPlayer, true);
	//player.isPlayerCharacter = true;
	GameCharacter enemy = new GameCharacter(board.boardArrEnemy, false);
	//enemy.isPlayerCharacter = false;
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
		/*
		if (player.shipTilesLeft==0){
			player.lostGame=true;
			enemy.wonGame=true;
		}
		if (enemy.shipTilesLeft==0){
			enemy.lostGame=true;
			player.wonGame=true;
		}
		*/
	/*
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
	*/
	//} //end of main
	


//}


