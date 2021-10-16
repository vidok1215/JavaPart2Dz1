package main.java.Lesson_1;

public class HoweWork1 {
    public static void main(String[] args) {

                System.out.println("                   Мстители");

        Hulk hulk = new Hulk("Халк","Гамма-мутант",40, 10);
        Loki loki = new Loki("Локи","Ётун (ледяной великан)",72, 5);
        Thor thor = new Thor("Тор","Асгардец",59, 7);
        Tony tony = new Tony("Тони","Человек",58, 3);
System.out.println(hulk);
System.out.println(loki);
System.out.println(thor);
System.out.println(tony);


        Hulk hulk1Competitor1 = new Hulk("Халк","Гамма-мутант",40, 10);
//        hulk1Competitor1.setRunningSpeed(10);
        Loki loki1Competitor1 = new Loki("Локи","Ётун (ледяной великан)",72, 5);
//        loki1Competitor1.setRunningSpeed(5);
        Thor thor1Competitor1 = new Thor("Тор","Асгардец",59, 7);
//        thor1Competitor1.setRunningSpeed(7);
        Tony tony1Competitor1 = new Tony("Тони","Человек",58, 3);
//        tony1Competitor1.setRunningSpeed(3);



        Course[] courses = {new Course(60), new Course(40), new Course(50), new Course(30)};

        for (Course course : courses) {
            course.getTimeToOvercomeCourse(hulk1Competitor1);
            course.getTimeToOvercomeCourse(loki1Competitor1);
            course.getTimeToOvercomeCourse(thor1Competitor1);
            course.getTimeToOvercomeCourse(tony1Competitor1);

        }


    }

}
