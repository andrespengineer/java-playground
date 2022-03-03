package oop.transport.models.vehicles;

public abstract class VehicleBuilderImpl<T extends VehicleModel> implements VehicleBuilder<T> {
    protected T vehicleModel;
}
