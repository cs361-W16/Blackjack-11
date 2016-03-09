package models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by danielgoh on 3/4/16.
 */
public class testCard {

    @Test
    public void testToString(){
        Card c = new Card(5,Suit.Clubs);
        assertEquals("5Clubs",c.toString());
    }

}
