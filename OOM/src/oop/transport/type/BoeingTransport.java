package oop.transport.type;

import oop.transport.interfaces.AirTransport;

import java.util.Random;

public class BoeingTransport implements AirTransport {

    @Override
    public void fly() {
        System.out.println("Flying from airport " + new Random().nextInt());
    }

    @Override
    public long departureTime() {
        return 0;
    }

    @Override
    public long arriveTime() {
        return System.currentTimeMillis();
    }

    @Override
    public long transportTime() {
        return 0;
    }


    @Override
    public long code() {
        return 0;
    }
}
