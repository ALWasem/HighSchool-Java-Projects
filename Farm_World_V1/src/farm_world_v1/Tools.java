/* 
 Andre Wasem
 Mr. Ash
 Farm World
 November 10th 2016
 */

package farm_world_v1;

import static farm_world_v1.Farm.*;
import java.io.*;
import java.util.*;


public class Tools {

    public static void StoreFarms(List<Farm> Farm_List) throws IOException{    
        
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Farms.sp"));
        for (Farm f: Farm_List){
            f.writeFarm(out);
        }
        
    }
        // Returns a list of players loaded from a file
    public static List<Farm> LoadFarms() throws IOException, ClassNotFoundException{
        
        List<Farm> Farm_List = new ArrayList<Farm>();
        
        FileInputStream fis = new FileInputStream("Farms.sp");
        ObjectInputStream ois = new ObjectInputStream(fis);

        while(fis.available() > 0)
        {
           Farm farm = (Farm)ois.readObject();
           Farm_List.add(farm);
        }
        ois.close();
        
        return Farm_List;
    }
        // Returns whether there is an existing saved player list
    public static boolean DoesFarmListExist(){
    
        File f = new File("Farms.sp");
        if(f.exists() && !f.isDirectory()) 
            return true;
        else
            return false;
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

    public static double GetDoubleNumber(){
        Scanner reader = new Scanner(System.in);       
        while(true){
        try{
            return reader.nextDouble();
        }
        catch (InputMismatchException e){
          reader.next();
          Say ("Try AGAIN that was NOT an double:");
           }
        }
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
    public static List<Farm> GetStockPlayerList(){
        
        List<Farm> Farm_List = new ArrayList<Farm>();
        
        Farm farm = new Farm();
        farm.Product = "Corn";      
        farm.Profit = 14.50;
        farm.Amount = 0.45;
        farm.Acre = 11.5;
        Farm_List.add(farm);
        
        farm = new Farm();
        farm.Product = "Wheat";      
        farm.Profit = 11.05;
        farm.Amount = 0.05;
        farm.Acre = 26.25;
        Farm_List.add(farm);
        
        farm = new Farm();
        farm.Product = "Straw";      
        farm.Profit = 3.95;
        farm.Amount = 0.025;
        farm.Acre = 3.0;
        Farm_List.add(farm);
        
        return Farm_List;
    }
}