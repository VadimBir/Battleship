import java.util.Scanner;

public class Carrier extends Board{ 
    private int inputY;
    private int inputX;
    final int SHIP_LEN= 5;
    public boolean carrierError= false;
    Board board;

    public Board Horizontal(Board board, int inputX2, int inputY2)
    {
        this.inputX= inputX2;
        this.inputY= inputY2;

        do{
            getCoordinates();
        }while(board.boardCol.length<(inputX-1)+SHIP_LEN);
        System.out.println("Place Horizontally ... 5 ");
        this.board = board;
        for(int i=0; i<SHIP_LEN; i++){
            board.boardArrPlayer[inputY-1][inputX-1]="C";
            inputY++;
            //board.setBoard();
        }
        return board;

    }
    public Board Vertical(Board board, int inputX2, int inputY2) 
    {
        this.inputX= inputX2;
        this.inputY= inputY2;
        do{
            getCoordinates();
        }while(board.boardCol.length<(inputX-1)+SHIP_LEN);
        System.out.println("Place Vertically ... 5 ");    
        this.board = board;
        for(int i=0; i<SHIP_LEN; i++){
            board.boardArrPlayer[inputY-1][inputX-1]="C";
            inputX++;
            //board.setBoard();
        }
        return board;

    }
    public void getCoordinates()
    {
        
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter X coordinate: ");
        int newX = myObj.nextInt();
        inputX = newX;
        System.out.println("Enter Y coordinate: ");
        int newY = myObj.nextInt();
        inputY = newY;
        myObj.close();
    }


    public boolean getErrorStatus()
    {
        return carrierError;
    }
}


// possible bug:
// ships intersecting,
// ships being put outside of map --
// fix input var in vert and horiz