package oop.transport.type;

import oop.transport.interfaces.RoadTransport;
import oop.transport.models.vehicles.VehicleModel;

import java.util.Random;

public class TruckTransport implements RoadTransport {

    @Override
    public void move() {
        System.out.println("Driving from x to " + new Random().nextInt());
    }

    @Override
    public long departureTime() {
        return System.currentTimeMillis() % 1_000_000_000;
    }

    @Override
    public long arriveTime() {
        return System.currentTimeMillis();
    }

    @Override
    public long code() {
        return 0;
    }
}
