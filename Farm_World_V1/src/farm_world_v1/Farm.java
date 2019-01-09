/* 
 Andre Wasem
 Mr. Ash
 Farm World
 November 10th 2016
 */
package farm_world_v1;

import static farm_world_v1.Tools.*;
import java.io.*;
import java.text.*;
import java.util.*;

public class Farm implements Serializable{

    public String Product;        
    public double Profit;
    public double Amount;
    public double Acre;
    
    public void CreateFarm(){
                          
        Say("Enter Product - ");
        this.Product = GetString();
        Say("Enter Profit Per Pound - ");
        this.Profit = GetDoubleNumber();
        Say("Enter Pounds Of Product Per SQ. FT. - ");
        this.Amount = GetDoubleNumber();
        Say("Enter Amount of Acre's - ");
        this.Acre = GetDoubleNumber();
        Sayln("");

    }
    
    
    public void Stats(){
        
        NumberFormat Formatter = NumberFormat.getCurrencyInstance(Locale.US);
        
        double Pounds_Per_Acre = this.Amount * 43560; 
        double Total_Pounds = Pounds_Per_Acre * this.Acre;
        double Profet_Per_Acre = this.Profit * Pounds_Per_Acre;
        double Total_Profet = Profet_Per_Acre * this.Acre;

        Sayln("Product - " + this.Product);
        Sayln("Pounds Per Acre Of " + this.Product +  " - " + Pounds_Per_Acre + " lbs");
        Sayln("Total Pounds Of " + this.Product  + " - " + Total_Pounds + " lbs");
        Sayln("Profit Per Acre Of " + this.Product  + " - " + Formatter.format(Profet_Per_Acre));
        Sayln("Total Profet Of " + this.Product  + " - " + Formatter.format(Total_Profet));
        Sayln("");

    }

    public void writeFarm(ObjectOutputStream out) {
        try{
          out.writeObject(this);
          out.flush();
        }
        catch(Exception e){
           e.printStackTrace();
        }
    }
}