package models;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by danielgoh on 3/8/16.
 */
public class testBlackJack {

    @Test
    public void testGameCreation(){
        BlackJack g = new BlackJack();
        assertNotNull(g);
    }

    @Test
    public void testGameBuildDeck(){
        BlackJack g = new BlackJack();
        // 4 has been dealt
        assertEquals(48,g.deck.size());
    }

    @Test
    public void testGameInit(){
        BlackJack g = new BlackJack();
        g.shuffle();
        assertNotEquals(2,g.deck.get(0).getValue());
    }

    @Test
    public void testGameInitString(){
        BlackJack g = new BlackJack();
        assertEquals("Game is running",g.gameStateString);
    }

    @Test
    public void testDealTwo(){
        BlackJack g = new BlackJack();
        assertEquals(2,g.dealer.hand.size());
        assertEquals(2,g.player.hand.size());
    }

    @Test
    public void testWhoWins(){
        BlackJack g = new BlackJack();
        ArrayList<Card> playerHand = new ArrayList<>();
        ArrayList<Card> dealerHand = new ArrayList<>();
        playerHand.add(new Card(10, Suit.Spades));
        playerHand.add(new Card(12, Suit.Hearts));
        dealerHand.add(new Card(9, Suit.Clubs));
        dealerHand.add(new Card(1, Suit.Diamonds));
        g.player.hand = playerHand;
        g.dealer.hand = dealerHand;
        assertEquals(0, g.whoWins());
    }

    @Test
    public void testSetGameStateString(){
        BlackJack g = new BlackJack();
        assertEquals(g.gameStateString, "Game is running");
        g.setGameStateString("Make your decision");
        assertEquals(g.gameStateString, "Make your decision");
    }

}

