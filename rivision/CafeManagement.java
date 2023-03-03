package assignment01march.rivision;
import java.util.*;
import java.util.Scanner;
interface BookTables{
    boolean booking();
}
interface PlaceOrder{
    void display();
    void order();
}
public class CafeManagement implements BookTables, PlaceOrder {
    static int tableFor2=8, tableFor4= 4, tableFor6= 2, tableFor8=2;
    HashMap<String,Integer> order = new HashMap<String,Integer>();
    final String menu[]={"coffee","sandwich","water"};
    HashMap<String,Integer> menuPrice = new HashMap<String,Integer>();
    CafeManagement(){
        menuPrice.put("sandwich",150);
        menuPrice.put("coffee",120);
        menuPrice.put("water",60);
    }
    int tableNumber, menuNumber;
    @Override
    public boolean booking() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Please enter the number of persons");
    int demand = scanner.nextInt();
    synchronized (this) {
        boolean seat = false;
        if (demand <= 2) {
            if (tableFor2 != 0) {
                tableFor2 -= 1;
                seat = true;
                System.out.println("congration your seat is booked having max occupancy " + 2);
            }
        }
        if (demand <= 4 && !seat) {
            if (tableFor4 != 0) {
                tableFor4 -= 1;
                seat = true;
                System.out.println("congration your seat is booked having max occupancy " + 4);
            }
        }
        if (demand <= 6 && !seat) {
            if (tableFor6 != 0) {
                tableFor6 -= 1;
                seat = true;
                System.out.println("congration your seat is booked having max occupancy " + 6);
            }
        }
        if (demand <= 8 && !seat) {
            if (tableFor8 != 0) {
                tableFor8 -= 1;
                seat = true;
                System.out.println("congration your seat is booked having max occupancy " + 8);
            }
        }
        if (!seat) {
            System.out.println("Sorry our cafe is full please wait for some time.");
            return false;
        }
        return true;
    }
}
    @Override
    public void display() {
        System.out.println("1. coffee :: 120 \n2. sandwich :: 150 \n3. Water :: 60 \n4. Ends");
    }
    @Override
    public void order() {
        int choice;
        int bill=0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the table number");
        tableNumber= scanner.nextInt();
        do {
            display();
            choice = scanner.nextInt();
            if(choice==4){
                break;
            }
            System.out.println("Enter quantity");
            int quantity = scanner.nextInt();
            bill+=menuPrice.get(menu[choice-1])*quantity;
            order.put(menu[choice-1],quantity);
        }while(choice!=4);
        try {
            if (!order.containsKey("coffee")) {
                throw new InvalidOrderException();
            }
            System.out.println("-------------------------------------------------\n-----------------------------");
            System.out.println("Your bill is :");
            Random random = new Random();
            int billNumber = random.nextInt(1000) + 1;
            System.out.println("Bill no is :: "+billNumber);
            HashMap<String,Integer> sortMenuPrice=sortMap(menuPrice);
            System.out.println("  Items   unitprice  Qty  total");
            for(Map.Entry m : sortMenuPrice.entrySet()){
                if(order.containsKey(m.getKey())){
                    int sum=order.get(m.getKey()).intValue()*(int)m.getValue();
                    String result=String.format("%8s", m.getKey())+"    "+String.format("%4s",m.getValue())+"      "+order.get(m.getKey())+"    "+sum;
                    System.out.println(result);
                }
            }
            System.out.println("------------------------------------\n--------------------------------------");
            System.out.println("your total bill is "+bill);
        }
        catch (InvalidOrderException e){
            System.out.println("You must have to add 1 coffee");
        }

    }
    HashMap<String,Integer> sortMap(HashMap<String,Integer> hashMap){
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(hashMap.entrySet());
        Collections.sort(entryList, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : entryList) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }
}
