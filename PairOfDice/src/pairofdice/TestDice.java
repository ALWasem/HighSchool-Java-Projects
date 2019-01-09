/*
Andre Wasem
Pair of Dice
2016

Models a pair of dice and rolls two sets until an equal number is achieved.
*/
package pairofdice;

public class TestDice {
    
    public static void main(String[] args) {
        
        PairOfDice Dice1 = new PairOfDice();
        PairOfDice Dice2 = new PairOfDice();
        PairOfDice Dice3 = new PairOfDice(1,2);
        
        boolean Equal = false;
        
        while(!Equal){
            
            Dice1.Roll();
            System.out.println("Set 1: " + Dice1.getDie1() + " + " + Dice1.getDie2() + " = " + Dice1.getDice());
            Dice2.Roll();
            System.out.println("Set 2: " + Dice2.getDie1() + " + " + Dice2.getDie2() + " = " + Dice2.getDice());
            
            
            
            if (Dice1.getDice() == Dice2.getDice())
                Equal = true;
        }
    }
}