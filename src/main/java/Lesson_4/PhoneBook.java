//package main.java.Lesson_4;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//
//public class PhoneBook {
//    private HashMap<String, ArrayList<String>> phoneBook = new HashMap<>();
//
//    public void add(String lastName, String phoneNumber) {
//        ArrayList<String> phonesForLastName = phoneBook.getOrDefault(lastName, new ArrayList<>());
//        phonesForLastName.add(phoneNumber);
//        phoneBook.put(lastName, phonesForLastName);
//    }
//
//    public ArrayList<String> get(String lastName) {
//        return phoneBook.get(lastName);
//    }
//
//    public static void main(String[] args) {
//        PhoneBook phoneBook = new PhoneBook();
//        phoneBook.add("Ivanov", "234234243");
//        phoneBook.add("Ivanov1", "12345");
//        phoneBook.add("Ivanov2", "25347254");
//        phoneBook.add("Ivanov", "8888888");
//
//        System.out.println(phoneBook.get("Ivanov5"));
//    }
//}