package main.java.Lesson_1;

public class Course {

    private double length;

    public Course(int length) {
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public double getTimeToOvercomeCourse(CanRun runner) {
        return runner.run(this);
    }
}
