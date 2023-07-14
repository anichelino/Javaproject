package FunctionalInterfaces;

public class MainExecutor {
    public static void main(String[] args) {

        double dollarsPerKm = 1.2;

        UberBookingApp uberBookingApp = (userToPass, driverToPass, fare) -> {
            UberAccount rider = null;
            if (!driverToPass.isVehicleAvailability()) {

                throw new IllegalArgumentException("No Vehicles Available For The Trip");
            } else {

                if (driverToPass.getVehicleType() == "rider") {
                    rider = driverToPass;
                } else {
                    rider = null;
                }

                return new Booking(rider, driverToPass, fare);
            }

        };

        UberAccount driver = new UberAccount("JOhn", "+51555534534", "111111", "ffsdsd@gmail.com", "rider", "12345", "bicycle", true,
                "New york", "Chicago", "Paypal", "Booking_Request_sent");
        UberAccount user = new UberAccount("Jack", "+515555345534", "2222", "random@gmail.com", "user", "12345", "bicycle", true,
                "New york", "Chicago", "Paypal", "Booking_Request_sent");
        double fare = 300;
        Booking bookingTransaction = uberBookingApp.bookCabRide(user, driver, fare);

    }
}

