package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by danielgoh on 3/3/16.
 */
public class BlackJack {

    public java.util.List<Card> deck = new ArrayList<>();
    public java.util.List<java.util.List<Card>> rows = new ArrayList<>();

    public int playerWin;

    public int dealerWin;

    public String gameStateString;

    public int playerMoney;

    public BlackJack() {
        Dealer d = new Dealer();
        Player p = new Player();
        //Dealer
        rows.add(new ArrayList<Card>());
        //Player
        rows.add(new ArrayList<Card>());
        buildDeck();
        p.money = 100;
        gameStateString = "Game is running";
    }

    public void buildDeck() {
        for(int i = 1; i < 14; i++){
            deck.add(new Card(i,Suit.Clubs));
            deck.add(new Card(i,Suit.Hearts));
            deck.add(new Card(i,Suit.Diamonds));
            deck.add(new Card(i,Suit.Spades));
        }
    }

    public void shuffle() {
        long seed = System.nanoTime();
        Collections.shuffle(deck, new Random(seed));
    }

    public void dealTwo() {
        //Deals to Dealer
        for(int i = 0; i < 2; i++){
            rows.get(0).add(deck.get(deck.size()-1));
            deck.remove(deck.size()-1);
        }
        //Deals to Player
        for(int i = 0; i < 2; i++){
            rows.get(1).add(deck.get(deck.size()-1));
            deck.remove(deck.size()-1);
        }
    }



}
