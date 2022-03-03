package oop.cargo.type;

import oop.cargo.interfaces.ContainerCargo;
import oop.location.TargetLocation;

public class ClothesCargo implements ContainerCargo {
    @Override
    public TargetLocation targetLocation() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public long code() {
        return 0;
    }
}
