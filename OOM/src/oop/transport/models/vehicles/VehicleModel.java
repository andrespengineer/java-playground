package oop.transport.models.vehicles;

public class VehicleModel {

    private int fuelLevel;
    private boolean isHybrid;
    private String brand;
    private String model;
    private String year;

    public int getFuelLevel() {
        return fuelLevel;
    }

    public void setFuelLevel(int fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    public boolean isHybrid() {
        return isHybrid;
    }

    public void setIsHybrid(boolean hybrid) {
        isHybrid = hybrid;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public static class Builder {

        private final VehicleModel vehicleModel;

        public Builder() {
            vehicleModel = new VehicleModel();
        }

        public Builder setModel(String model){
            vehicleModel.setModel(model);
            return this;
        }

        public Builder setYear(String year){
            vehicleModel.setYear(year);
            return this;
        }

        public Builder setIsHybrid(boolean isHybrid){
            vehicleModel.setIsHybrid(isHybrid);
            return this;
        }

        public Builder setBrand(String brand){
            vehicleModel.setBrand(brand);
            return this;
        }

        public VehicleModel build(){
            return this.vehicleModel;
        }
    }
}
