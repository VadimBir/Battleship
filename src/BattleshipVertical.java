public class BattleshipVertical implements Command {
    private Battleship battleship;
    private Board board;
    //private int inputX;
    //private int inputY;
    public BattleshipVertical(Battleship battleship, Board board/*, inputX, inputY*/) 
    {
        this.battleship = battleship;
        //this.Battleship.board=board;
        this.board = board;
        //this.inputX=inputX;
        //1this.inputY=inputY;
    } 
    public Board execute() {
        battleship.Vertical(board/*, inputX, inputY*/);
        return board;
    }

}
