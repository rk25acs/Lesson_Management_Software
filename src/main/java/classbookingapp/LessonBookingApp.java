package classbookingapp;

import java.util.*;

public class LessonBookingApp {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int id;

        Timetable timetable = new Timetable();

        // Adding Lessons to Timetable
        timetable.TTData();

        BookingSystem booking = new BookingSystem(timetable);

        // Adding Customers, booking a few classes and updating the status
        booking.AddedCustomers();
        booking.AddedBookings();
        booking.AttendBookings();

        // Clearing out the terminal
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("WELCOME TO FLC APP!");

        while (true) {

            // Main menu
            System.out.println("\n");
            System.out.println(" - MENU - \n");
            System.out.println("1. Book a lesson");
            System.out.println("2. Change/Cancel a booking");
            System.out.println("3. Attend a lesson");
            System.out.println("4. Monthly report");
            System.out.println("5. Monthly champion lesson report");
            System.out.println("0. Exit\n");

            System.out.print("What would you like to do? : ");
            int option = scn.nextInt();

            switch (option) {
                case 1:
                    // Book a Lesson
                    System.out.println("Booking a lesson...");

                    while (true) {
                        System.out.print("Enter your id : ");
                        id = scn.nextInt();

                        if (id == 0) {
                            System.out.println("Invalid ID!");
                        } else if (id > booking.getcounter()) {

                            System.out.println("ID does not exist!");
                            System.out.print("New Customer detected! Create new account (Y/N)? ");
                            String choice = scn.next();

                            if (choice.equalsIgnoreCase("Y")) {
                                System.out.print("Please enter your name : ");
                                String name = scn.next();
                                Customer newCustomer = new Customer(booking.getcounter() + 1, name);
                                booking.addCustomers(newCustomer);
                                System.out.println(
                                        "Customer added successfully! Your ID is: " + newCustomer.getCustomerID());
                                break;
                            }
                        } else {
                            System.out
                                    .println("\nID found! Welcome," + booking.getCustomer(id).getCustomerName() + "!");
                            break;
                        }
                    }

                    System.out.println("\nProceeding to booking...");
                    System.out.print("Display lessons by Day or Lesson? : ");
                    String displayOption = scn.next();

                    if (displayOption.equalsIgnoreCase("Day")) {
                        String day;
                        do {
                            System.out.print("Enter the day (Saturday / Sunday) : ");
                            day = scn.next();
                        } while (!day.equalsIgnoreCase("Saturday") && !day.equalsIgnoreCase("Sunday"));

                        for (Lessons lesson : timetable.getLessonsbyDay(day)) {
                            System.out.println("ID: " + lesson.getId() + ", Name: " + lesson.getName() + ", Week: "
                                    + lesson.getweek() + ", Slot:   " + lesson.getSlot() + ",   Price: "
                                    + lesson.getPrice());
                        }
                    } else if (displayOption.equalsIgnoreCase("Lesson")) {
                        String lessonType;
                        do {
                            System.out.println("Available lessons : ");
                            for (String type : timetable.getlessontypes()) {
                                System.out.print(type + " | ");
                            }
                            System.out.print("\nEnter the lesson : ");
                            lessonType = scn.next();
                        } while (lessonType.isEmpty());
                        for (Lessons lesson : timetable.getLessonsbyName(lessonType)) {
                            System.out.println("ID: " + lesson.getId() + ", Name: " + lesson.getName() + ", Week: "
                                    + lesson.getweek() + ", Slot: " + lesson.getSlot() + ", Price: "
                                    + lesson.getPrice());
                        }
                    } else {
                        System.out.println("Invalid input!");
                    }

                    System.out.print("Enter the Lesson ID: ");
                    int lessonId = scn.nextInt();
                    booking.bookLesson(id, lessonId);

                    break;
                case 2:

                    // Change or Cancel a booked Lesson
                    System.out.println("Changing/Canceling a booking...");
                    while (true) {
                        System.out.print("Enter your id: ");
                        id = scn.nextInt();

                        if (id == 0) {
                            System.out.println("Invalid ID!");
                        } else if (id > booking.getcounter()) {
                            System.out.println("ID does not exist!");
                        } else {
                            System.out
                                    .println("\nID found! Welcome," + booking.getCustomer(id).getCustomerName() + "!");
                            break;
                        }
                    }
                    booking.getCustomer(id).getBookedLessons().forEach(bookedLesson -> {
                        System.out.println("Lesson ID: " + bookedLesson.lesson.getId() + ", Lesson Name: "
                                + bookedLesson.lesson.getName() + ", Status: " + bookedLesson.getStatus());
                    });
                    System.out.print("Enter the Lesson ID you want to change/cancel : ");
                    int changeLessonId = scn.nextInt();
                    System.out.print("Do you want to Cancel (C) or Change (CH) the booking? ");
                    String changeOption = scn.next();
                    if (changeOption.equalsIgnoreCase("C")) {
                        booking.cancelBooking(id, changeLessonId);
                    } else if (changeOption.equalsIgnoreCase("CH")) {
                        int result = booking.cancelBooking(id, changeLessonId);

                        if (result == 1) {
                            System.out.print("Display lessons by Day or Lesson Type? : ");
                            String displayOpt = scn.next();

                            if (displayOpt.equalsIgnoreCase("Day")) {
                                String day;
                                do {
                                    System.out.print("Enter the day (Saturday / Sunday) : ");
                                    day = scn.next();
                                } while (!day.equalsIgnoreCase("Saturday") && !day.equalsIgnoreCase("Sunday"));

                                for (Lessons lesson : timetable.getLessonsbyDay(day)) {
                                    System.out.println(
                                            "ID: " + lesson.getId() + ", Name: " + lesson.getName() + ", Week: "
                                                    + lesson.getweek() + ",   Slot: " + lesson.getSlot() + ",   Price: "
                                                    + lesson.getPrice());
                                }
                            } else if (displayOpt.equalsIgnoreCase("Lesson")) {
                                String lessonType;
                                do {
                                    System.out.println("Available lessons : ");
                                    for (String type : timetable.getlessontypes()) {
                                        System.out.print(type + " | ");
                                    }
                                    System.out.print("Enter the lesson type : ");
                                    lessonType = scn.next();
                                } while (lessonType.isEmpty());
                                for (Lessons lesson : timetable.getLessonsbyName(lessonType)) {
                                    System.out.println(
                                            "ID: " + lesson.getId() + ", Name: " + lesson.getName() + ", Week: "
                                                    + lesson.getweek() + ", Slot: " + lesson.getSlot() + ", Price: "
                                                    + lesson.getPrice());
                                }
                            } else {
                                System.out.println("Invalid input!");
                            }

                            System.out.print("Enter the Lesson ID : ");
                            int lId = scn.nextInt();
                            booking.bookLesson(id, lId);

                            break;
                        }
                    } else {
                        System.out.println("Invalid input!");
                    }
                    break;
                case 3:

                    // Attending a booked Lesson
                    System.out.println("Attending a lesson...");
                    while (true) {
                        System.out.print("Enter your id : ");
                        id = scn.nextInt();

                        if (id == 0) {
                            System.out.println("Invalid ID!");
                        } else if (id > booking.getcounter()) {
                            System.out.println("ID does not exist!");
                        } else {
                            System.out.println(
                                    "\nID found! Welcome," + booking.getCustomer(id).getCustomerName() + "!\n");
                            break;
                        }
                    }
                    booking.getCustomer(id).getBookedLessons().forEach(bookedLesson -> {
                        System.out.println("Lesson ID: " + bookedLesson.lesson.getId() + ", Lesson Name: "
                                + bookedLesson.lesson.getName() + ", Status: " + bookedLesson.getStatus());
                    });
                    System.out.print("Enter the Lesson ID you want to attend : ");
                    int attendLessonId = scn.nextInt();
                    int result = booking.attendLesson(id, attendLessonId);

                    if (result == 0) {
                        System.out.print("Enter your review : ");
                        String review = scn.next();
                        booking.giveReview(id, attendLessonId, review);

                        while (true) {
                            System.out.print("Enter your rating (0.0 - 5.0) : ");
                            float rating = scn.nextFloat();
                            if (rating >= 0.0 && rating <= 5.0) {
                                booking.giveRating(id, attendLessonId, rating);
                                break;
                            } else {
                                System.out.println("Invalid rating! Rating should be between 0.0 and 5.0.");
                            }
                        }
                    }

                    break;
                case 4:

                    // Printing out the monthly attendance and rating sheet
                    System.out.println("Generating report of past 4 weeks...\n");
                    for (Lessons lesson : timetable.getLessons()) {
                        if (lesson.getweek() < timetable.getCurrentWeek()) {
                            System.out.println("Week " + lesson.getweek() + ",   " + lesson.getDay() +
                                    ",   " + lesson.getName() + ",   Rating: " + lesson.getAvgRating() +
                                    ",   Attendance: " + booking.getAttendance(lesson));
                        }
                    }

                    break;
                case 5:

                    // Printing out the monthly income report
                    System.out.println("Viewing Champion Report for the past 4 weeks...\n");
                    float[] Income = new float[timetable.getlessontypes().length];
                    int i = 0;
                    for (String type : timetable.getlessontypes()) {
                        Income[i] = booking.getTotalIncome(type);
                        i++;
                    }

                    String[] lessonTypes = timetable.getlessontypes();

                    for (int j = 0; j < lessonTypes.length - 1; j++) {
                        for (int k = 0; k < lessonTypes.length - j - 1; k++) {
                            if (Income[k] < Income[k + 1]) {
                                float tempIncome = Income[k];
                                Income[k] = Income[k + 1];
                                Income[k + 1] = tempIncome;

                                String tempType = lessonTypes[k];
                                lessonTypes[k] = lessonTypes[k + 1];
                                lessonTypes[k + 1] = tempType;
                            }
                        }
                    }
                    for (int j = 0; j < lessonTypes.length; j++) {
                        System.out.println((j + 1) + ". " + lessonTypes[j] + " - Total Income: " + Income[j]);
                    }
                    break;
                case 0:
                    // Exit
                    scn.close();
                    return;
                default:
                    System.out.println("Invalid Input!");
            }
        }
    }
}