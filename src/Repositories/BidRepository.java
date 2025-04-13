package Repositories;

import Bids.Bid;

import java.util.List;

public interface BidRepository {

    List<Bid> allBids();
    List<Bid> findByNumberPlate(String numberplate);
    Bid saveBid(Bid bid);
}
