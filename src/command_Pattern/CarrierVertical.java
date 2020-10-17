package command_Pattern;
import java.io.Serializable;

import factory_Pattern.*;

public class CarrierVertical implements Command{
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
