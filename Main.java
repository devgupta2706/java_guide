import java.util.Scanner;

class Area {
    double areaofshape, a = -1, b = -1, c = -1, d = -1;
    String shape;
    int sides = -1;

    // this is for area of triangle and square
    public Area(double a) {
        this.a = a;

    }

    // this is for area of triangle with base and height and rectangle
    public Area(double a, double b) {
        this(a);
        this.b = b;
    }

    // this is for area of triangle with three sides given
    public Area(double a, double b, double c) {
        this(a, b);
        this.c = c;
    }

    public Area(double a, double b, double c, double d) {
        this(a, b, c);
        this.d = d;
    }

    void areaCount() {
        if (b == -1 || c == -1) {
            areaofshape = -1;
            shape = "Invalid";
        } else if (d == -1) {
            double s = a + b + c;
            s = s / 2;
            s = s * (s - a) * (s - b) * (s - c);
            areaofshape = Math.sqrt(s);
            this.shape = "Triangle";
            this.sides = 3;
        } else {
            areaofshape = a * b;
            this.sides = 4;
            if (a == b) {
                this.shape = "Square";
            } else {
                this.shape = "Rectangle";
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        int side;
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter number of sides of the shape");
        side = scn.nextInt();
        if (side == 3) {
            double a, b, c;
            System.out.println("Enter sides of the triangle");
            a = scn.nextDouble();
            b = scn.nextDouble();
            c = scn.nextDouble();
            Area shape = new Area(a, b, c);
            shape.areaCount();
            System.out.println("Area of " + shape.shape + shape.areaofshape);
        } else if (side == 4) {
            int choice;
            System.out.println("Enter your choice\n 1)Square\n2) Rectangle");
            choice = scn.nextInt();
            if (choice == 1) {
                double x;
                System.out.println("Enter side of the square");
                x = scn.nextDouble();
                Area shape = new Area(x, x, x, x);
                shape.areaCount();
                System.out.println("Area of " + shape.shape + shape.areaofshape);
            } else if (choice == 2) {
                double x, y;
                System.out.println("Enter sides of the Rectangle");
                x = scn.nextDouble();
                y = scn.nextDouble();
                Area shape = new Area(x, y, x, y);
                shape.areaCount();
                System.out.println("Area of " + shape.shape + ":" + shape.areaofshape);
            } else {
                System.out.println("Invalid choice");

            }

        } else {
            System.out.println("Invalid shape");
        }
        scn.close();
    }
}
