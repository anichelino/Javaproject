package FunctionalInterfaces;

public class UberAccount {
    private String name;

    private String mobileNumber;

    private String userId;

   private  String emailId;

   private String accountType;//rider or driver

   private  String vehicleNo;
   private  String vehicleType;
   private  boolean vehicleAvailability;
   private  String pickupLocation;
   private  String destinationLocation;
   private  String paymentMode;
   private  String bookingStatus;

    public UberAccount(String name, String mobileNumber, String userId, String emailId, String accountType, String vehicleNo, String vehicleType, boolean vehicleAvailability, String pickupLocation, String destinationLocation, String paymentMode, String bookingStatus) {
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.userId = userId;
        this.emailId = emailId;
        this.accountType = accountType;
        this.vehicleNo = vehicleNo;
        this.vehicleType = vehicleType;
        this.vehicleAvailability = vehicleAvailability;
        this.pickupLocation = pickupLocation;
        this.destinationLocation = destinationLocation;
        this.paymentMode = paymentMode;
        this.bookingStatus = bookingStatus;
    }

    public String getDestinationLocation() {
        return destinationLocation;
    }

    public void setDestinationLocation(String destinationLocation) {
        this.destinationLocation = destinationLocation;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public boolean isVehicleAvailability() {
        return vehicleAvailability;
    }

    public void setVehicleAvailability(boolean vehicleAvailability) {
        this.vehicleAvailability = vehicleAvailability;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }
}
