package FunctionalInterfaces;

public class DestinationLocation {
    private float gpsPosition;

    public DestinationLocation(float gpsPosition) {
        this.gpsPosition = gpsPosition;
    }

    public float getGpsPosition() {
        return gpsPosition;
    }

    public void setGpsPosition(float gpsPosition) {
        this.gpsPosition = gpsPosition;
    }
}
