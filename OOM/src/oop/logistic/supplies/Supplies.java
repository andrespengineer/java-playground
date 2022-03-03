package oop.logistic.supplies;

import oop.cargo.CargoFactory;
import oop.cargo.interfaces.Cargo;
import oop.transport.TransportFactory;
import oop.transport.interfaces.Transport;

public interface Supplies {
    Transport createTransport();
    Cargo createCargo();
}
