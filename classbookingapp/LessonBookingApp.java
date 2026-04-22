package classbookingapp;

import java.util.*;

public class LessonBookingApp {

    public static void main(String[] args){
        
        Scanner scn = new Scanner(System.in);

        System.out.println("WELCOME TO FLC APP!");

        Timetable timetable = new Timetable();


        while (true) {
            System.out.println("MENU");
            System.out.println("1. Book a lesson");
            System.out.println("2. Change/Cancel a booking");
            System.out.println("3. Attend a lesson");
            System.out.println("4. Monthly report");
            System.out.println("5. Monthly champion lesson report");
            System.out.println("0. Exit");

            int option = scn.nextInt();

            switch(option) {
                case 1:
                    System.out.println("Booking a lesson...");

                    System.out.println("Enter your id:");
                    
                    int id = scn.nextInt();
                    System.out.println("Enter your name:");
                    String name = scn.next();
                    if (id == 0){
                        System.out.println("Invalid ID!");
                        break;
                    }
                    if (name.isEmpty()){
                        System.out.println("Invalid Name!");
                        break;
                    }
                    Customer customer = new Customer();
                    customer.setCname(name);

                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 0:
                    scn.close();
                    return;
                default:
                    System.out.println("Invalid Input!");
            }
        }
    }
}