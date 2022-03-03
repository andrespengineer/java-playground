package oop.cargo.creator.concrete;

import oop.cargo.creator.CargoCreator;
import oop.cargo.enums.CargoTypes;
import oop.cargo.interfaces.Cargo;
import oop.cargo.interfaces.LiquidCargo;
import oop.cargo.type.FuelCargo;

public class LiquidCargoFactory extends CargoCreator<LiquidCargo> {
    public static LiquidCargoFactory getInstance() {
        if(instance == null)
            instance = new LiquidCargoFactory();
        return instance;
    }

    private static LiquidCargoFactory instance;

    @Override
    public LiquidCargo create(CargoTypes type) {
        return new FuelCargo();
    }
}
