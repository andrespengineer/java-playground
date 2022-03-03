package oop.transport.models.vehicles;

public interface VehicleBuilder<T extends VehicleModel> {
    VehicleBuilder<T> setModel(String model);
    VehicleBuilder<T> setBrand(String brand);
    VehicleBuilder<T> setYear(String year);
    VehicleBuilder<T> setIsHybrid(boolean isHybrid);
    T build();
}
