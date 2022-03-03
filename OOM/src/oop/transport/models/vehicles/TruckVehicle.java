package oop.transport.models.vehicles;

public class TruckVehicle extends VehicleModel {
    private int tailSize;

    public int getTailSize() {
        return tailSize;
    }

    public void setTailSize(int tailSize) {
        this.tailSize = tailSize;
    }

    public static class Builder extends VehicleBuilderImpl<TruckVehicle> {

        public Builder(){
            this.vehicleModel = new TruckVehicle();
        }

        @Override
        public VehicleBuilder<TruckVehicle> setModel(String model) {
            vehicleModel.setModel(model);
            return this;
        }

        @Override
        public VehicleBuilder<TruckVehicle> setBrand(String brand) {
            vehicleModel.setBrand(brand);
            return this;
        }

        @Override
        public VehicleBuilder<TruckVehicle> setYear(String year) {
            vehicleModel.setYear(year);
            return this;
        }

        @Override
        public VehicleBuilder<TruckVehicle> setIsHybrid(boolean isHybrid) {
            vehicleModel.setIsHybrid(isHybrid);
            return this;
        }

        @Override
        public TruckVehicle build() {
            return vehicleModel;
        }
    }
}
