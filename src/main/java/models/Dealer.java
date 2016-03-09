package models;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
/**
 * Created by danielgoh on 3/3/16.
 */
public class Dealer extends GamePlayer {

    public Dealer(){
        super();
    }

    public void play(ArrayList<Card> deck){
        while(getTotal() < 17){
            hit(deck);
        }
        stand();
    }

}
