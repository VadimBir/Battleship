import java.io.Serializable;

public class DestroyerVertical implements Command, Serializable{
    private Destroyer destroyer;
    private Board board;

    public DestroyerVertical(Destroyer destroyer, Board board) 
    {
        this.destroyer = destroyer;
        this.board = board;
    } 
    public Board execute() 
    {
        destroyer.Vertical(board);
        return board;
    }

}
