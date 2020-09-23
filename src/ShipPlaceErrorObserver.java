abstract public class ShipPlaceErrorObserver extends Carrier {
    private boolean carrierError= false;
    
    boolean CarrierCheck()
    {
        ShipPlaceErrorObserver shipPlaceErrorObserver;
        carrierError=shipPlaceErrorObserver.getErrorStatus();

        return carrierError;
    }
}
