package models;

import java.util.ArrayList;

/**
 * Created by user on 2016/03/08.
 */
public class Player extends GamePlayer{
    public int money;
    public int playerBet;
    public boolean is_split;
    public java.util.List<Card> split_hand;
    public int winnerWinnerChickenDinner = 2;

    public Player(){
        super();
        money = 100;
        playerBet = 0;
        is_split = false;
        split_hand = new ArrayList<>();
    }

    public boolean bet(int bet){
        if(bet < 0 || bet > money) return false;
        else {
            playerBet = bet;
            return true;
        }
    }

    public boolean doubleDown(ArrayList<Card> deck){
        if(bet(playerBet * 2) == false) return false;
        else{
            hit(deck);
            stay();
            return true;
        }
    }
    public int getSplitTotal(){
        int sum = 0;
        int score;
        int aces = 0;
        for(int i=0; i < split_hand.size(); i++){
            score = split_hand.get(i).getValue();
            if(score > 9) score = 10;       //J, Q, K
            else if (score == 1){       //A
                aces++;
                score = 11;
            }
            sum += score;
        }
        //decide A is 1 or 11
        if(sum > 21){
            for(int i=0; i<aces; i++) {
                sum -= 10;
                if(sum < 22) break;
            }
        }

        return sum;
    }
    public void split(){
        playerBet = playerBet* 2;


        split_hand.add(hand.get(hand.size()-1));
        hand.remove(hand.get(hand.size()-1));
        is_split = true;
    }
    public void split_hit(ArrayList<Card> deck){


        if(is_split == true && getTotal() > 21) {
            turnEnd = true;
            split_hand.add(deck.get(deck.size() - 1));
            deck.remove(deck.size() - 1);
            if(getSplitTotal() > 21)
                stay();
        }
        else
            hit(deck);
    }



    public void loser() {
        money = money - playerBet;
    }

    public void winner(){
        money = money + playerBet;
    }

    public void blackjackBaby(){
        money = money + (playerBet * winnerWinnerChickenDinner);
    }
}