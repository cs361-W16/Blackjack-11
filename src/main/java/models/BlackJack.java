package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by danielgoh on 3/3/16.
 */
public class BlackJack {

    public ArrayList<Card> deck;
    public Player player;
    public Dealer dealer;

    public String gameStateString;

    public BlackJack() {
        buildDeck();
        shuffle();
        player = new Player();
        dealer = new Dealer();
        dealTwo();
        gameStateString = "Game is running";
    }

    public void buildDeck() {
        deck = new ArrayList<Card>();
        for(int i = 1; i < 14; i++){
            deck.add(new Card(i,Suit.Clubs));
            deck.add(new Card(i,Suit.Hearts));
            deck.add(new Card(i,Suit.Diamonds));
            deck.add(new Card(i,Suit.Spades));
        }
    }
    public void setGameStateString(String state){
        gameStateString = state;
    }

    public void shuffle() {
        long seed = System.nanoTime();
        Collections.shuffle(deck, new Random(seed));
    }

    public void dealTwo() {
        dealer.hit(deck);
        for(int i = 0; i < 2; i++){
            player.hit(deck);
        }
    }

    /*
    -1: dealer win
     1: player win
     0: draw
     */
    public int whoWins(){
        int playerScore = player.getTotal();
        int dealerScore = dealer.getTotal();
        if(playerScore >21){
            setGameStateString("You lose");
            return -1;
        }
        else if(dealerScore>21){
            setGameStateString("You win");
            return 1;
        }
        else {
            if(playerScore < dealerScore){
                setGameStateString("You lose");
                return -1;
            }
            else if(playerScore > dealerScore){
                setGameStateString("You win");
                return 1;
            }
            else{
                setGameStateString("Draw game");
                return 0;
            }
        }
    }
}
