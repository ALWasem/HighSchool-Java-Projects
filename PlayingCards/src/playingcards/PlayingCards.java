/*
Andre Wasem
PlayingCards
2017

An object oriented excercise to model a deck of cards using object oriented methodology.
The deck of cards is then used to play several card games, War and GoFish.
 */
package playingcards;

import java.util.*;
import playingcards.*;
import static playingcards.Tools.*;

public class PlayingCards {

    
    public static void main(String[] args) {

        War();
        //GoFish();
        //X();
    }
    
    //Go Fish
    public static void GoFish(){
        
        Deck Deck1 = new Deck();
        Deck1.Shuffle();
        List<Card> AI = Deck1.Deal(6);
        List<Card> AIDoubles = new ArrayList();
        List<Card> Player = Deck1.Deal(6);
        List<Card> PlayerDoubles = new ArrayList();

        
        while(Deck1.cardCount() > 0){
            AIDoubles.addAll(getDoubles(AI));
            PlayerDoubles.addAll(getDoubles(Player));
            if (AI.size() < 6 && Deck1.cardCount() >= 6 - AI.size())
                AI.addAll(Deck1.Deal(6 - AI.size()));
            if (Player.size() < 6 && Deck1.cardCount() >= 6 - Player.size())
                Player.addAll(Deck1.Deal(6 - Player.size()));
            Sayln("Your Cards:");
            Sayln("");
            for (int i = 0; i < Player.size(); i++){
                Say(Player.get(i).toString());            
            }
            Sayln("");
            System.out.println("AI Doubles: " + AIDoubles.size()/2);
            System.out.println("Your Doubles: " + PlayerDoubles.size()/2);
            Sayln("");
            Say("Enter Card : ");
            String guess = GetString().trim();          
            while(guess.isEmpty() || !Player.toString().contains(guess) ){
                Say("Renter Card : ");
                guess = GetString().trim();
            }
            Card fish = null;
            for (int i = 0; i < AI.size(); i++){
                if ((AI.get(i)).toString().contains(guess)){
                    fish = AI.get(i);
                    AI.remove(i);                                      
                }
            }
            if (fish == null){
                Sayln("Go Fish");
                fish = Deck1.Deal(1).get(0);
                Player.add(fish);
                Sayln(fish.toString());
            }
            else{
                System.out.println("You Got " + fish.toString());
                Player.add(fish);
            }
            AcceptEnter();
        }
        if (AIDoubles.size() > PlayerDoubles.size())
            Sayln("AI WINS!!");
        if (AIDoubles.size() > PlayerDoubles.size())
            Sayln("YOU WIN!!");

    }
    
    //War
    public static void War(){
    
        Deck Deck1 = new Deck();
        Deck1.Shuffle();
        List<Card> Hand1 = Deck1.Deal(26);
        List<Card> Hand2 = Deck1.Deal(26);
        
        while (!(Hand1.size() == 52 || Hand2.size() == 52)){
            Tools.Sayln("");
            
            Tools.AcceptEnter();
            
            Card Card1 = Hand1.get(0);            
            Tools.Sayln("Player 1: " + Card1.toString());
            Card Card2 = Hand2.get(0);            
            Tools.Sayln("Player 2: " + Card2.toString());
            
            if (Card1.getRank() > Card2.getRank()){
                Tools.Sayln("Player 1 wins the " + Card2.toString());                
                Hand1.remove(Card1);                
                Hand2.remove(Card2);
                Hand1.add(Hand1.size(), Card1);
                Hand1.add(Hand1.size(), Card2);                
                
            }
            else if (Card1.getRank() < Card2.getRank()){
                Tools.Sayln("Player 2 wins the " + Card1.toString());                
                Hand2.remove(Card2);
                Hand1.remove(Card1);                                
                Hand2.add(Hand2.size(), Card1);
                Hand2.add(Hand2.size(), Card2);
                
            }
            else{ //Card1.getRank() == Card2.getRank()
                
                if (Hand1.size() > 2 && Hand1.size() > 2){
                
                    Tools.Sayln("");
                    Tools.Sayln("-----------WAR-----------");
                    Tools.Sayln("");
                    
                    //Tools.AcceptEnter();
                                        
                    Card Card3 = Hand1.get(1);
                    Card Card5 = Hand1.get(2);
                    Tools.Sayln("Player 1: " + Card5.toString());
                    Card Card4 = Hand2.get(1);
                    Card Card6 = Hand2.get(2);
                    Tools.Sayln("Player 2: " + Card6.toString());
                    
                    
                    if (Card5.getRank() > Card6.getRank()){
                        Tools.Sayln("Player 1 wins the War");
                        Tools.Sayln("Player 1 wins the " + Card2.toString());                        
                        Tools.Sayln("                  " + Card4.toString());
                        Tools.Sayln("                  " + Card6.toString());
                        Hand1.remove(Card1);
                        Hand1.remove(Card3);
                        Hand1.remove(Card5);
                        Hand2.remove(Card2);
                        Hand2.remove(Card4);
                        Hand2.remove(Card6);
                        Hand1.add(Hand1.size(), Card1);                
                        Hand1.add(Hand1.size(), Card2);
                        Hand1.add(Hand1.size(), Card3);
                        Hand1.add(Hand1.size(), Card4);
                        Hand1.add(Hand1.size(), Card5);
                        Hand1.add(Hand1.size(), Card6);                        
                    
                    }
                    else if(Card5.getRank() < Card6.getRank()){
                        Tools.Sayln("   Player 2 wins the War");
                        Tools.Sayln("   Player 2 wins the " + Card1.toString());                       
                        Tools.Sayln("                     " + Card3.toString());                        
                        Tools.Sayln("                     " + Card5.toString());                        
                        Hand1.remove(Card1);
                        Hand1.remove(Card3);
                        Hand1.remove(Card5);
                        Hand2.remove(Card2);
                        Hand2.remove(Card4);
                        Hand2.remove(Card6);
                        Hand2.add(Hand2.size(), Card1);                
                        Hand2.add(Hand2.size(), Card2);
                        Hand2.add(Hand2.size(), Card3);
                        Hand2.add(Hand2.size(), Card4);
                        Hand2.add(Hand2.size(), Card5);
                        Hand2.add(Hand2.size(), Card6);                        
                    }  
                }
                else{
                    Hand1.remove(Card1);
                    Hand2.remove(Card2);
                    Hand1.add(Hand1.size(), Card1);                
                    Hand2.add(Hand2.size(), Card2);
                }
                    
            }
            Tools.Sayln("Player 1: " + Hand1.size() + " Cards");
            Tools.Sayln("Player 2: " + Hand2.size() + " Cards");
        }
        if (Hand1.size() == 52){
            Tools.Sayln("");
            Tools.Sayln("PLAYER 1 WINS");
            Tools.Sayln("");
        }
        
        else if (Hand1.size() == 52){
            Tools.Sayln("");
            Tools.Sayln("PLAYER 2 WINS");
            Tools.Sayln("");
        }
    }
    
    
    public static void X(){
    
    Deck deck = new Deck();
    deck.Shuffle();
    List<Card> X = deck.Deal((int)(Math.random() * 52 + 1));
    int Spade = 0;
    int Club = 0;
    int Heart = 0;
    int Dimond = 0;

    for (Card card : X){
        if (card.suitToString() == "Hearts")
            Heart ++;
        else if (card.suitToString() == "Clubs")
            Club ++;
        else if (card.suitToString() == "Dimands")
            Dimond ++;
        else if (card.suitToString() == "Spades")
            Spade ++;
    }
    
    System.out.println("You have selected " + X.size() + " random Cards");
    System.out.println("You have selected " + Heart + " Hearts");
    System.out.println("You have selected " + Club + " Clubs");
    System.out.println("You have selected " + Dimond + " Dimands");
    System.out.println("You have selected " + Spade + " Spades");
   
    }
}
