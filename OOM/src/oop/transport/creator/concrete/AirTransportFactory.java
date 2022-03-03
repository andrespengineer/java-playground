package oop.transport.creator.concrete;

import oop.transport.type.BoeingTransport;
import oop.transport.creator.TransportCreator;
import oop.transport.enums.TransportType;
import oop.transport.interfaces.AirTransport;

public class AirTransportFactory extends TransportCreator<AirTransport> {

    public static AirTransportFactory getInstance(){
        if(instance == null)
            instance = new AirTransportFactory();

        return instance;
    }

    public static AirTransportFactory instance = null;

    @Override
    public AirTransport create(TransportType transportType) {
        switch (transportType){
            case BOEING:
                return new BoeingTransport();
            default:
                return null;
        }
    }
}
