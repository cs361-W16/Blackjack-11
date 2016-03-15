package models;

import org.junit.Test;

import java.util.ArrayList;

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
        assertEquals(1,g.dealer.hand.size());
    }

    @Test
    public void testPlay() {
        BlackJack g = new BlackJack();
        ArrayList<Card> deck = new ArrayList<>();
        ArrayList<Card> dealerHand = new ArrayList<>();
        deck.add(new Card(13, Suit.Clubs));
        deck.add(new Card(11, Suit.Spades));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(5, Suit.Hearts));
        dealerHand.add(new Card(4, Suit.Clubs));
        dealerHand.add(new Card(3, Suit.Diamonds));
        g.dealer.hand = dealerHand;
        g.dealer.play(deck);
        assertEquals(23, g.dealer.getTotal());
    }
}
