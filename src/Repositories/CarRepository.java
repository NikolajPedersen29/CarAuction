package Repositories;

import Cars.Car;

import java.util.List;

public interface CarRepository {

     List<Car> allCars();
     Car findByNumberPlate(String numberplate);
     Car save(Car car);


}
