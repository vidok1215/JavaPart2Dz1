package main.java.Lesson_1;

public class Hulk extends Team implements CanRun {

//    public static String name = "Халк";
//    public static String view = "гамма-мутант";
//    public static int age = 39;
//    public static int runningSpeed = 5;

    Hulk(String name, String view, int age, int runningSpeed) {
        super(name, view, age, runningSpeed);
    }

    public int getRunningSpeed() {
        return runningSpeed;
    }

    public void setRunningSpeed(int runningSpeed) {
        this.runningSpeed = runningSpeed;
    }

    public double run(Course course) {
        System.out.println("Я Халк, я бегу!");
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
