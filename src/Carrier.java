public class Carrier extends Board{
    public int inputY= 4;
    public int inputX= 2;
    Board board;
    public Board Horizontal(Board board)
    {
        System.out.println("Place Horizontally ... 5 ");
        this.board = board;
        System.out.println("Place Vertically ... 5 ");    
        for(int i=0; i<5; i++){
            board.boardArrPlayer[inputY-1][inputX-1]="C";
            inputY++;
            //board.setBoard();
        }
        return board;
    }
    public Board Vertical(Board board) 
    {
    	this.board = board;
        System.out.println("Place Vertically ... 5 ");    
        for(int i=0; i<5; i++){
            board.boardArrPlayer[inputY-1][inputX-1]="C";
            inputX++;
            //board.setBoard();
        }
        return board;
    }
}
