package assignment01march.rivision;
import java.util.Scanner;
public class CafeExecution extends Thread {
    CafeManagement person ;
    CafeExecution(CafeManagement person){
        this.person = person;
    }
    public void run(){
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        boolean bookingStatus=false;
        while (flag){
            System.out.println("Enter the choice\n0. Exit \n1. book a table \n2. Display menu \n3. Order coffee");
            int choice = scanner.nextInt();
            switch (choice){
                case 0: flag=false;
                    break;
                case 1:synchronized (this) {
                    bookingStatus = person.booking();
                }
                    break;
                case 2: try{
                    if(!bookingStatus){
                        throw new ReservationException();
                    }
                    person.display();
                }
                catch (ReservationException e){
                    System.out.println("please Book table first");
                }
                    break;
                case 3:
                    try{
                        if(!bookingStatus) {
                            throw new ReservationException();
                        }
                        person.order();
                    }
                    catch (ReservationException e){
                        System.out.println("please Book table first");
                    }
                    break;
                default:
                    System.out.println("You have entered wrong choice");
            }
        }
    }
    public static void main(String[] args) {
       CafeManagement person = new CafeManagement();
       CafeExecution cafeExecution = new CafeExecution(person);
//       CafeExecution cafeExecution1 = new CafeExecution(person);
       cafeExecution.start();
//       cafeExecution1.start();
    }
}
//Enter the choice
//0. Exit
//1. book a table
//2. Display menu
//3. Order coffee
//1
//Please enter the number of persons
//7
//congration your seat is booked having max occupancy 8
//Enter the choice
//0. Exit
//1. book a table
//2. Display menu
//3. Order coffee
//2
//+---+----------++-----+
//|Sno|   ITEM   ||Price|
//+---+----------++-----+
//| 1.|  coffee  :: 120 |
//| 2.| sandwich :: 150 |
//| 3.| Water    ::  60 |
//| 4.| Ends            |
//+---+----------++-----+
//Enter the choice
//0. Exit
//1. book a table
//2. Display menu
//3. Order coffee
//3
//Enter the table number
//12
//+---+----------++-----+
//|Sno|   ITEM   ||Price|
//+---+----------++-----+
//| 1.|  coffee  :: 120 |
//| 2.| sandwich :: 150 |
//| 3.| Water    ::  60 |
//| 4.| Ends            |
//+---+----------++-----+
//3
//Enter quantity
//1
//+---+----------++-----+
//|Sno|   ITEM   ||Price|
//+---+----------++-----+
//| 1.|  coffee  :: 120 |
//| 2.| sandwich :: 150 |
//| 3.| Water    ::  60 |
//| 4.| Ends            |
//+---+----------++-----+
//2
//Enter quantity
//1
//+---+----------++-----+
//|Sno|   ITEM   ||Price|
//+---+----------++-----+
//| 1.|  coffee  :: 120 |
//| 2.| sandwich :: 150 |
//| 3.| Water    ::  60 |
//| 4.| Ends            |
//+---+----------++-----+
//1
//Enter quantity
//3
//+---+----------++-----+
//|Sno|   ITEM   ||Price|
//+---+----------++-----+
//| 1.|  coffee  :: 120 |
//| 2.| sandwich :: 150 |
//| 3.| Water    ::  60 |
//| 4.| Ends            |
//+---+----------++-----+
//4
//-------------------------------------------------
//-----------------------------
//Your bill is :
//Bill no is :: 397
//+--------+-----------+-----+-------+
//|  Items | unitprice | Qty | total |
//+--------+-----------+-----+-------+
//|   water|      60   |  1  |    60 |
//|sandwich|     150   |  1  |   150 |
//|  coffee|     120   |  3  |  1080 |
//+--------+-----------+-----+-------+
//------------------------------------
//| your total bill is 570           |
//------------------------------------
//Enter the choice
//0. Exit
//1. book a table
//2. Display menu
//3. Order coffee
//0
//
//Process finished with exit code 0

//With Exceptions:

//Enter the choice
//0. Exit 
//1. book a table 
//2. Display menu 
//3. Order coffee
//2
//No reservation found exception
//please Book table first
//Enter the choice
//0. Exit 
//1. book a table 
//2. Display menu 
//3. Order coffee
//3
//No reservation found exception
//please Book table first
//Enter the choice
//0. Exit 
//1. book a table 
//2. Display menu 
//3. Order coffee
//1
//Please enter the number of persons
//7
//congration your seat is booked having max occupancy 8
//Enter the choice
//0. Exit 
//1. book a table 
//2. Display menu 
//3. Order coffee
//3
//Enter the table number
//12
//+---+----------++-----+
//|Sno|   ITEM   ||Price|
//+---+----------++-----+
//| 1.|  coffee  :: 120 |
//| 2.| sandwich :: 150 |
//| 3.| Water    ::  60 |
//| 4.| Ends            |
//+---+----------++-----+
//3
//Enter quantity
//1
//+---+----------++-----+
//|Sno|   ITEM   ||Price|
//+---+----------++-----+
//| 1.|  coffee  :: 120 |
//| 2.| sandwich :: 150 |
//| 3.| Water    ::  60 |
//| 4.| Ends            |
//+---+----------++-----+
//2
//Enter quantity
//1
//+---+----------++-----+
//|Sno|   ITEM   ||Price|
//+---+----------++-----+
//| 1.|  coffee  :: 120 |
//| 2.| sandwich :: 150 |
//| 3.| Water    ::  60 |
//| 4.| Ends            |
//+---+----------++-----+
//4
//InvalidOrderException
//You must have to add 1 coffee
//Enter the choice
//0. Exit 
//1. book a table 
//2. Display menu 
//3. Order coffee
//0
//
//Process finished with exit code 0
