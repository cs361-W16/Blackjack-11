package models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotEquals;

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
        assertEquals(2, g.player.hand.size());
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

    @Test
    public void testWinner() {
        Player p = new Player();
        Player p2 = new Player();
        //Check to see if winning increases money
        p.bet(25);
        p.winner();
        assertNotEquals(p.money, p2.money);
    }

    @Test
    public void testWLoser() {
        Player p = new Player();
        Player p2 = new Player();
        //Check to see if winning decreases money
        p.bet(25);
        p.loser();
        assertEquals(p.money, p2.money);
    }

    @Test
    public void testBlackjack() {
        Player p = new Player();
        Player p2 = new Player();

        //Check to see if winner receives double payout
        p.bet(25);
        p.blackjackBaby();
        assertNotEquals(p.money, p2.money);
    }
}
