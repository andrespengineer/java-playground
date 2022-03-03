package oop.cargo.type;

import oop.cargo.interfaces.Cargo;
import oop.cargo.interfaces.LiquidCargo;
import oop.location.TargetLocation;

public class FuelCargo implements LiquidCargo {
    @Override
    public TargetLocation targetLocation() {
        return null;
    }

    @Override
    public long code() {
        return 0;
    }

    @Override
    public void fill() {

    }

    @Override
    public void drain() {

    }
}
