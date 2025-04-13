package Cars;

public class Car implements Comparable<Car> {

    private String brand;
    private String model;
    private int year;
    private int basePrice;
    private String numberPlate;

    public Car (String brand, String model, int year, int basePrice, String numberPlate) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.basePrice = basePrice;
        this.numberPlate = numberPlate;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setBrand (String brand) {
        this.brand = brand;
    }

    public void setModel (String model) {
        this.model = model;
    }

    public void setYear (int year) {
        this.year = year;
    }

    public void setBasePrice (int basePrice) {
        this.basePrice = basePrice;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    @Override
    public String toString() {
    return brand + " " + model + ", fra årgang: " + year + ", med en startpris på: " + basePrice + ", med nummerpladen: " + numberPlate;
    }

    @Override
    public int compareTo(Car other) {
        return Integer.compare(this.year, other.getYear());
    }

}
