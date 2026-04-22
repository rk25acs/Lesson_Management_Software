package classbookingapp;
import java.util.*;


public class Timetable {
    public int id = 1;
    public String[] slot = {"8:00-9:00", "01:00-02:00", "06:00-07:00"};
    public List<Lessons> lessons = new ArrayList<Lessons>();

    public void addLesson(Lessons lesson) {
        lessons.add(lesson);
    }
    public void removeLesson(Lessons lesson) {
        lessons.remove(lesson);
    }
    public List<Lessons> getLessons() {
        return lessons;
    }
    public void TTData(){

        //Month 1
        //Week 1
        addLesson(new Lessons(id++, "Yoga", "Saturday", 1, slot[0], 15));
        addLesson(new Lessons(id++, "Zumba", "Saturday", 1, slot[1], 20));
        addLesson(new Lessons(id++, "Pilates", "Saturday", 1, slot[2],15));

        addLesson(new Lessons(id++, "Aquacise", "Sunday", 2, slot[0], 25));
        addLesson(new Lessons(id++, "Box Fit", "Sunday", 2, slot[1], 20));
        addLesson(new Lessons(id++, "Body Blitz", "Sunday", 2, slot[2],10));

        //Week 2

        addLesson(new Lessons(id++, "Yoga", "Saturday", 2, slot[0], 15));
        addLesson(new Lessons(id++, "Zumba", "Saturday", 2, slot[1], 20));
        addLesson(new Lessons(id++, "Pilates", "Saturday", 2, slot[2],15));

        addLesson(new Lessons(id++, "Aquacise", "Sunday", 2, slot[0], 25));
        addLesson(new Lessons(id++, "Box Fit", "Sunday", 2, slot[1], 20));
        addLesson(new Lessons(id++, "Body Blitz", "Sunday", 2,slot[2],10));

        //Week 3

        addLesson(new Lessons(id++,"Yoga", "Saturday", 3, slot[0], 15));
        addLesson(new Lessons(id++,"Zumba", "Saturday", 3, slot[1], 20));
        addLesson(new Lessons(id++,"Pilates", "Saturday", 3, slot[2],15));

        addLesson(new Lessons(id++, "Aquacise", "Sunday", 4, slot[0], 25));
        addLesson(new Lessons(id++, "Box Fit", "Sunday", 4, slot[1], 20));
        addLesson(new Lessons(id++, "Body Blitz", "Sunday", 4, slot[2],10));

        //Week 4

        addLesson(new Lessons(id++, "Yoga", "Saturday", 4, slot[0], 15));
        addLesson(new Lessons(id++, "Zumba", "Saturday", 4, slot[1], 20));
        addLesson(new Lessons(id++, "Pilates", "Saturday", 4, slot[2],15));

        addLesson(new Lessons(id++, "Aquacise", "Sunday", 4, slot[0], 25));
        addLesson(new Lessons(id++, "Box Fit", "Sunday", 4, slot[1], 20));
        addLesson(new Lessons(id++, "Body Blitz", "Sunday", 4, slot[2],10));

        //Week 5

        addLesson(new Lessons(id++, "Yoga", "Saturday", 5, slot[0], 15));
        addLesson(new Lessons(id++, "Box Fit", "Saturday", 5, slot[1], 20));
        addLesson(new Lessons(id++, "Body Blitz", "Saturday", 5, slot[2],15));

        addLesson(new Lessons(id++, "Aquacise", "Sunday", 5, slot[0], 25));
        addLesson(new Lessons(id++, "Box Fit", "Sunday", 5, slot[1], 20));
        addLesson(new Lessons(id++, "Body Blitz", "Sunday", 5, slot[2],10));

        //Month 2
        //Week 1
        addLesson(new Lessons(id++, "Yoga", "Saturday", 6, slot[0], 15));
        addLesson(new Lessons(id++, "Zumba", "Saturday", 6, slot[1], 20));
        addLesson(new Lessons(id++, "Pilates", "Saturday", 6, slot[2],15));

        addLesson(new Lessons(id++, "Aquacise", "Sunday", 7, slot[0], 25));
        addLesson(new Lessons(id++, "Box Fit", "Sunday", 7, slot[1], 20));
        addLesson(new Lessons(id++, "Body Blitz", "Sunday", 7, slot[2],10));
        //Week 2
        addLesson(new Lessons(id++, "Yoga", "Saturday", 8, slot[0], 15));
        addLesson(new Lessons(id++, "Zumba", "Saturday", 8, slot[1], 20));
        addLesson(new Lessons(id++, "Pilates", "Saturday", 8, slot[2],15));

        addLesson(new Lessons(id++, "Aquacise", "Sunday", 9, slot[0], 25));
        addLesson(new Lessons(id++, "Box Fit", "Sunday", 9, slot[1], 20));
        addLesson(new Lessons(id++, "Body Blitz", "Sunday", 9, slot[2],10));
        //Week 3
        addLesson(new Lessons(id++, "Yoga", "Saturday", 10, slot[0], 15));
        addLesson(new Lessons(id++, "Zumba", "Saturday", 10, slot[1], 20));
        addLesson(new Lessons(id++, "Pilates", "Saturday", 10, slot[2],15));

        addLesson(new Lessons(id++, "Aquacise", "Sunday", 11, slot[0], 25));
        addLesson(new Lessons(id++, "Box Fit", "Sunday", 11, slot[1], 20));
        addLesson(new Lessons(id++, "Body Blitz", "Sunday", 11, slot[2],10));
        //Week 4
        addLesson(new Lessons(id++, "Yoga", "Saturday", 12, slot[0], 15));
        addLesson(new Lessons(id++, "Zumba", "Saturday", 12, slot[1], 20));
        addLesson(new Lessons(id++, "Pilates", "Saturday", 12, slot[2],15));

        addLesson(new Lessons(id++, "Aquacise", "Sunday", 13, slot[0], 25));
        addLesson(new Lessons(id++, "Box Fit", "Sunday", 13, slot[1], 20));
        addLesson(new Lessons(id++, "Body Blitz", "Sunday", 13, slot[2],10));
    }

    public List<Lessons> getLessonsbyDay(String day){
        List<Lessons> lessonsByDay = new ArrayList<>();
        for (Lessons l : lessons) {
            if (l.getDay().equalsIgnoreCase(day)) {
                lessonsByDay.add(l);
            }
        }
        return lessonsByDay;
    }
    public List<Lessons> getLessonsbyName(String name){
        List<Lessons> lessonsByName = new ArrayList<>();
        for (Lessons l : lessons) {
            if (l.getName().equalsIgnoreCase(name)) {
                lessonsByName.add(l);
            }
        }
        return lessonsByName;
    }
    public void displayLessons(List<Lessons> lessons) {
        System.out.println("\n--- Available Lessons ---");
        for (Lessons l : lessons) {
            System.out.println(
                "ID: " + l.getId() +
                " | Name: " + l.getName() +
                " | Day: " + l.getDay() +
                " | Week: " + l.getweek() +
                " | Slot: " + l.getSlot() +
                " | Price: " + l.getPrice()
            );
        }
    }
}
