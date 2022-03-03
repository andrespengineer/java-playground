package oop;

import kotlin.Pair;
import oop.cargo.CargoFactory;
import oop.logistic.Logistic;
import oop.logistic.creator.FoodFactory;
import oop.logistic.creator.RacingFuelFactory;
import oop.logistic.creator.ClothesFactory;
import oop.transport.TransportFactory;

import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        final TransportFactory transportFactory = new TransportFactory();
        final CargoFactory cargoFactory = new CargoFactory();

        Logistic logistic = null;
        final FoodFactory foodFactory = new FoodFactory(transportFactory, cargoFactory);
        logistic = new Logistic(foodFactory);
        final RacingFuelFactory racingFuelFactory = new RacingFuelFactory(transportFactory, cargoFactory);
        logistic = new Logistic(racingFuelFactory);
        final ClothesFactory clothesFactory = new ClothesFactory(transportFactory, cargoFactory);
        logistic = new Logistic(clothesFactory);
        if(logistic == null)
            return;

        logistic.executeLogistic();
    }

    static class KeyValueMutable<T, U> {
        T key;
        U value;

        public KeyValueMutable(T key, U value){
            this.key = key;
            this.value = value;
        }

        public T getKey() {
            return key;
        }

        public void setKey(T key) {
            this.key = key;
        }

        public U getValue() {
            return value;
        }

        public void setValue(U value) {
            this.value = value;
        }
    }
}
