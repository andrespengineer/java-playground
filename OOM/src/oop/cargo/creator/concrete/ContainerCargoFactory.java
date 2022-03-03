package oop.cargo.creator.concrete;

import oop.cargo.creator.CargoCreator;
import oop.cargo.enums.CargoTypes;
import oop.cargo.interfaces.ContainerCargo;
import oop.cargo.type.ClothesCargo;

public class ContainerCargoFactory extends CargoCreator<ContainerCargo> {
    public static ContainerCargoFactory getInstance() {
        if(instance == null)
            instance = new ContainerCargoFactory();
        return instance;
    }

    private static ContainerCargoFactory instance;
    @Override
    public ContainerCargo create(CargoTypes type) {
        return new ClothesCargo();
    }
}
