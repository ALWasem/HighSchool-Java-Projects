/*
Andre Wasem
Mr. Ash
PlayingCards
November 26th
 */
package playingcards;

import java.io.ObjectOutputStream;
import java.util.*;


public class Deck {
    
    private Card[][] Cards;
    private List<Card> Stack; 
    // Create a Deck
    public Deck(){        
        Cards = new Card[4][13];
        Stack = new ArrayList();
        for(int s = Card.HEARTS; s <= Card.DIAMONDS; s++){            
            for (int r = Card.ACE; r <= Card.KING; r++){      
                Cards[s - 1][r - 1] = new Card(s, r);
                Stack.add(Cards[s - 1][r - 1]);
            }
        }
    }    
    // List deck in the current order    
    public String toString(){
        return Stack.toString();
    }
    // Set the cards in the original order
    public void Sort(){        
        Stack = new ArrayList();
        for(int s = Card.HEARTS; s <= Card.DIAMONDS; s++){            
            for (int r = Card.ACE; r <= Card.KING; r++){                    
                Stack.add(Cards[s - 1][r - 1]);
            }
        }       
    }    
    // Shuffle the deck randomly
    public void Shuffle(){        
        Collections.shuffle(Stack);     
    }
    // Deal a certain amount of cards
    public List<Card> Deal(int C){
        List<Card> Delt_Stack = new ArrayList();
        if (C >= 1 && C <= 52){        
            Delt_Stack = new ArrayList(Stack.subList(0, C));        
            Stack.removeAll(Delt_Stack);
        }            
        return Delt_Stack;
        
    }
    // Count amount of cards in deck
    public int cardCount(){
        return Stack.size();
    }
    
    
    
    
}
