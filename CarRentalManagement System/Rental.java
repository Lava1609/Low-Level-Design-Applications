package CarRentalManagement;

public class Rental {
    private String rentalId;
    private String carId;
    private String customerId;
    private String rentalStartDate;
    private String rentalEndDate;
    private String returnDate;
    private int totalAmount;

    public Rental(String rentalId, String carId, String customerId, String rentalStartDate, String rentalEndDate) {
        this.rentalId = rentalId;
        this.carId = carId;
        this.customerId = customerId;
        this.rentalStartDate = rentalStartDate;
        this.rentalEndDate = rentalEndDate;
        this.returnDate = null;
        this.totalAmount = 0;
    }

    public String getRentalId() {
        return rentalId;
    }

    public String getCarId() {
        return carId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getRentalStartDate() {
        return rentalStartDate;
    }

    public String getRentalEndDate() {
        return rentalEndDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void calculateTotalAmount(int dailyRentalPrice) {
        int days = DateUtility.calculateDaysBetween(rentalStartDate, returnDate != null ? returnDate : rentalEndDate);
        this.totalAmount = days * dailyRentalPrice;
    }
}
