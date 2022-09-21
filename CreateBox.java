import java.util.Scanner;
import java.lang.Exception;

class InvalidBoxException extends Exception {
    InvalidBoxException(String exception) {
        super(exception);
    }
}

class Box {
    Box(float length, float breadth, float height) throws InvalidBoxException {
        if (length <= 0) {
            throw new InvalidBoxException("Length Must be Greater than 0");

        }
        if (breadth <= 0) {
            throw new InvalidBoxException("Breadth Must be Greater than 0");

        }

        if (height <= 0) {
            throw new InvalidBoxException("Height Must be Greater than 0");
        }
    }

}

public class CreateBox {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Length :");
        float length = sc.nextFloat();
        System.out.println("Enter Breadth :");
        float breadth = sc.nextFloat();
        System.out.println("Enter Height :");
        float height = sc.nextFloat();
        try {
            Box B = new Box(length, breadth, height);
        } catch (InvalidBoxException e) {
            System.out.println(e);
        }
    }
}