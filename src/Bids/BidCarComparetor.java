package Bids;

import java.util.Comparator;

public class BidCarComparetor implements Comparator<Bid> {

    // Sortering efter bil mærke, og derefter hvilken model det er

    @Override
    public int compare(Bid bid1, Bid bid2) {
        int result = bid1.getCar().getBrand().compareTo(bid2.getCar().getBrand());
        if (result == 0) {
            result = bid1.getCar().getModel().compareTo(bid2.getCar().getModel());
        }
        return result;
    }

}
