package oop.transport.interfaces;

import oop.common.Common;

public interface Transport extends Common {
    long departureTime();
    long arriveTime();
    default long transportTime() {
        return arriveTime() - departureTime();
    }
}
