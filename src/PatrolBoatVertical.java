public class PatrolBoatVertical implements Command{
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
