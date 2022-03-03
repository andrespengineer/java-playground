package oop.transport.creator.concrete;

import oop.transport.interfaces.Transport;
import oop.transport.type.TruckTransport;
import oop.transport.creator.TransportCreator;
import oop.transport.enums.TransportType;
import oop.transport.interfaces.RoadTransport;

public class RoadTransportFactory extends TransportCreator<RoadTransport> {

    public static RoadTransportFactory getInstance() {
        if(instance == null)
            instance = new RoadTransportFactory();

        return instance;
    }

    private static RoadTransportFactory instance = null;

    @Override
    public RoadTransport create(TransportType transportType) {
        switch (transportType){
            case TRUCK:
                return new TruckTransport();
            default:
                return null;
        }
    }
}
