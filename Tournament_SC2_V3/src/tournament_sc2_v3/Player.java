/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tournament_SC2_V3;

import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Random;

public class Player implements Serializable{
    
    public String Name;
    public int Skillz;
    public Random R = new Random();

    public boolean Game(int Enemy_Skill) {           
        return (R.nextInt(Skillz)) >= (R.nextInt(Enemy_Skill));     
    }
    
    public boolean MatchResult(int Enemy_Skill) {                                                                    
        int GameWinner1 = 0;
        int GameWinner2 = 0;

        for (int i = 1;i <= 3; i++){

            if (Game(Enemy_Skill))
                GameWinner1 ++;                        
            else 
                GameWinner2 ++;

            if (GameWinner1 == 2 || GameWinner2 == 2)
                break;

        }
        System.out.println (GameWinner1 + " - " + GameWinner2);

        return (GameWinner1 > GameWinner2);
    }
    
    public void writePlayer(ObjectOutputStream out){
        try{
          out.writeObject(this);
          out.flush();
        }
        catch(Exception e){
           e.printStackTrace();
        }
    }    
}
