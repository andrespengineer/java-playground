package oop.logistic.creator;

import oop.cargo.CargoFactory;
import oop.cargo.enums.CargoTypes;
import oop.cargo.interfaces.Cargo;
import oop.cargo.type.RiceCargo;
import oop.logistic.supplies.Supplies;
import oop.transport.TransportFactory;
import oop.transport.enums.TransportType;
import oop.transport.interfaces.Transport;

public class FoodFactory implements Supplies {

    private final TransportFactory transportFactory;
    private final CargoFactory cargoFactory;

    public FoodFactory(TransportFactory transportFactory, CargoFactory cargoFactory){
        this.transportFactory = transportFactory;
        this.cargoFactory = cargoFactory;
    }

    @Override
    public Transport createTransport() {
        return transportFactory.getTransport(TransportType.SHIP);
    }

    @Override
    public Cargo createCargo() {
        return cargoFactory.getCargo(CargoTypes.DRY);
    }
}
