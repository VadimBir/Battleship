import java.io.Serializable;

public class DestroyerHorizontal implements Command, Serializable{
    private Destroyer destroyer;
    private Board board;

    public DestroyerHorizontal(Destroyer destroyer, Board board) 
    {
        this.destroyer = destroyer;
        this.board = board;
    } 
    public Board execute() 
    {
        destroyer.Horizontal(board);
        return board;
    }

}
