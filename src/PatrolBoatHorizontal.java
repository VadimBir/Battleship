public class PatrolBoatHorizontal implements Command{
    private PatrolBoat patrolBoat;
    private Board board;

    public PatrolBoatHorizontal(PatrolBoat patrolBoat, Board board) 
    {
        this.patrolBoat = patrolBoat;
        this.board = board;
    } 
    public Board execute() 
    {
        patrolBoat.Horizontal(board);
        return board;
    }

}