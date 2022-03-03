package oop.cargo;

import oop.cargo.creator.CargoCreator;
import oop.cargo.creator.concrete.ContainerCargoFactory;
import oop.cargo.creator.concrete.DryCargoFactory;
import oop.cargo.creator.concrete.LiquidCargoFactory;
import oop.cargo.enums.CargoTypes;
import oop.cargo.interfaces.Cargo;
import oop.cargo.interfaces.ContainerCargo;

public class CargoFactory {

    public Cargo getCargo(CargoTypes type) {
        switch (type){
            case DRY:
                return DryCargoFactory.getInstance().create(type);
            case LIQUID:
                return LiquidCargoFactory.getInstance().create(type);
            case CONTAINER:
                return ContainerCargoFactory.getInstance().create(type);
        }
        return null;
    }
}
