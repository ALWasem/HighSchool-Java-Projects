/* 
 Andre Wasem
 Farm World
 2016

 This program was an excercise in accepting and validating user input for a list of farm products, and saving/restoring that list to a file.
 */

package farm_world_v1;

import static farm_world_v1.Tools.*;
import static farm_world_v1.Farm.*;
import java.io.IOException;
import java.text.*;
import java.util.*;

public class Farm_World_V1 {

    public static void main(String[] args) throws IOException, ClassNotFoundException  {              
        
        List <Farm> Farm_List = new ArrayList();
        int Farms;
        
        boolean recreateFarmList = true;
        
        if (Tools.DoesFarmListExist()){           
            Sayln ("Choose from the following options:");
            Sayln ("  1 - Load existing List");
            Sayln ("  2 - Load default List");
            Sayln ("  3 - Load new List");
            Say ("Choose (1,2,3): ");
            String response = Tools.GetString();
            if (response.contains("1"))         // Load existing player list
            {
                Farm_List = Tools.LoadFarms();              
                Sayln ("Loaded Player List (" + Farm_List.size() + ") :");
                Sayln ("");
                for (Farm f: Farm_List){
                    Sayln (f.Product);
                }
                Sayln ("");               
                recreateFarmList = false;
            }
            else if (response.contains("2"))    // Load stock list
            {
                Farm_List = Tools.GetStockPlayerList();       
                Sayln ("Loaded Stock List (" + Farm_List.size() + ") :");
                Sayln ("");
                for (Farm f: Farm_List){
                    Sayln (f.Product);
                }
                Sayln ("");
                //Tools.AcceptEnter();
                recreateFarmList = false;
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
                recreateFarmList = true;
            }
            else if (response.contains("1"))    // Load stock list
            {
                Farm_List = Tools.GetStockPlayerList();    
                Sayln ("");
                Sayln ("Loaded Stock List (" + Farm_List.size() + ") :");
                Sayln ("");
                for (Farm f: Farm_List){
                    Sayln (f.Product);
                }
                Sayln ("");                
                recreateFarmList = false;
            }
        }
        
        
        if (recreateFarmList){
            
            Menu();
           
            Farms = GetIntegerNumber();
            Sayln("");

            Get_Farm(Farms, Farm_List);
                   
        }

        Stats(Farm_List);       
        
    }
    
    public static void Menu() {
        
        Sayln("");
        Sayln("FARMWORLD V1");
        Sayln("");
        Say("Enter Amount Of Farms - ");

    }
    
    public static void Get_Farm(int Farms, List <Farm> Farm_List) throws IOException{        
        for (int i = 1; i <= Farms; i++){           
            Sayln("Farm " + i);
            Farm farm = new Farm();
            farm.CreateFarm();
            Farm_List.add(farm);              
        }
        Tools.StoreFarms(Farm_List);
    }
    
    public static void Stats(List <Farm> Farm_List){      
        for (Farm f: Farm_List){
            AcceptEnter();
            f.Stats();
        }    
    }
}