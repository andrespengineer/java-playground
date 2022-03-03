package oop.logistic;

import oop.cargo.interfaces.Cargo;
import oop.logistic.supplies.Supplies;
import oop.transport.interfaces.Transport;
import java.util.*;

public class Logistic {

    private final Supplies supplies;

    public Logistic(Supplies supplies){
        this.supplies = supplies;
    }

    // Operation
    public void executeLogistic() {

        PriorityQueue<Transport> priorityTransports = new PriorityQueue<>(Comparator.comparingLong(Transport::transportTime));
        Transport transport = null;

        for(int i = 0; i < 10; i++) {
            transport = supplies.createTransport();
            Cargo cargo = supplies.createCargo();
            priorityTransports.offer(transport);
        }

        transport = null;
        while (!priorityTransports.isEmpty()) {
            transport = priorityTransports.poll();
            System.out.println(transport.name() + " " + transport.transportTime());
        }
    }
}
