import java.util.Scanner;
import java.lang.Exception;

class InvalidTriangleException extends Exception {
    InvalidTriangleException(String exception) {
        super(exception);
    }
}

class Triangle {
    Triangle(float s1, float s2, float s3) throws InvalidTriangleException {
        if (s1 + s2 <= s3 || s2 + s3 <= s1 || s3 + s1 <= s2) {
            throw new InvalidTriangleException("Invalid Triangle ");

        }

    }
}

public class CreateTriangle {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Side 1 :");
        float side1 = sc.nextFloat();
        System.out.println("Enter Side 2 :");
        float side2 = sc.nextFloat();
        System.out.println("Enter Side 3 :");
        float side3 = sc.nextFloat();
        try {
            Triangle B = new Triangle(side1, side2, side3);
        } catch (InvalidTriangleException e) {
            System.out.println(e);
        }
    }
}