package oop.cargo.type;

import oop.cargo.interfaces.Cargo;
import oop.cargo.interfaces.DryCargo;
import oop.location.TargetLocation;

public class RiceCargo implements DryCargo {
    @Override
    public TargetLocation targetLocation() {
        return null;
    }

    @Override
    public long code() {
        return 0;
    }
}
