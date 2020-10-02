import java.util.Random;
import java.util.Scanner;

public class Destroyer extends Ships{ 
    final static int destroyerLen= 3;
    final static String destroyerChar = "D";

    Destroyer(Board board) {
		super(board, destroyerLen, destroyerChar);
	} 



    /*
    private int inputY; 
    private int inputX;
    public boolean battleshipError= true;
    Board board;
    private int PlayerPlacement=1;
    String[][][] someBoardArr;
    
    Battleship(Board board)
    {
        this.board = board;
        someBoardArr = new String[2][board.boardCol.length][board.boardRow.length];
    }
    
    public Board Horizontal(Board board)
    {
        boardSplit();
        while(battleshipError==true){
            do{
                getCoordinates();
                System.out.println("Coord: " + inputX + " " + inputY);
            }while(board.boardCol.length<(inputY-1)+SHIP_LEN || inputX>board.boardCol.length);
            checkHorizontalCollision(someBoardArr[PlayerPlacement], inputX, inputY);
        }
        System.out.println("Place Horizontally ... 5 ");
        this.board = board;
        for(int i=0; i<SHIP_LEN; i++){
            someBoardArr[PlayerPlacement][inputY-1][inputX-1]=SHIP_CHAR;
            inputY++;
        }
        PlayerPlacement = 0;
        battleshipError = true;
        return board;
        
    }
    public Board Vertical(Board board) 
    {
        boardSplit();
        while(battleshipError==true){
            do{
                getCoordinates();
                System.out.println("Coord: " + inputX + " " + inputY);
            }while(board.boardCol.length<(inputX-1+SHIP_LEN) || inputY>board.boardCol.length);
            System.out.println("Check: " + (inputX-1+SHIP_LEN) + "Boardlen" + board.boardCol.length + " " + board.boardRow.length);
            checkVerticalCollision(someBoardArr[PlayerPlacement], inputX, inputY);
        }
        System.out.println("Place Vertically ... 5 ");    
        this.board = board;
        for(int i=0; i<SHIP_LEN; i++){
            someBoardArr[PlayerPlacement][inputY-1][inputX-1]=SHIP_CHAR;
            inputX++;
        }
        PlayerPlacement = 0;
        battleshipError = true;
        return board;
        
    }
    public void getCoordinates()
    {
        if(PlayerPlacement == 1){
            Scanner myObj = new Scanner(System.in);
            System.out.println("Enter X coordinate: ");
            int newX = myObj.nextInt();                 
            inputX = newX;
            System.out.println("Enter Y coordinate: ");
            int newY = myObj.nextInt();                 // make a hash map for [A-n]=[1-n] this would allow user to choose coodrinate via letter input for Y coordinate. 
            inputY = newY;
        } else {
            Random rand = new Random();
            inputX=rand.nextInt(board.boardCol.length);
            inputY=rand.nextInt(board.boardRow.length);
        }
    }
    
    public void checkHorizontalCollision(String[][] someBoardArr, int X, int Y)
    {
        for(int i =0; i<SHIP_LEN; i++){
            if(someBoardArr[Y-1+i][X-1]!=" "){
                battleshipError=true; 
                return;
            }else{
                battleshipError=false;
            }
        }
    }
    public void checkVerticalCollision(String[][] someBoardArr, int X, int Y)
    {
        for(int i =0; i<SHIP_LEN; i++){
            if(someBoardArr[Y-1][X-1+i]!=" "){
                battleshipError=true; 
                return;
            }else{
                battleshipError=false;
            }
        }
    }
    public void boardSplit()
    {
        someBoardArr[1] = board.boardArrPlayer;
        someBoardArr[0] = board.boardArrEnemy;
    }
    
    
    public boolean getErrorStatus()
    {
        return battleshipError;
    }
    */
}


// possible bug:
// ships intersecting, --
// ships being put outside of map -- New issue --fixed?
// fix input var in vert and horiz // no need? 