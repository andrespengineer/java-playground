package oop.transport.type;

import oop.transport.interfaces.MarineTransport;

import java.util.Random;

public class CarrierTransport implements MarineTransport {
    @Override
    public void sail() {
        System.out.println("Sailing from port " + new Random().nextInt());
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
    public long code() {
        return 0;
    }
}
