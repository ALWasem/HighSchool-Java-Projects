/*
Andre Wasem
Mr. Ash
PlayingCards
November 26th
 */
package playingcards;

import java.io.ObjectOutputStream;

public class Card {
    
    public final static int HEARTS = 1;
    public final static int CLUBS = 2;
    public final static int SPADES = 3;
    public final static int DIAMONDS = 4;
    
    public final static int ACE = 1;
    public final static int TWO = 2;
    public final static int THREE = 3;
    public final static int FOUR = 4;
    public final static int FIVE = 5;
    public final static int SIX = 6;
    public final static int SEVEN = 7;
    public final static int EIGHT = 8;
    public final static int NINE = 9;
    public final static int TEN = 10;
    public final static int JACK = 11;
    public final static int QUEEN = 12;
    public final static int KING = 13;
    
    private int Suit;
    private int Rank;

    public Card(int S, int R){
        
        Suit = S;
        Rank = R;

    }
  
    public int getRank(){
        return this.Rank;
    }
    
    public int getCard(){   
        return this.Suit;
    }
    
    public String rankToString(){
        
        switch(Rank){
            case Card.ACE:
                return "Ace";
            case Card.TWO:
                return "Two";
            case Card.THREE:
                return "Three";
            case Card.FOUR:
                return "Four"; 
            case Card.FIVE:
                return "Five";
            case Card.SIX:
                return "Six";
            case Card.SEVEN:
                return "Seven";
            case Card.EIGHT:
                return "Eight";
            case Card.NINE:
                return "Nine";
            case Card.TEN:
                return "Ten";
            case Card.JACK:
                return "Jack";
            case Card.QUEEN:
                return "Queen";
            case Card.KING:
                return "King";
            default:
                return "";            
                
        }
        
    }
        
    public String suitToString(){
    
        switch(Suit){
            case Card.HEARTS:
                return "Hearts";
            case Card.CLUBS:
                return "Clubs";
            case Card.DIAMONDS:
                return "Dimands";
            case Card.SPADES:
                return "Spades";
            default:
                return "";

        }
    }     
        
     // Return a text description of the current card (including rank and suit)
    public String toString() {
        return rankToString() + " of " + suitToString() + "\n";
    }
    
    public void writeCard(ObjectOutputStream out){
        try{
          out.writeObject(this);
          out.flush();
        }
        catch(Exception e){
           e.printStackTrace();
        }
    } 
    
}
    

