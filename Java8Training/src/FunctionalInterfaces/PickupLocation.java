package FunctionalInterfaces;

public class PickupLocation {
    private float gpsPosition;

    public PickupLocation(float gpsPosition) {
        this.gpsPosition = gpsPosition;
    }

    public float getGpsPosition() {
        return gpsPosition;
    }

    public void setGpsPosition(float gpsPosition) {
        this.gpsPosition = gpsPosition;
    }
}
