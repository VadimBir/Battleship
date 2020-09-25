public class CarrierHorizontal implements Command{
    private Carrier carrier;
    private Board board;
    //private int inputX;
    //private int inputY;
    public CarrierHorizontal(Carrier carrier, Board board/*, inputX, inputY*/) 
    {
        this.carrier = carrier;
        //this.carrier.board=board;
        this.board = board;
        //this.inputX=inputX;
        //this.inputY=inputY;
    } 
    public Board execute() {
        carrier.Horizontal(board/*, inputX, inputY*/);
        return board;
    }

}
