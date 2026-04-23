package classbookingapp;

import java.util.*;

public class LessonBookingApp {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int id;

        System.out.println("WELCOME TO FLC APP!");

        Timetable timetable = new Timetable();
        timetable.TTData();

        BookingSystem booking = new BookingSystem(timetable);
        booking.AddedCustomers();
        booking.AddedBookings();
        booking.AttendBookings();

        while (true) {
            System.out.println("MENU");
            System.out.println("1. Book a lesson");
            System.out.println("2. Change/Cancel a booking");
            System.out.println("3. Attend a lesson");
            System.out.println("4. Monthly report");
            System.out.println("5. Monthly champion lesson report");
            System.out.println("0. Exit");

            int option = scn.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Booking a lesson...");

                    while (true) {
                        System.out.println("Enter your id:");
                        id = scn.nextInt();

                        if (id == 0) {
                            System.out.println("Invalid ID!");
                        } else if (id > booking.getcounter()) {
                            System.out.println("ID does not exist!");
                            System.out.println("New Customer detected! Create new account (Y/N)?");
                            String choice = scn.next();
                            if (choice.equalsIgnoreCase("Y")) {
                                System.out.println("Please enter your name:");
                                String name = scn.next();
                                Customer newCustomer = new Customer(booking.getcounter() + 1, name);
                                booking.addCustomers(newCustomer);
                                System.out.println(
                                        "Customer added successfully! Your ID is: " + newCustomer.getCustomerID());
                                break;
                            }
                        } else {
                            System.out.println("ID found! Welcome," + booking.getCustomer(id).getCustomerName() + "!");
                            break;
                        }
                    }

                    System.out.println("Proceeding to booking...");
                    System.out.println("Display lessons by Day or Lesson Type?:");
                    String displayOption = scn.next();

                    if (displayOption.equalsIgnoreCase("Day")) {
                        String day;
                        do {
                            System.out.println("Enter the day:");
                            day = scn.next();
                        } while (!day.equalsIgnoreCase("Saturday") && !day.equalsIgnoreCase("Sunday"));

                        for (Lessons lesson : timetable.getLessonsbyDay(day)) {
                            System.out.println("ID: " + lesson.getId() + ", Name: " + lesson.getName() + ", Week: "
                                    + lesson.getweek() + ", Slot: " + lesson.getSlot() + ", Price: "
                                    + lesson.getPrice());
                        }
                    } else if (displayOption.equalsIgnoreCase("Lesson Type")) {
                        String lessonType;
                        do {
                            System.out.println("Enter the lesson type:");
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

                    System.out.println("Enter the Lesson ID:");
                    int lessonId = scn.nextInt();
                    booking.bookLesson(id, lessonId);

                    break;
                case 2:
                    System.out.println("Changing/Canceling a booking...");
                    while (true) {
                        System.out.println("Enter your id:");
                        id = scn.nextInt();

                        if (id == 0) {
                            System.out.println("Invalid ID!");
                        } else if (id > booking.getcounter()) {
                            System.out.println("ID does not exist!");
                        } else {
                            System.out.println("ID found! Welcome," + booking.getCustomer(id).getCustomerName() + "!");
                            break;
                        }
                    }
                    booking.getCustomer(id).getBookedLessons().forEach(bookedLesson -> {
                        System.out.println("Lesson ID: " + bookedLesson.lesson.getId() + ", Lesson Name: "
                                + bookedLesson.lesson.getName() + ", Status: " + bookedLesson.getStatus());
                    });
                    System.out.println("Enter the Lesson ID you want to change/cancel:");
                    int changeLessonId = scn.nextInt();
                    System.out.println("Do you want to Cancel (C) or Change (CH) the booking?");
                    String changeOption = scn.next();
                    if (changeOption.equalsIgnoreCase("C")) {
                        booking.cancelBooking(id, changeLessonId);
                    } else if (changeOption.equalsIgnoreCase("CH")) {
                        booking.cancelBooking(id, changeLessonId);
                        System.out.println("Display lessons by Day or Lesson Type?:");
                        String displayOpt = scn.next();

                        if (displayOpt.equalsIgnoreCase("Day")) {
                            String day;
                            do {
                                System.out.println("Enter the day:");
                                day = scn.next();
                            } while (!day.equalsIgnoreCase("Saturday") && !day.equalsIgnoreCase("Sunday"));

                            for (Lessons lesson : timetable.getLessonsbyDay(day)) {
                                System.out.println("ID: " + lesson.getId() + ", Name: " + lesson.getName() + ", Week: "
                                        + lesson.getweek() + ", Slot: " + lesson.getSlot() + ", Price: "
                                        + lesson.getPrice());
                            }
                        } else if (displayOpt.equalsIgnoreCase("Lesson Type")) {
                            String lessonType;
                            do {
                                System.out.println("Enter the lesson type:");
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

                        System.out.println("Enter the Lesson ID:");
                        int lId = scn.nextInt();
                        booking.bookLesson(id, lId);

                        break;
                    } else {
                        System.out.println("Invalid input!");
                    }
                    break;
                case 3:
                    System.out.println("Attending a lesson...");
                    while (true) {
                        System.out.println("Enter your id:");
                        id = scn.nextInt();

                        if (id == 0) {
                            System.out.println("Invalid ID!");
                        } else if (id > booking.getcounter()) {
                            System.out.println("ID does not exist!");
                        } else {
                            System.out.println("ID found! Welcome," + booking.getCustomer(id).getCustomerName() + "!");
                            break;
                        }
                    }
                    booking.getCustomer(id).getBookedLessons().forEach(bookedLesson -> {
                        System.out.println("Lesson ID: " + bookedLesson.lesson.getId() + ", Lesson Name: "
                                + bookedLesson.lesson.getName() + ", Status: " + bookedLesson.getStatus());
                    });
                    System.out.println("Enter the Lesson ID you want to attend:");
                    int attendLessonId = scn.nextInt();
                    booking.attendLesson(id, attendLessonId);

                    System.out.println("Enter your review:");
                    String review = scn.next();
                    booking.giveReview(id, attendLessonId, review);

                    while (true) {
                        System.out.println("Enter your rating (0.0 - 5.0):");
                        float rating = scn.nextFloat();
                        if (rating >= 0.0 && rating <= 5.0) {
                            booking.giveRating(id, attendLessonId, rating);
                            break;
                        } else {
                            System.out.println("Invalid rating! Rating should be between 0.0 and 5.0.");
                        }
                    }

                    break;
                case 4:
                    System.out.println("Generating report of past 4 weeks...");
                    for (Lessons lesson : timetable.getLessons()) {
                        if (lesson.getweek() < timetable.getCurrentWeek()) {
                            System.out.println("Week " + lesson.getweek() + ",   " + lesson.getDay() + 
                            ",   " + lesson.getName() + ",   Rating: " + lesson.getRating() + ",   Attendance: " + lesson.getAttendees());
                        }
                    }

                    break;
                case 5:
                    System.out.println("Viewing average ratings for the past 4 weeks...");
                    float[] ratings = new float[timetable.getlessontypes().length];
                    float[] attendance = new float[timetable.getlessontypes().length];
                    for (int i = 0; i < timetable.getlessontypes().length; i++) {
                        String type = timetable.getlessontypes()[i];
                        ratings[i] = booking.getAvgRating(timetable, type);
                        attendance[i] = booking.getAttendance(timetable, type);
                    }
                     System.out.println("\n--- Monthly Report ---");
                    for (int i = 0; i < timetable.getlessontypes().length; i++) {
                        System.out.println("Lesson Type: " + timetable.getlessontypes()[i] + ", Average Rating: " + ratings[i] + ", Total Attendance: " + attendance[i]);
                    }

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