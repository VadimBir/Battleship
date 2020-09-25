import java.awt.print.Printable;
import java.util.Random;
import java.util.Scanner;

public class Carrier extends Board{ 
    private int inputY;
    private int inputX;
    final int SHIP_LEN= 5;
    final String SHIP_CHAR = "C";
    public boolean carrierError= true;
    Board board;
    private int PlayerPlacement=1;
    String[][][] someBoardArr;

    Carrier(Board board)
    {
        this.board = board;
        someBoardArr = new String[2][board.boardCol.length][board.boardRow.length];
    }

    public Board Horizontal(Board board/*, int inputX2, int inputY2*/)
    {
        boardSplit();
        //this.inputX= inputX2;
        //this.inputY= inputY2;
        while(carrierError==true){
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
            //board.setBoard();
        }
        PlayerPlacement = 0;
        carrierError = true;
        return board;

    }
    public Board Vertical(Board board/*, int inputX2, int inputY2*/) 
    {
        //this.inputX= inputX2;
        //this.inputY= inputY2;
    	boardSplit();
        while(carrierError==true){
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
            //board.setBoard();
        }
        PlayerPlacement = 0;
        carrierError = true;
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
        //myObj.close();
    }

    public void checkHorizontalCollision(String[][] someBoardArr, int X, int Y)
    {
        for(int i =0; i<SHIP_LEN; i++){
            if(someBoardArr[Y-1+i][X-1]!=" "){
                carrierError=true; 
                return;
            }else{
                carrierError=false;
            }
        }
    }
    public void checkVerticalCollision(String[][] someBoardArr, int X, int Y)
    {
        for(int i =0; i<SHIP_LEN; i++){
            if(someBoardArr[Y-1][X-1+i]!=" "){
                carrierError=true; 
                return;
            }else{
                carrierError=false;
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
        return carrierError;
    }
}


// possible bug:
// ships intersecting, --
// ships being put outside of map -- New issue 
// fix input var in vert and horiz 