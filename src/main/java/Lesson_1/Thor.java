package main.java.Lesson_1;

public class Thor extends Team implements CanRun {
//    public static String name = "Тор";
//    public static String view = "асгардец";
//    public static int age = 59;

    Thor(String name, String view, int age, int runningSpeed) {
        super(name, view, age, runningSpeed);
    }

    public int getRunningSpeed() {
        return runningSpeed;
    }

    public void setRunningSpeed(int runningSpeed) {
        this.runningSpeed = runningSpeed;
    }

    public double run(Course course) {
        System.out.println("Я Тор, я лечу!");
        System.out.println("Затратил " + course.getLength() / runningSpeed);
        return course.getLength() / runningSpeed;
    }

    public String toString() {
        return "Имя " + name + '\'' +
                ", Вид " + view + '\'' +
                ", Возраст " + age + ""
                ;
    }
}
