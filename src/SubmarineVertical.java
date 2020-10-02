public class SubmarineVertical implements Command{
    private Submarine submarine;
    private Board board;

    public SubmarineVertical(Submarine submarine, Board board) 
    {
        this.submarine = submarine;
        this.board = board;
    } 
    public Board execute() 
    {
        submarine.Vertical(board);
        return board;
    }

}
