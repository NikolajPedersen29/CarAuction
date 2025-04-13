package Service;

import Bids.Bid;
import Cars.Car;
import Exceptions.InvalidBidException;
import Exceptions.NoCarsException;
import Repositories.BidRepository;
import Repositories.CarRepository;

import java.util.List;

public class BidService {
    private BidRepository bidRepository;
    private CarRepository carRepository;

    public BidService (BidRepository bidRepository, CarRepository carRepository) {
        this.bidRepository = bidRepository;
        this.carRepository = carRepository;
    }

    public Bid placeBid(String bidderName, int amount, String numberPlate) throws InvalidBidException, NoCarsException {
        if (amount <= 0) {
            throw new InvalidBidException("Amount must be positive");
        }
        if (amount <= carRepository.findByNumberPlate(numberPlate).getBasePrice()) {
            throw new InvalidBidException("Bid must be above base price");
        }
        Car car = carRepository.findByNumberPlate(numberPlate);
        Bid bid = new Bid(bidderName, amount, car);
        return bidRepository.saveBid(bid);
    }

    public Bid gethighestBid (String numberPlate) throws InvalidBidException {
        List<Bid> bids = bidRepository.findByNumberPlate(numberPlate);
        if (bids.isEmpty()) {
            return null;
        }

        Bid highest = bids.getFirst();
        for (Bid bid : bids) {
            if (bid.getAmount() > highest.getAmount()) {
                highest = bid;
            }
        }
        return highest;
    }
}
