package oop.transport.creator.concrete;

import oop.transport.type.CarrierTransport;
import oop.transport.type.ShipTransport;
import oop.transport.creator.TransportCreator;
import oop.transport.enums.TransportType;
import oop.transport.interfaces.MarineTransport;

public class MarineTransportFactory extends TransportCreator<MarineTransport> {
    public static MarineTransportFactory getInstance(){
        if(instance == null)
            instance = new MarineTransportFactory();

        return instance;
    }

    public static MarineTransportFactory instance = null;

    @Override
    public MarineTransport create(TransportType transportType) {
        switch (transportType){
            case SHIP:
                return new ShipTransport();
            case CARRIER:
                return new CarrierTransport();
            default:
                return null;
        }
    }
}
