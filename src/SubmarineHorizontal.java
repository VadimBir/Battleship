import java.io.Serializable;

public class SubmarineHorizontal implements Command, Serializable{
    private Submarine submarine;
    private Board board;

    public SubmarineHorizontal(Submarine submarine, Board board) 
    {
        this.submarine = submarine;
        this.board = board;
    } 
    public Board execute() 
    {
        submarine.Horizontal(board);
        return board;
    }

}
