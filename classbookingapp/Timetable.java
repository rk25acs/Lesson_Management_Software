package classbookingapp;
import java.util.*;


public class Timetable {
    public int id = 1;
    public String[] slot = {"8:00-9:00", "01:00-02:00", "06:00-07:00"};
    public String[] ltype = {"Yoga", "Zumba", "Pilates", "Aquacise", "Box Fit", "Body Blitz"};
    public List<Lessons> lessons = new ArrayList<Lessons>();
    private int currentweek = 5;

    public void addLesson(Lessons lesson) {
        lessons.add(lesson);
    }
    public int getCurrentWeek() {
        return currentweek;
    }
    public void removeLesson(Lessons lesson) {
        lessons.remove(lesson);
    }
    public List<Lessons> getLessons() {
        return lessons;
    }
    public String[] getlessontypes(){
        return ltype;
    }
    public void TTData(){

        //Month 1
        //Week 1
        addLesson(new Lessons(id++, ltype[0], "Saturday", 1, slot[0], 15));
        addLesson(new Lessons(id++, ltype[1], "Saturday", 1, slot[1], 20));
        addLesson(new Lessons(id++, ltype[2], "Saturday", 1, slot[2],15));

        addLesson(new Lessons(id++, ltype[3], "Sunday", 1, slot[0], 25));
        addLesson(new Lessons(id++, ltype[4], "Sunday", 1, slot[1], 20));
        addLesson(new Lessons(id++, ltype[5], "Sunday", 1, slot[2],10));

        //Week 2

        addLesson(new Lessons(id++, ltype[0], "Saturday", 2, slot[0], 15));
        addLesson(new Lessons(id++, ltype[1], "Saturday", 2, slot[1], 20));
        addLesson(new Lessons(id++, ltype[2], "Saturday", 2, slot[2],15));

        addLesson(new Lessons(id++, ltype[3], "Sunday", 2, slot[0], 25));
        addLesson(new Lessons(id++, ltype[4], "Sunday", 2, slot[1], 20));
        addLesson(new Lessons(id++, ltype[5], "Sunday", 2,slot[2],10));

        //Week 3

        addLesson(new Lessons(id++,ltype[0], "Saturday", 3, slot[0], 15));
        addLesson(new Lessons(id++,ltype[1], "Saturday", 3, slot[1], 20));
        addLesson(new Lessons(id++,ltype[2], "Saturday", 3, slot[2],15));

        addLesson(new Lessons(id++, ltype[3], "Sunday", 3, slot[0], 25));
        addLesson(new Lessons(id++, ltype[4], "Sunday", 3, slot[1], 20));
        addLesson(new Lessons(id++, ltype[5], "Sunday", 3, slot[2],10));

        //Week 4

        addLesson(new Lessons(id++, ltype[0], "Saturday", 4, slot[0], 15));
        addLesson(new Lessons(id++, ltype[1], "Saturday", 4, slot[1], 20));
        addLesson(new Lessons(id++, ltype[2], "Saturday", 4, slot[2],15));

        addLesson(new Lessons(id++, ltype[3], "Sunday", 4, slot[0], 25));
        addLesson(new Lessons(id++, ltype[4], "Sunday", 4, slot[1], 20));
        addLesson(new Lessons(id++, ltype[5], "Sunday", 4, slot[2],10));

        //Week 5

        addLesson(new Lessons(id++, ltype[0], "Saturday", 5, slot[0], 15));
        addLesson(new Lessons(id++, ltype[1], "Saturday", 5, slot[1], 20));
        addLesson(new Lessons(id++, ltype[2], "Saturday", 5, slot[2],15));

        addLesson(new Lessons(id++, ltype[3], "Sunday", 5, slot[0], 25));
        addLesson(new Lessons(id++, ltype[4], "Sunday", 5, slot[1], 20));
        addLesson(new Lessons(id++, ltype[5], "Sunday", 5, slot[2],10));

        //Month 2
        //Week 1
        addLesson(new Lessons(id++, ltype[0], "Saturday", 6, slot[0], 15));
        addLesson(new Lessons(id++, ltype[1], "Saturday", 6, slot[1], 20));
        addLesson(new Lessons(id++, ltype[2], "Saturday", 6, slot[2],15));

        addLesson(new Lessons(id++, ltype[3], "Sunday", 6, slot[0], 25));
        addLesson(new Lessons(id++, ltype[4], "Sunday", 6, slot[1], 20));
        addLesson(new Lessons(id++, ltype[5], "Sunday", 6, slot[2],10));
        //Week 2
        addLesson(new Lessons(id++, ltype[0], "Saturday", 7, slot[0], 15));
        addLesson(new Lessons(id++, ltype[1], "Saturday", 7, slot[1], 20));
        addLesson(new Lessons(id++, ltype[2], "Saturday", 7, slot[2],15));

        addLesson(new Lessons(id++, ltype[3], "Sunday", 7, slot[0], 25));
        addLesson(new Lessons(id++, ltype[4], "Sunday", 7, slot[1], 20));
        addLesson(new Lessons(id++, ltype[5], "Sunday", 7, slot[2],10));
        //Week 3
        addLesson(new Lessons(id++, ltype[0], "Saturday", 8, slot[0], 15));
        addLesson(new Lessons(id++, ltype[1], "Saturday", 8, slot[1], 20));
        addLesson(new Lessons(id++, ltype[2], "Saturday", 8, slot[2],15));

        addLesson(new Lessons(id++, ltype[3], "Sunday", 8, slot[0], 25));
        addLesson(new Lessons(id++, ltype[4], "Sunday", 8, slot[1], 20));
        addLesson(new Lessons(id++, ltype[5], "Sunday", 8, slot[2],10));
        //Week 4
        addLesson(new Lessons(id++, ltype[0], "Saturday", 9, slot[0], 15));
        addLesson(new Lessons(id++, ltype[1], "Saturday", 9, slot[1], 20));
        addLesson(new Lessons(id++, ltype[2], "Saturday", 9, slot[2],15));

        addLesson(new Lessons(id++, ltype[3], "Sunday", 9, slot[0], 25));
        addLesson(new Lessons(id++, ltype[4], "Sunday", 9, slot[1], 20));
        addLesson(new Lessons(id++, ltype[5], "Sunday", 9, slot[2],10));
    }

    public List<Lessons> getLessonsbyDay(String day){
        List<Lessons> lessonsByDay = new ArrayList<>();
        for (Lessons l : lessons) {
            if (l.getDay().equalsIgnoreCase(day) && l.getweek() >= currentweek) {
                lessonsByDay.add(l);
            }
        }
        return lessonsByDay;
    }
    public List<Lessons> getLessonsbyName(String name){
        List<Lessons> lessonsByName = new ArrayList<>();
        for (Lessons l : lessons) {
            if (l.getName().equalsIgnoreCase(name) && l.getweek() >= currentweek) {
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
