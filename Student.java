import java.util.*;

import java.util.Scanner;

class Main {
    public static void main(String[] args) throws InvalidStudentException {
        // for taking input
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter name of the student");
        String name = scan.nextLine();
        System.out.println("Enter age of the student");
        String age = scan.next();
        System.out.println("Enter email of the student");
        String email = scan.next();
        System.out.println("Enter registration of the student");
        String registration = scan.next();
        System.out.println("Enter department of the student");
        String department = scan.next();
        System.out.println("Enter year of the student");
        String year = scan.next();

        // creating a Student class from above data
        Student st = new Student(name, age, email, registration, department, year);
    }
}

// Student class
class Student {
    Student(String name, String age, String email, String registration, String depart, String year)
            throws InvalidStudentException {
        try {
            int ag = Integer.parseInt(age);
            if (ag <= 0)
                throw new InvalidStudentException("Age should be greater than 0 and age should be a valid number");
        } catch (Exception e) {
            throw new InvalidStudentException("Age should be greater than 0 and age should be a valid number");

        }
        try {
            int ye = Integer.parseInt(age);
            if (ye <= 0)
                throw new InvalidStudentException("Year should be greater than 0 and age should be a valid number");
        } catch (Exception e) {
            throw new InvalidStudentException("Year should be greater than 0 and age should be a valid number");

        }
    }
}

// Custom exception
class InvalidStudentException extends Exception {

    InvalidStudentException(String excep) {
        super(excep);
    }

}
