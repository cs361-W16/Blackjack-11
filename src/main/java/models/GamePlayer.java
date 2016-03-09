package models;

import java.util.ArrayList;

/**
 * Created by user on 2016/03/08.
 */
public abstract class GamePlayer {
    public java.util.List<Card> hand;
    boolean turnEnd;

    GamePlayer(){
        hand = new ArrayList<>();
        turnEnd = false;
    }

    public void addHand(Card card){
        hand.add(card);
    }

    public void hit(ArrayList<Card> deck){
        addHand(deck.get(deck.size()-1));
        deck.remove(deck.size()-1);
    }

    public void stand(){
        turnEnd = true;
    }

    public int getTotal(){
        int sum = 0;
        int score;
        int aces = 0;
        for(int i=0; i < hand.size(); i++){
            score = hand.get(i).getValue();
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
}
