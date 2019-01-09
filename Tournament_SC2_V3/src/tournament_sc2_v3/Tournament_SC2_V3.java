/* 
 Andre Wasem
 StarCraft II Tournament Bracket
 2017

This program models the stages of a game tournament, including storing and retrieving a list of players from a file,
running a group stage and elimination bracket, and using player weighting and random numbers to determine match results.
 */

package tournament_sc2_v3;
import java.util.*;
import java.io.IOException;
import Tournament_SC2_V3.Tools;
import Tournament_SC2_V3.Player;

public class Tournament_SC2_V3 {
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        
        Scanner readinput = new Scanner(System.in);        
        Random R = new Random();        
        List <Player> Player_List = new ArrayList();
        boolean recreatePlayerList = true;
        int Tournament_Size = 0;
        
        if (Tools.DoesPlayerListExist()){
            Sayln ("A list players already exists.");
            Sayln ("");
            Sayln ("Choose from the following options:");
            Sayln ("  1 - Load existing List");
            Sayln ("  2 - Load default List");
            Sayln ("  3 - Load new List");
            Say ("Choose (1,2,3): ");
            String response = Tools.GetString();
            if (response.contains("1"))         // Load existing player list
            {
                Player_List = Tools.LoadPlayers();
                Tournament_Size = Player_List.size();
                Sayln ("Loaded Player List (" + Player_List.size() + ") :");
                Sayln ("");
                for (Player p: Player_List){
                    Sayln (p.Name);
                }
                Sayln ("");
                Tools.PressAnyKeyToContinue();
                recreatePlayerList = false;
            }
            else if (response.contains("2"))    // Load stock list
            {
                Player_List = Tools.GetStockPlayerList();
                Tournament_Size = Player_List.size();
                Sayln ("Loaded Stock List (" + Player_List.size() + ") :");
                Sayln ("");
                for (Player p: Player_List){
                    Sayln (p.Name);
                }
                Sayln ("");
                Tools.PressAnyKeyToContinue();
                recreatePlayerList = false;
            }
        }
        else{
            Sayln ("No list players currently exists.");
            Sayln ("");
            Sayln ("Choose from the following options:");
            Sayln ("  1 - Load default List");
            Sayln ("  2 - Load new List");
            Say ("Choose (1, 2): ");
            String response = Tools.GetString();
            if (response.contains("2"))         // As user for new player list
            {
                recreatePlayerList = true;
            }
            else if (response.contains("1"))    // Load stock list
            {
                Player_List = Tools.GetStockPlayerList();
                Tournament_Size = Player_List.size();
                Sayln ("");
                Sayln ("Loaded Stock List (" + Player_List.size() + ") :");
                Sayln ("");
                for (Player p: Player_List){
                    Sayln (p.Name);
                }
                Sayln ("");
                Tools.PressAnyKeyToContinue();
                recreatePlayerList = false;
            }
        }

        if (recreatePlayerList){
            
            while (Tournament_Size != 16 &&
                   Tournament_Size != 8){

                Say ("Enter Amount Of Players In Tournoment (8 Or 16): ");
                Tournament_Size = GetIntegerNumber();

            }        

            for (int i = 0; i < Tournament_Size; i++) {
                Player player = new Player();
                player.R = R;
                Say ("Enter Player Name: ");
                player.Name = readinput.nextLine();
                Say ("Enter Player Skill: ");
                player.Skillz = GetIntegerNumber();
                Sayln ("");
                Player_List.add(player);            
            }
            Tools.StorePlayers(Player_List);
        }
        
        int Rounds = 1;
        int Factor = Tournament_Size;

        while (Factor > 2){
            Factor = Factor/2;
            Rounds ++;
        }
        
        Sayln ("Amount Of Rounds : " + Rounds);
        
        SingleElimination(GroupStage(Rounds, Player_List),Rounds);
  
    }
    
    public static void SingleElimination(List <Player> Player_Winners, int Rounds){
        
        List <Player> SingleElimination_Winners = new ArrayList();        
        
        
            Scanner readinput = new Scanner(System.in);
        
            Say ("Hit Enter To Start Single Elimination Round");
            Sayln ("");

            String enterkey = "";
            enterkey = readinput.nextLine();
            
        for (int i = 1; i <= (Rounds - 1); i++){
            if(enterkey.equals("")){
                for (int p = 1; p <= Player_Winners.size()/2; p++){

                    if (AcceptEnter()){

                        Player Player1 = Player_Winners.get((p*2)-2);
                        Player Player2 = Player_Winners.get((p*2)-1);               

                        Sayln (Player1.Name + " VS " + Player2.Name);
                        Sayln (Player1.Skillz + " - " + Player2.Skillz);                            

                        if(Player1.MatchResult(Player2.Skillz)){

                            Sayln ("Match " + p + " Victor - " + Player1.Name); 
                            Sayln ("");

                            SingleElimination_Winners.add(Player1);
                        }
                        else{

                            Sayln ("Match " + p + " Victor - " + Player2.Name);
                            Sayln ("");
                            SingleElimination_Winners.add(Player2);
                        }
                    }                
                }                
            }
            Player_Winners = SingleElimination_Winners;
        }     
    }
    
    public static List <Player> GroupStage(int Rounds , List <Player> Player_List){
        
        List <Player> Player_Winners = new ArrayList();
        
        int x = 0;
        
        for (int r = 1; r <= Player_List.size()/4; r++){
            Scanner readinput = new Scanner(System.in);

            Say ("Hit Enter To Start Group " + r);
            Sayln ("");

            String enterkey = "";
            enterkey = readinput.nextLine();

            if(enterkey.equals("")){

                //for (int p = 1; p <= Player_List.size()/4; p++){

                    Player Player1 = Player_List.get(r-1+x);
                    Player Player2 = Player_List.get(r+x);
                    Player Player3 = Player_List.get(r+1+x);
                    Player Player4 = Player_List.get(r+2+x);

                    x+=3;

                    Sayln ("Group " + r); 

                    Sayln (Player1.Name);
                    Sayln (Player2.Name);
                    Sayln (Player3.Name);
                    Sayln (Player4.Name);
                    Sayln ("");


                    Player Game_1_Winner = null;
                    Player Game_1_Loser = null;

                    Player Game_2_Winner = null;
                    Player Game_2_Loser = null;

                    Player Game_3_Winner = null;
                    Player Game_3_Loser = null;

                    Player Game_4_Winner = null;
                    Player Game_4_Loser = null;

                    Player Game_5_Winner = null;
                    Player Game_5_Loser = null;


                    //Match 1
                    if (AcceptEnter()){                   
                        Game_1_Winner = PlayRound(Player1,Player2);
                        if (Game_1_Winner == Player1)
                            Game_1_Loser = Player2;
                        else
                            Game_1_Loser = Player1;
                    }

                    //Match 2
                    if (AcceptEnter()){
                        Game_2_Winner = PlayRound(Player3,Player4);
                        if (Game_2_Winner == Player3)
                            Game_2_Loser = Player4;
                        else
                            Game_2_Loser = Player3;
                    }

                    //Winners Match
                    if (AcceptEnter()){
                        Game_3_Winner = PlayRound(Game_1_Winner,Game_2_Winner);
                        Player_Winners.add(Game_3_Winner);
                        if (Game_3_Winner == Game_1_Winner)
                            Game_3_Loser = Game_2_Winner;                   
                        else
                            Game_3_Loser = Game_1_Winner;
                    }

                    //Losers Match
                    if (AcceptEnter()){                 
                        Game_4_Winner = PlayRound(Game_1_Loser,Game_2_Loser);
                        if (Game_4_Winner == Game_1_Loser)
                            Game_4_Loser = Game_2_Loser;
                        else
                            Game_4_Loser = Game_1_Loser;
                    }

                    //Final Match
                    if (AcceptEnter()){
                        Game_5_Winner = PlayRound(Game_3_Loser,Game_4_Winner);
                        Player_Winners.add(Game_5_Winner);
                        if (Game_5_Winner == Game_3_Loser)
                            Game_5_Loser = Game_4_Winner;
                        else
                        Game_5_Loser = Game_3_Loser;
                    }
                //}        
            }
        }
        return Player_Winners;
    }
    
    public static Player PlayRound(Player Player1 , Player Player2){
        
        Sayln (Player1.Name + " VS " + Player2.Name);
        Sayln (Player1.Skillz + " - " + Player2.Skillz);
        boolean Game_Win = Player1.MatchResult(Player2.Skillz);
        Player Game_Winner;
        if (Game_Win){
            Game_Winner = Player1;
            Sayln ("Victor - " + Player1.Name);
            Sayln ("");            
        }
        
        else{
            Game_Winner = Player2;
            Sayln ("Victor - " + Player2.Name);
            Sayln ("");
        }
        return Game_Winner;        
    }   
    
    public static boolean AcceptEnter(){
        Say ("Hit Enter To Continue...");
        Sayln ("");
        Scanner readinput = new Scanner(System.in);            
        String enterkey = "";
        enterkey = readinput.nextLine();
            return (enterkey.equals(""));      
    }
    
    public static void Say (String Text){    
        System.out.print(Text);    
    }
    
    public static void Sayln (String Text){    
        System.out.println(Text);    
    }

    public static int GetIntegerNumber(){
        Scanner reader = new Scanner(System.in);       
        while(true){
        try{
            return reader.nextInt();
        }
        catch (InputMismatchException e){
          reader.next();
          Say ("Try AGAIN that was NOT an integer:");
           }
        }
    }
}