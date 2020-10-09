import java.io.Serializable;

public class CarrierVertical implements Command, Serializable {
    private Carrier carrier;
    private Board board;

    public CarrierVertical(Carrier carrier, Board board) 
    {
        this.carrier = carrier;
        this.board = board;
    } 
    public Board execute() 
    {
        carrier.Vertical(board);
        return board;
    }

}
