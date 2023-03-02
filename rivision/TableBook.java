package assignment01march.rivision;

public class TableBook implements Runnable{

    static int tableFor2=8, tableFor4= 4, tableFor6= 2, tableFor8=2;
    int demand;
    TableBook(int demand){
        this.demand = demand;
    }
    public void run(){

    }
    void book(){
        boolean seat=false;
        if(demand<=2) {
            if (tableFor2 != 0) {
                tableFor2 -= 1;
                seat = true;
                System.out.println("congration your seat is booked having max occupancy "+2);
            }
        }
            if(demand<=4 && !seat){
                if(tableFor4 !=0){
                    tableFor4 -= 1;
                    seat = true;
                    System.out.println("congration your seat is booked having max occupancy "+4);
                }
            }
        if(demand<=6 && !seat){
            if(tableFor6 !=0){
                tableFor6 -= 1;
                seat = true;
                System.out.println("congration your seat is booked having max occupancy "+6);
            }
        }
        if(demand<=8 && !seat){
            if(tableFor8 !=0){
                tableFor8 -= 1;
                System.out.println("congration your seat is booked having max occupancy "+2);
            }
        }
        if(!seat){
            System.out.println("Sorry our cafe is full please wait for some time.");
        }
    }
}
