package Service;

import Cars.Car;
import Exceptions.InvalidBidException;
import Exceptions.NoCarsException;
import Repositories.CarRepository;

import java.util.Comparator;
import java.util.List;

public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car createCar (String brand, String model, int year, int basePrice, String numberPlate) {
        Car car = new Car(brand, model, year, basePrice, numberPlate);
        return carRepository.save(car);
    }

    public List<Car> getAllCars() throws NoCarsException {
        List<Car> cars = carRepository.allCars();
        if (cars.isEmpty()) {
            throw new NoCarsException("No cars available");
        }
        return cars;
    }

    public List<Car> getCarsSorted (Comparator<Car> comparator) throws NoCarsException {
        List<Car> cars = getAllCars();
        cars.sort(comparator);
        return cars;
    }

    public Car findCarByNumberPlate(String numberPlate) throws InvalidBidException {
        Car car = carRepository.findByNumberPlate(numberPlate);
        if (car == null) {
            throw new InvalidBidException("Number plate not found");
        }
        return car;
    }
}
