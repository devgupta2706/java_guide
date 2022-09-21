import java.util.Scanner;

// Exception class to handle creation of second object
class NotMoreThanOneException extends Exception {// class inheriting the Exception class from java
    NotMoreThanOneException() {// class constructor
        super("Don't try to create other object");
    }
}

class Unique {
    static int count = 0;// static integer creating once in the memory

    Unique() throws NotMoreThanOneException {
        if (count == 0) {// creating no problem on creation of first object
            System.out.println("Object Created");
            count++;
        } else
            throw new NotMoreThanOneException();
    }
}

public class NotSecondObj {
    public static void main(String[] args) {// main method
        char ch;
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                Unique U = new Unique();
            } catch (NotMoreThanOneException ex) {
                System.out.println(ex);
            }
            System.out.println("Do you want to create next obj\n");
            ch = sc.next().charAt(0);
            if (ch == 'Y' || ch == 'y') {

            } else {
                break;
            }
        }
        sc.close();
    }
}