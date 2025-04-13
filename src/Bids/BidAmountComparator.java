package Bids;

import java.util.Comparator;

public class BidAmountComparator implements Comparator<Bid> {

    //Sortering efter bud

    @Override
    public int compare(Bid bid1, Bid bid2) {
        return Integer.compare(bid1.getAmount(), bid2.getAmount());
    }
}
