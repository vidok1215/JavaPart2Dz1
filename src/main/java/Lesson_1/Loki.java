package main.java.Lesson_1;

public class Loki extends Team implements CanRun {
//    public static String name = "Локи";
//    public static String view = "ётун (ледяной великан)";
//    public static int age = 72;

    Loki(String name, String view, int age, int runningSpeed) {
        super(name, view, age, runningSpeed);
    }

    public int getRunningSpeed() {
        return runningSpeed;
    }

    public void setRunningSpeed(int runningSpeed) {
        this.runningSpeed = runningSpeed;
    }

    public double run(Course course) {
        System.out.println("Я Локи, я бегу!");
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
