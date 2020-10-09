import java.io.Serializable;

public class PatrolBoatVertical implements Command, Serializable{
    private PatrolBoat patrolBoat;
    private Board board;

    public PatrolBoatVertical(PatrolBoat patrolBoat, Board board) 
    {
        this.patrolBoat = patrolBoat;
        this.board = board;
    } 
    public Board execute() 
    {
        patrolBoat.Vertical(board);
        return board;
    }

}
