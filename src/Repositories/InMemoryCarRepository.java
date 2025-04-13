package Repositories;

import Cars.Car;

import java.util.ArrayList;
import java.util.List;

public class InMemoryCarRepository implements CarRepository {

    private List<Car> cars = new ArrayList<>();

    @Override
    public List<Car> allCars() {
        return new ArrayList<>(cars);
    }

    @Override
    public Car findByNumberPlate(String numberPlate) {
        for (Car car : cars) {
            if (car.getNumberPlate().equals(numberPlate)) {
                return car;
            }
        }
        return null;
    }

    @Override
    public Car save (Car car) {
        if (findByNumberPlate(car.getNumberPlate()) != null) {
            System.out.println("Car already exists");
        }
        cars.add(car);
        return car;
    }
}
