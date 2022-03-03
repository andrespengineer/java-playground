package oop.transport;

import oop.transport.creator.TransportCreator;
import oop.transport.creator.concrete.AirTransportFactory;
import oop.transport.creator.concrete.MarineTransportFactory;
import oop.transport.creator.concrete.RoadTransportFactory;
import oop.transport.enums.TransportType;
import oop.transport.interfaces.MarineTransport;
import oop.transport.interfaces.Transport;

import java.util.Random;

public class TransportFactory {

    public Transport getTransport(TransportType type){
        switch (type){
            case SHIP:
            case CARRIER:
                return MarineTransportFactory.getInstance().create(type);
            case TRUCK:
                return RoadTransportFactory.getInstance().create(type);
            case BOEING:
                return AirTransportFactory.getInstance().create(type);
            default:
                return null;
        }

    }

    public Transport getRandomTransport() {
        return getTransport(TransportType.values()[new Random().nextInt(TransportType.values().length)]);
    }
}
