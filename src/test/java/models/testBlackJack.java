package models;

import org.junit.Test;

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



}

