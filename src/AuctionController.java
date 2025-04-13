import Bids.Bid;
import Cars.Car;
import Cars.CarBrandComparator;
import Cars.CarPriceComparator;
import Exceptions.InvalidBidException;
import Exceptions.NoCarsException;
import Service.BidService;
import Service.CarService;

import java.util.List;
import java.util.Scanner;

public class AuctionController {
    private final CarService carService;
    private final BidService bidService;
    private final Scanner scanner;

    public AuctionController (CarService carService, BidService bidService, Scanner scanner){
        this.carService = carService;
        this.bidService = bidService;
        this.scanner = scanner;
    }

    public void start() {
        boolean running = true;
        initializeSampleData();

        while (running) {
            System.out.println("\n=== Car auction system ===");
            System.out.println("1. Show all cars");
            System.out.println("2. Sort cars");
            System.out.println("3. Show highest bid per car");
            System.out.println("4. Place bid");
            System.out.println("5. Create auction");
            System.out.println("6. finish");

            int choice = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (choice) {
                    case 1 -> displayAllCars();
                    case 2 -> sortCarsMenu();
                    case 3 -> displayHighestBids();
                    case 4 -> placeBidMenu();
                    case 5 -> createCarAuction();
                    case 6 -> running = false;
                    default -> System.out.println("Invalid choice!");
                }
            } catch (NoCarsException | InvalidBidException e) {
                System.out.println("Fejl: " + e.getMessage());
            }
        }
    }

    private void initializeSampleData() {
        carService.createCar("Toyota", "Corolla", 2020, 150000, "AB12345");
        carService.createCar("Volvo", "XC60", 2022, 350000, "CD67890");
        carService.createCar("BMW", "320i", 2021, 280000, "EF24680");

        bidService.placeBid("Anna", 160000, "AB12345");
        bidService.placeBid("Peter", 170000, "AB12345");
        bidService.placeBid("Mette", 360000, "CD67890");
        bidService.placeBid("Ole", 300000, "EF24680");
        bidService.placeBid("Jakob", 320000, "EF24690");
    }

    private void displayAllCars() throws NoCarsException {
        System.out.println("All cars available (Sorted by year): ");
        carService.getCarsSorted(Car::compareTo).forEach(System.out::println);
    }

    private void sortCarsMenu() throws NoCarsException {
        System.out.println("\nSort cars through:");
        System.out.println("1. Brand");
        System.out.println("2. Price");
        System.out.println();

        int choice = scanner.nextInt();
        scanner.nextLine();

        List<Car> sortedCars;
        if (choice == 1) {
            sortedCars = carService.getCarsSorted(new CarBrandComparator());
        } else if (choice == 2) {
            sortedCars = carService.getCarsSorted(new CarPriceComparator());
        } else {
            System.out.println("Invalid choice");
            return;
        }

        for (Car car : sortedCars) {
            System.out.println(car);
        }
    }

    private void displayHighestBids() throws NoCarsException {
        System.out.println("Highest bid per car:");
        for (Car car : carService.getAllCars()) {
            if (bidService.gethighestBid(car.getNumberPlate()) == null) {
                System.out.println("No bids for the car yet!");
            } else {
                Bid highetsBid = bidService.gethighestBid(car.getNumberPlate());
                System.out.println(highetsBid);
            }
        }
    }

    private void placeBidMenu() throws NoCarsException {
        System.out.println("Available cars:");
        displayAllCars();

        System.out.println("Input number plate: ");
        String numberPlate = scanner.nextLine();

        System.out.println("Your full name: ");
        String name = scanner.nextLine();

        System.out.println("Amount you would like to bid:");
        int amount = scanner.nextInt();
        scanner.nextLine();

        Bid bid = bidService.placeBid(name, amount, numberPlate);
        System.out.println("bid registered: " + bid);
    }

    private void createCarAuction() throws NoCarsException {
        System.out.println("What brand of car would you like to sell: ");
        String brand = scanner.nextLine();

        System.out.println("What Model: ");
        String model = scanner.nextLine();

        System.out.println("which year:");
        int year = scanner.nextInt();
        scanner.nextLine();

        System.out.println("At what price would you like the auction to start at:");
        int basePrice = scanner.nextInt();
        scanner.nextLine();

        System.out.println("What is the number plate on the car:");
        String numberPlate = scanner.nextLine();

        Car car = carService.createCar(brand, model, year, basePrice, numberPlate);
    }
}
