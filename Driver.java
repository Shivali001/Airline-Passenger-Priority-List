

import java.util.Scanner;

public class Driver {
    /**
     * The main method executes the driver program for Part B.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        HeapPriorityQueue<Passenger, String> standbyList = new HeapPriorityQueue<>(new PassengerComparator());

        // Adding passengers to the standby list
        for (int i = 0; i < 10; i++) {
            System.out.println("Enter passport no of new passenger:");
            String ppnum = kb.next();
            Passenger p = new Passenger(ppnum);
            standbyList.insert(p, ppnum);
            System.out.println("Adding Passenger: " + p);
            System.out.println("Standby list: " + standbyList);
        }

        // Seating passengers from the standby list
        for (int i = 0; i < 5; i++) {
            System.out.println("Passenger " + standbyList.min() + " gets seated.");
            standbyList.removeMin();
            System.out.println("Standby list: " + standbyList);
        }

        // Adding more passengers to the standby list
        for (int i = 0; i < 5; i++) {
            System.out.println("Enter passport no of new passenger:");
            String ppnum = kb.next();
            Passenger p = new Passenger(ppnum);
            standbyList.insert(p, ppnum);
            System.out.println("Adding Passenger: " + p);
            System.out.println("Standby list: " + standbyList);
        }

        // Seating remaining passengers from the standby list
        while (!(standbyList.isEmpty())) {
            System.out.println("Passenger " + standbyList.min() + " gets seated.");
            standbyList.removeMin();
            System.out.println("Standby list: " + standbyList);
        }
    }
}
