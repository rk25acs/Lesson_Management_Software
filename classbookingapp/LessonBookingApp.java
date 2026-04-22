package classbookingapp;

import java.util.*;

public class LessonBookingApp {

    public static void main(String[] args){
        
        Scanner scn = new Scanner(System.in);
        int id;

        System.out.println("WELCOME TO FLC APP!");

        Timetable timetable = new Timetable();
        timetable.TTData();
        
        BookingSystem booking = new BookingSystem(timetable);
        booking.AddedCustomers();


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

                    while (true) {
                        System.out.println("Enter your id:");
                        id = scn.nextInt();

                        if (id == 0){
                            System.out.println("Invalid ID!");
                        }
                        else if (id > booking.getcounter()){
                            System.out.println("ID does not exist!");
                            System.out.println("New Customer detected! Create new account (Y/N)?");
                            String choice = scn.next();
                            if (choice.equalsIgnoreCase("Y")) {
                                System.out.println("Please enter your name:");
                                String name = scn.next();
                                Customer newCustomer = new Customer(booking.getcounter() + 1, name);
                                booking.addCustomers(newCustomer);
                                System.out.println("Customer added successfully! Your ID is: " + newCustomer.getCustomerID());
                                break;
                            }
                        }
                        else {
                            System.out.println("ID found! Welcome," + booking.getCustomer(id).getCustomerName() + "!");
                            break;
                        }
                    }
                    System.out.println("Proceeding to booking...");
                    System.out.println("Display lessons by Day or Lesson Type?:");
                    String displayOption = scn.next();
                    if (displayOption.equalsIgnoreCase("Day")){
                        String day;
                        do {
                            System.out.println("Enter the day:");
                            day = scn.next();
                        } while (
                            !day.equalsIgnoreCase("Saturday") && !day.equalsIgnoreCase("Sunday"));
                        
                        for (Lessons lesson : timetable.getLessonsbyDay(day)) {
                            System.out.println("ID: " + lesson.getId() + ", Name: " + lesson.getName() + ", Week: " + lesson.getweek() + ", Slot: " + lesson.getSlot() + ", Price: " + lesson.getPrice());
                        }
                    }
                    else if (displayOption.equalsIgnoreCase("Lesson Type")){
                        System.out.println("Enter the lesson type:");
                        String lessonType = scn.next();
                        for (Lessons lesson : timetable.getLessonsbyName(lessonType)) {
                            System.out.println("ID: " + lesson.getId() + ", Name: " + lesson.getName() + ", Week: " + lesson.getweek() + ", Slot: " + lesson.getSlot() + ", Price: " + lesson.getPrice());
                        }
                    }
                    else {
                        System.out.println("Invalid input!");
                    }
                    System.out.println("Enter the Lesson ID:");
                    int lessonId = scn.nextInt();
                    booking.bookLesson(id, lessonId);

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