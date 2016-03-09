package models;

import java.util.ArrayList;

/**
 * Created by user on 2016/03/08.
 */
public class Player extends GamePlayer{
    public int money;
    public int playerBet;

    public Player(){
        super();
        money = 100;
        playerBet = 0;
    }

    public boolean bet(int bet){
        if(bet < 0 || bet > money) return false;
        else {
            playerBet = bet;
            return true;
        }
    }

    public boolean doubleDown(ArrayList<Card> deck){
        if(bet(playerBet*2) == false) return false;
        else{
            hit(deck);
            stand();
            return true;
        }
    }
}
