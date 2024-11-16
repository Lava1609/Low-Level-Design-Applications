package CarRentalManagement;

public class Car {
    private String carId;
    private String model;
    private String brand;
    private int dailyRentalPrice;
    private boolean available;

    public Car(String carId, String model, String brand, int dailyRentalPrice) {
        this.carId = carId;
        this.model = model;
        this.brand = brand;
        this.dailyRentalPrice = dailyRentalPrice;
        this.available = true;
    }

    public String getCarId() {
        return carId;
    }

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    public int getDailyRentalPrice() {
        return dailyRentalPrice;
    }

    public boolean isAvailable() {
        return available;
    }

    public void rentCar() {
        available = false;
    }

    public void returnCar() {
        available = true;
    }
}
