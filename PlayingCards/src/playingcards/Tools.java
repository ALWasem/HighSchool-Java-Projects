/*
Andre Wasem
Mr. Ash
PlayingCards
November 26th
 */
package playingcards;

import java.util.*;

import java.io.*;

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
    
    // Stores a list of cards to a file
    public static void StoreCards(List<Card> cardList) throws IOException{
        
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Cards.sp"));
        for (Card p: cardList){
            p.writeCard(out);
        }
        
    }
    
    // Returns a list of cards loaded from a file
    public static List<Card> LoadCards() throws IOException, ClassNotFoundException{
        
        List<Card> cardList = new ArrayList<Card>();
        
        FileInputStream fis = new FileInputStream("Cards.sp");
        ObjectInputStream ois = new ObjectInputStream(fis);

        while(fis.available() > 0)
        {
           Card plyr = (Card)ois.readObject();
           cardList.add(plyr);
        }
        ois.close();
        
        return cardList;
    }

    // Returns whether there is an existing saved card list
    public static boolean DoesCardListExist()
    {
        File f = new File("Cards.sp");
        if(f.exists() && !f.isDirectory()) 
            return true;
        else
            return false;
    }
    
    // Returns a list of cards with the same rank
    public static List<Card> getDoubles(List<Card> CardList){
        List<Card> PlayerDoubles = new ArrayList();
        for (int i = 0; i < CardList.size(); i++){
            Card card1 = CardList.get(i);            
            for (int x = i + 1; x < CardList.size(); x++){                
                Card card2 = CardList.get(x);                                   
                if (card1.getRank() == card2.getRank()){
                    PlayerDoubles.add(card1);
                    PlayerDoubles.add(card2);                   
                    break;                    
                }                                 
            }
            if (PlayerDoubles.size() > 0)
                break;
        }
        if (PlayerDoubles.size() > 0){
            CardList.removeAll(PlayerDoubles);
            if (CardList.size() > 1)
                PlayerDoubles.addAll(getDoubles(CardList));
        }
        return PlayerDoubles;
    }    
    
    public static boolean AcceptEnter(){
        Say ("Hit Enter To Continue the Game...");
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
    
}
