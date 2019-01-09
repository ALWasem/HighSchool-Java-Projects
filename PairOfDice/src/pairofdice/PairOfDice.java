/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pairofdice;

import java.util.*;

public class PairOfDice {
    
    private int die1;
    private int die2;
    
    public PairOfDice(){       
        Roll();          
    }
    public PairOfDice(int d1, int d2){
        
        

    }
    
    public int getDie1(){    
        return die1;
    }
    
    public int getDie2(){    
        return die2;
    }
    public int getDice(){
        return die1 + die2;
    }
    
    
    public void setDie1(int D1){
        die1 = D1;   
    }
    
    public void setDie2(int D1){
        die2 = D1;   
    }
    
    public void Roll(){
        Random R = new Random();
        die1 = R.nextInt(6) + 1;
        die2 = R.nextInt(6) + 1;    
    }
    
         
    
    
    
    
    
}
