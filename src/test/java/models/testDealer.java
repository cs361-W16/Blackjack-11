package models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by danielgoh on 3/4/16.
 */
public class testDealer {

    @Test
    public void testDealerInit() {
        BlackJack g = new BlackJack();
        assertNotNull(g.dealer);
    }

    @Test
    public void testDealerHand() {
        BlackJack g = new BlackJack();
        assertNotNull(g.dealer.hand);
    }

    @Test
    public void testDealerStartHand() {
        BlackJack g = new BlackJack();
        assertEquals(2,g.dealer.hand.size());
    }
}
