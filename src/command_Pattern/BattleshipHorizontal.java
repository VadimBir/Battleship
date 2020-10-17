package command_Pattern;
import java.io.Serializable;

import factory_Pattern.*;

public class BattleshipHorizontal implements Command{
    private Battleship battleship;
    public Board board;

    public BattleshipHorizontal(Battleship battleship, Board board) 
    {
        this.battleship = battleship;
        this.board = board;
    } 
    public Board execute() 
    {
        battleship.Horizontal(board);
        return board;
    }

}
