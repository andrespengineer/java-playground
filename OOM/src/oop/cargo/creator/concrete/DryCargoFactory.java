package oop.cargo.creator.concrete;

import oop.cargo.CargoFactory;
import oop.cargo.creator.CargoCreator;
import oop.cargo.enums.CargoTypes;
import oop.cargo.interfaces.DryCargo;
import oop.cargo.type.RiceCargo;

public class DryCargoFactory extends CargoCreator<DryCargo> {

    public static DryCargoFactory getInstance() {
        if(instance == null)
            instance = new DryCargoFactory();
        return instance;
    }

    private static DryCargoFactory instance;

    @Override
    public DryCargo create(CargoTypes type) {
        return new RiceCargo();
    }
}
