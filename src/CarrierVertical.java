public class CarrierVertical implements Command {
    private Carrier carrier;
    private Board board;
    //private int inputX;
    //private int inputY;
    public CarrierVertical(Carrier carrier, Board board/*, inputX, inputY*/) 
    {
        this.carrier = carrier;
        this.board = board;
        //this.inputX=inputX;
        //1this.inputY=inputY;
    } 
    public Board execute() {
        carrier.Vertical(board/*, inputX, inputY*/);
        return board;
    }

}
