package oop.cargo.interfaces;

import oop.common.Common;
import oop.location.Location;
import oop.location.TargetLocation;

public interface Cargo extends Common {
    TargetLocation targetLocation();
}
