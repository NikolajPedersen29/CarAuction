package Cars;

import java.util.Comparator;

public class CarBrandComparator implements Comparator<Car> {

    // Sortering efter hvilke bilmære det er (Alfabetisk)

    @Override
    public int compare(Car car1, Car car2) {
        return car1.getBrand().compareTo(car2.getBrand());
    }


}
