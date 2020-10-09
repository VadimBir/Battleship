import java.io.Serializable;

public class BattleshipHorizontal implements Command, Serializable{
    private Battleship battleship;
    private Board board;

    public BattleshipHorizontal(Battleship battleship, Board board) 
    {
        this.battleship = battleship;
        this.board = board;
    } 
    public Board execute() 
    {
        battleship.Horizontal(board);
        return board;
    }

}
