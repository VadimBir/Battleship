package command_Pattern;
import java.io.Serializable;

import factory_Pattern.*;


public class CarrierHorizontal implements Command{
    private Carrier carrier;
    private Board board;

    public CarrierHorizontal(Carrier carrier, Board board) 
    {
        this.carrier = carrier;
        this.board = board;
    } 
    public Board execute() 
    {
        carrier.Horizontal(board);
        return board;
    }

}
