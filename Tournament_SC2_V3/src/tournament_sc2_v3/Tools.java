/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tournament_SC2_V3;

import java.util.*;

import java.io.*;
/**
 *
 * @author Tim Ash
 */
public class Tools {
    
    // Prompt the user for a string value
    public static String GetString(){
        Scanner scan = new Scanner(System.in); 
        while(true){
        try{
            return scan.nextLine();
        }
        catch (InputMismatchException e) {
            scan.nextLine();
            System.out.print ("Please Enter a string value");
            }
        }
    }

    // Prompt the user for a string value
    public static int GetInteger(){
        Scanner scan = new Scanner(System.in); 
        while(true){
        try{
            return scan.nextInt();
        }
        catch (InputMismatchException e) {
            scan.nextInt();
            System.out.print ("Please Enter a positive integer value");
            }
        }
    }

    // Prompts the user to hit any key to continue
    public static void PressAnyKeyToContinue() { 
        System.out.println("Press any key to continue...");
        try
        {
            System.in.read();
        }  
        catch(Exception e) {}  
     }
    
    // Stores a list of players to a file
    public static void StorePlayers(List<Player> playerList) throws IOException{
        
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Players.sp"));
        for (Player p: playerList){
            p.writePlayer(out);
        }
        
    }
    
    // Returns a list of players loaded from a file
    public static List<Player> LoadPlayers() throws IOException, ClassNotFoundException{
        
        List<Player> playerList = new ArrayList<Player>();
        
        FileInputStream fis = new FileInputStream("Players.sp");
        ObjectInputStream ois = new ObjectInputStream(fis);

        while(fis.available() > 0)
        {
           Player plyr = (Player)ois.readObject();
           playerList.add(plyr);
        }
        ois.close();
        
        return playerList;
    }

    // Returns whether there is an existing saved player list
    public static boolean DoesPlayerListExist()
    {
        File f = new File("Players.sp");
        if(f.exists() && !f.isDirectory()) 
            return true;
        else
            return false;
    }
    
    // Returns the number of rounds for a given tourney size
    public static int GetTourneyRoundsCount(int tourneySize)
    {
        int rounds = 1;
        int factor = tourneySize;
        
        while (factor > 2){
            factor = factor/2;
            rounds ++;
        }
        return rounds;
    }
    
    // Returns a stock list of players
    public static List<Player> GetStockPlayerList(){
        
        List<Player> playerList = new ArrayList<Player>();
        
        Player plyr = new Player();
        plyr.Name = "Player 1";
        plyr.Skillz = 100;
        playerList.add(plyr);
        
        plyr = new Player();
        plyr.Name = "Player 2";
        plyr.Skillz = 100;
        playerList.add(plyr);
        
        plyr = new Player();
        plyr.Name = "Player 3";
        plyr.Skillz = 100;
        playerList.add(plyr);
        
         plyr = new Player();
        plyr.Name = "Player 4";
        plyr.Skillz = 100;
        playerList.add(plyr);
        
        plyr = new Player();
        plyr.Name = "Player 5";
        plyr.Skillz = 100;
        playerList.add(plyr);
        
        plyr = new Player();
        plyr.Name = "Player 6";
        plyr.Skillz = 100;
        playerList.add(plyr);
        
        plyr = new Player();
        plyr.Name = "Player 7";
        plyr.Skillz = 100;
        playerList.add(plyr);
        
        plyr = new Player();
        plyr.Name = "Player 8";
        plyr.Skillz = 100;
        playerList.add(plyr);
        
        return playerList;
        
    }
    
}
