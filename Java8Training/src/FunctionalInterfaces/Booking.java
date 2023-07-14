package FunctionalInterfaces;

public class Booking

{
    UberAccount rider;

    UberAccount driver;

    public Booking(UberAccount rider, UberAccount driver, double fare) {
        this.rider = rider;
        this.driver = driver;
        this.fare = fare;
    }

    double fare;
}
