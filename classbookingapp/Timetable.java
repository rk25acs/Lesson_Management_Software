package classbookingapp;
import java.util.*;


public class Timetable {
    public int id = 0;
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
        addLesson(new Lessons(id++, "Yoga", 1, slot[0], 15));
        addLesson(new Lessons(id++, "Zumba", 1, slot[1], 20));
        addLesson(new Lessons(id++, "Pilates", 1, slot[2],15));

        addLesson(new Lessons(id++, "Yoga", 2, slot[0], 15));
        addLesson(new Lessons(id++, "Zumba", 2, slot[1], 20));
        addLesson(new Lessons(id++, "Pilates", 2, slot[2],15));

        addLesson(new Lessons(id++, "Yoga", 8, slot[0], 15));
        addLesson(new Lessons(id++, "Zumba", 8, slot[1], 20));
        addLesson(new Lessons(id++, "Pilates", 8, slot[2],15));

        addLesson(new Lessons(id++, "Yoga", 9, slot[0], 15));
        addLesson(new Lessons(id++, "Zumba", 9, slot[1], 20));
        addLesson(new Lessons(id++, "Pilates", 9, slot[2],15));

        addLesson(new Lessons(id++,"Yoga", 15, slot[0], 15));
        addLesson(new Lessons(id++,"Zumba", 15, slot[1], 20));
        addLesson(new Lessons(id++,"Pilates", 15, slot[2],15));
    }
    public static void main(String[] args) {
        Timetable timetable = new Timetable();
        timetable.TTData();
        for (Lessons lesson : timetable.getLessons()) {
            lesson.getLesson();
        }
    }
}
