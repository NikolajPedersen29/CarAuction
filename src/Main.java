import Repositories.BidRepository;
import Repositories.CarRepository;
import Repositories.InMemoryBidRepository;
import Repositories.InMemoryCarRepository;
import Service.BidService;
import Service.CarService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        CarRepository carRepository = new InMemoryCarRepository();
        BidRepository bidRepository = new InMemoryBidRepository();

        CarService carService = new CarService(carRepository);
        BidService bidService = new BidService(bidRepository, carRepository);

        Scanner scanner = new Scanner(System.in);

        AuctionController controller = new AuctionController(carService, bidService, scanner);
        controller.start();
    }
}
