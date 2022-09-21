class Area {
    double areaofshape;
    String shape;

    // this is for area of equilateral triangle and square
    public Area(double a, int sides) {
        if (sides == 3) {
            areaofshape = 1.732 * 0.25 * a * a;
            this.shape = "Equilateral Triangle";
        } else if (sides == 4) {
            areaofshape = a * a;
            this.shape = "Square";
        } else {
            areaofshape = (double) (-1);
            this.shape = "Invalid";
        }

    }

    // this is for area of triangle with base and height and rectangle
    public Area(double a, double b, int sides) {
        if (sides == 3) {
            areaofshape = 0.5 * a * b;
            this.shape = "Triangle";
        } else if (sides == 4) {
            areaofshape = a * b;
            this.shape = "Rectangle";
        } else {
            areaofshape = (double) (-1);
            this.shape = "Invalid";
        }

    }

    // this is for area of triangle with three sides given
    public Area(double a, double b, double c, int sides) {
        if (sides == 3) {
            double s = a + b + c;
            s = s / 2;
            s = s * (s - a) * (s - b) * (s - c);
            areaofshape = Math.sqrt(s);
            this.shape = "Triangle";
        } else {
            areaofshape = (double) (-1);
            this.shape = "Invalid";
        }

    }

    void areashape() {
        if (areaofshape == (double) (-1)) {
            System.out.println("Invalid data");
        } else {
            System.out.println("Area of the " + this.shape + ":" + areaofshape);
        }
    }

}

class Main {
    public static void main(String[] args) {
        Area eq_triangle = new Area(2.5, 3);
        eq_triangle.areashape();
        Area square = new Area(2.5, 4);
        square.areashape();
        Area trianglewithbandh = new Area(2.5, 2.8, 3);
        trianglewithbandh.areashape();
        Area rectangle = new Area(2.5, 8.7, 4);
        rectangle.areashape();
        Area herontriangle = new Area(2.5, 8.5, 9.5, 3);
        herontriangle.areashape();
    }
}