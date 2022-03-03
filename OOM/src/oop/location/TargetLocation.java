package oop.location;

public class TargetLocation {

    private Location currentLocation;
    private Location destination;

    public TargetLocation(Location currentLocation, Location destination) {
        this.currentLocation = currentLocation;
        this.destination = destination;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public Location getDestination() {
        return destination;
    }
}
