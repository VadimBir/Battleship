public class BattleshipVertical implements Command {
    private Battleship battleship;
    private Board board;

    public BattleshipVertical(Battleship battleship, Board board) 
    {
        this.battleship = battleship;
        this.board = board;
    } 
    public Board execute() 
    {
        battleship.Vertical(board);
        return board;
    }

}
