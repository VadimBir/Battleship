package command_Pattern;
import java.io.Serializable;

import factory_Pattern.*;

public class DestroyerHorizontal implements Command{
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
