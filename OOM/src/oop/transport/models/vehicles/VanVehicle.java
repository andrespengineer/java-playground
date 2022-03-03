package oop.transport.models.vehicles;

public class VanVehicle extends VehicleModel {
    private boolean hasSideDoors;

    public boolean isHasSideDoors() {
        return hasSideDoors;
    }

    public void setHasSideDoors(boolean hasSideDoors) {
        this.hasSideDoors = hasSideDoors;
    }

    public static class Builder extends VehicleBuilderImpl<VanVehicle> {

        public Builder(){
            this.vehicleModel = new VanVehicle();
        }

        @Override
        public VehicleBuilder<VanVehicle> setModel(String model) {
            vehicleModel.setModel(model);
            return this;
        }

        @Override
        public VehicleBuilder<VanVehicle> setBrand(String brand) {
            vehicleModel.setBrand(brand);
            return this;
        }

        @Override
        public VehicleBuilder<VanVehicle> setYear(String year) {
            vehicleModel.setYear(year);
            return this;
        }

        @Override
        public VehicleBuilder<VanVehicle> setIsHybrid(boolean isHybrid) {
            vehicleModel.setIsHybrid(isHybrid);
            return this;
        }

        @Override
        public VanVehicle build() {
            return vehicleModel;
        }
    }
}
