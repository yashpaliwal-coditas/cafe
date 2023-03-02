package assignment01march.rivision;
import java.util.*;
public class OrderBook {
    HashMap<String,Integer> order = new HashMap<String,Integer>();
    String menu[]={"coffee","sandwich","water"};
    HashMap<String,Integer> menuPrice = new HashMap<String,Integer>();
    int tableNumber, menuNumber;
    void display(){
        menuPrice.put("coffee",120);
        menuPrice.put("sandwich",150);
        menuPrice.put("water",60);
        System.out.println("1. coffee :: 120 \n2. sandwich :: 150 \n3. Water :: 60 \n4. Ends");
    }
    void orders(){
        int choice;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the table number");
        tableNumber= scanner.nextInt();
        menuNumber = scanner.nextInt();
        do {
            display();

            choice = scanner.nextInt();

            if(choice==4){
                break;
            }
            int quantity = scanner.nextInt();
            order.put(menu[choice-1],quantity);

        }while(choice!=4);
        if(!order.containsKey("coffee")){
//            throws new Exception("not allowed");
        }

    }
}
