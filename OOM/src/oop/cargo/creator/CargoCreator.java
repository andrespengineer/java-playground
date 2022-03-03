package oop.cargo.creator;

import oop.cargo.enums.CargoTypes;
import oop.cargo.interfaces.Cargo;

public abstract class CargoCreator<T extends Cargo> {

    public abstract T create(CargoTypes type);
}
