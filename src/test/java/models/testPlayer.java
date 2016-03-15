package models;

import org.junit.Test;

import java.util.ArrayList;

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
    public void testLoser() {
        Player p = new Player();
        Player p2 = new Player();
        //Check to see if winning decreases money
        p.bet(25);
        p.loser();
        assertEquals(p.money, p2.money-25);
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
    @Test
    public void testSplit(){
        BlackJack g = new BlackJack();
        ArrayList<Card> playerHand = new ArrayList<>();
        ArrayList<Card> dealerHand = new ArrayList<>();
        playerHand.add(new Card(7, Suit.Spades));
        playerHand.add(new Card(7, Suit.Hearts));
        g.player.hand = playerHand;
        g.player.bet(5);
        g.player.split();

        assertEquals(10,g.player.playerBet);

    }
    @Test
    public void testSplit2(){
        BlackJack g = new BlackJack();
        ArrayList<Card> playerHand = new ArrayList<>();
        ArrayList<Card> dealerHand = new ArrayList<>();
        playerHand.add(new Card(7, Suit.Spades));
        playerHand.add(new Card(7, Suit.Hearts));
        g.player.hand = playerHand;
        g.player.bet(5);
        g.player.split();

        assertEquals(true,g.player.is_split);

    }
    @Test
    public void testSplit3(){
        BlackJack g = new BlackJack();
        ArrayList<Card> playerHand = new ArrayList<>();
        ArrayList<Card> dealerHand = new ArrayList<>();
        playerHand.add(new Card(7, Suit.Spades));
        playerHand.add(new Card(7, Suit.Hearts));
        g.player.hand = playerHand;
        g.player.bet(5);
        g.player.split();

        assertEquals(1,g.player.split_hand.size());

    }
    @Test
    public void testSplit4(){
        BlackJack g = new BlackJack();
        ArrayList<Card> playerHand = new ArrayList<>();
        ArrayList<Card> dealerHand = new ArrayList<>();
        playerHand.add(new Card(7, Suit.Spades));
        playerHand.add(new Card(7, Suit.Hearts));
        g.player.hand = playerHand;
        g.player.bet(5);
        g.player.split();

        assertEquals(1,g.player.hand.size());

    }
    @Test
    public void testSplitHit(){
        BlackJack g = new BlackJack();
        ArrayList<Card> playerHand = new ArrayList<>();
        ArrayList<Card> dealerHand = new ArrayList<>();
        playerHand.add(new Card(7, Suit.Spades));
        playerHand.add(new Card(7, Suit.Hearts));
        g.player.hand = playerHand;
        g.player.bet(5);
        g.player.split();
        g.player.split_hit(playerHand);
        assertEquals(1,playerHand.size());

    }
    @Test
    public void testSplitHit2(){
        BlackJack g = new BlackJack();
        ArrayList<Card> playerHand = new ArrayList<>();
        ArrayList<Card> dealerHand = new ArrayList<>();
        playerHand.add(new Card(7, Suit.Spades));
        playerHand.add(new Card(7, Suit.Hearts));

        g.player.hand = playerHand;
        g.player.bet(5);
        g.player.split();
        ArrayList<Card> playerSplitHand = new ArrayList<>();
        playerHand.add(new Card(9, Suit.Hearts));
        playerHand.add(new Card(9, Suit.Hearts));
        playerSplitHand.add(new Card(9, Suit.Hearts));
        playerSplitHand.add(new Card(9, Suit.Hearts));
        playerSplitHand.add(new Card(9, Suit.Hearts));
        playerSplitHand.add(new Card(9, Suit.Hearts));
        g.player.split_hand = playerSplitHand;
        g.player.split_hit(playerHand);
        assertEquals(true, g.player.turnEnd);

    }
    @Test
    public void testSplitHit3(){
        BlackJack g = new BlackJack();
        ArrayList<Card> playerHand = new ArrayList<>();
        ArrayList<Card> dealerHand = new ArrayList<>();
        playerHand.add(new Card(7, Suit.Spades));
        playerHand.add(new Card(7, Suit.Hearts));

        g.player.hand = playerHand;
        g.player.bet(5);
        g.player.split();
        ArrayList<Card> playerSplitHand = new ArrayList<>();
        playerHand.add(new Card(9, Suit.Hearts));
        playerHand.add(new Card(9, Suit.Hearts));
        playerSplitHand.add(new Card(1, Suit.Hearts));
        playerSplitHand.add(new Card(1, Suit.Hearts));
        playerSplitHand.add(new Card(9, Suit.Hearts));
        playerSplitHand.add(new Card(9, Suit.Hearts));
        g.player.split_hand = playerSplitHand;
        g.player.split_hit(playerHand);
        assertEquals(true, g.player.turnEnd);

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
        assertEquals(23, g.player.getSplitTotal());
    }
}
