public class CarrierHorizontal implements Command{
    private Carrier carrier;

    public CarrierHorizontal(Carrier carrier) 
    {
        this.carrier = carrier;
    }
    public void execute() {
        carrier.Horizontal();
    }

}
