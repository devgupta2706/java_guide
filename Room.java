class Roomdimension {

    double stick, s, a, b, c;

    Roomdimension(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;

    }

    void calculate() {
        this.s = a * a + b * b + c * c;
        this.stick = Math.sqrt(s);
    }

    void sticklength() {
        System.out.printf("Length of the string: " + this.stick);
    }

}

public class Room {
    public static void main(String[] args) {
        Roomdimension room = new Roomdimension(2.5, 3.8, 6.5);
        room.calculate();
        room.sticklength();
    }

}
