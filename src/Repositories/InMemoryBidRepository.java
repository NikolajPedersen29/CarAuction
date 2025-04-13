package Repositories;

import Bids.Bid;

import java.util.ArrayList;
import java.util.List;

public class InMemoryBidRepository implements BidRepository {
    private final List<Bid> bids = new ArrayList<>();

    @Override
    public List<Bid> allBids() {
        return new ArrayList<>(bids);
    }

    @Override
    public List<Bid> findByNumberPlate (String numberPlate) {
        List<Bid> result = new ArrayList<>();
        for (Bid bid : bids) {
            if (bid.getCar().getNumberPlate().equals(numberPlate)) {
                result.add(bid);
            }
        }
        return result;
    }

    @Override
    public Bid saveBid(Bid bid) {
        bids.add(bid);
        return bid;
    }
}
