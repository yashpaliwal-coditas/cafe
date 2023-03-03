package assignment01march.rivision;

import java.util.Scanner;

public class CafeExecution extends Thread {
    public void run(){
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        CafeManagement persor1 = new CafeManagement();
        boolean bookingStatus=false;
        while (flag){
            System.out.println("Enter the choice\n0. Exit \n1. book a table \n 2. Display menu \n3. Order coffee");
            int choice = scanner.nextInt();
            switch (choice){
                case 0: flag=false;
                    break;
                case 1: sychronised(person1){
                    bookingStatus=persor1.booking();
                }
                    break;
                case 2: try{
                    if(!bookingStatus){
                        throw new ReservationException();
                    }
                    persor1.display();
                }
                catch (ReservationException e){
                    System.out.println("please Book table first");
                }

                    break;
                case 3: if(bookingStatus){
                    try{
                        if(!bookingStatus) {
                            throw new ReservationException();
                        }
                        persor1.order();
                    }
                    catch (ReservationException e){
                        System.out.println("please Book table first");
                    }
                }
                    break;
                default:
                    System.out.println("You have entered wrong choice");
            }
        }
    }
    public static void main(String[] args) {
       CafeExecution cafeExecution = new CafeExecution();
       cafeExecution.start();
    }
}
