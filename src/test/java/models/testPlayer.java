package models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by danielgoh on 3/8/16.
 */
public class testPlayer {

    @Test
    public void testDealerInit() {
        BlackJack g = new BlackJack();
        assertNotNull(g.player);
    }

    @Test
    public void testDealerHand() {
        BlackJack g = new BlackJack();
        assertNotNull(g.player.hand);
    }

    @Test
    public void testDealerStartHand() {
        BlackJack g = new BlackJack();
        assertEquals(2,g.player.hand.size());
    }

    @Test
    public void testBet() {
        BlackJack g = new BlackJack();
        g.player.bet(30);
        assertEquals(30, g.player.playerBet);
    }

    @Test
    public void testDoubleDown() {
        BlackJack g = new BlackJack();
        g.player.bet(30);
        g.player.doubleDown(g.deck);
        assertEquals(60, g.player.playerBet);
    }
}
