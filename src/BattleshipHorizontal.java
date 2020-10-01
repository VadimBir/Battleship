public class BattleshipHorizontal implements Command{
    private Battleship battleship;
    private Board board;
    //private int inputX;
    //private int inputY;
    public BattleshipHorizontal(Battleship battleship, Board board/*, inputX, inputY*/) 
    {
        this.battleship = battleship;
        //this.Battleship.board=board;
        this.board = board;
        //this.inputX=inputX;
        //this.inputY=inputY;
    } 
    public Board execute() {
        battleship.Horizontal(board/*, inputX, inputY*/);
        return board;
    }

}
