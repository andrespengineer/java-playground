package oop.transport.creator;

import oop.transport.enums.TransportType;
import oop.transport.interfaces.Transport;

public abstract class TransportCreator <T extends Transport> {

    public abstract T create(TransportType transportType);

}
