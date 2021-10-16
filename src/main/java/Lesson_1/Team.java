package main.java.Lesson_1;

public class Team {

 protected String name;
 protected String view;
 protected int age;
 protected int runningSpeed;


 public static void teamName() {
  System.out.println("Мстители");
 }
 

 Team (String name, String view, int age, int runningSpeed) {
  this.name = name;
  this.view = view;
  this.age = age;
  this.runningSpeed = runningSpeed;
 }

}
