import java.util.Scanner;

class Complexnumber {
    int real, imaginary;

    public Complexnumber(int real, int imaginary) {
        this.real = real;
        this.imaginary = imaginary;

    }

    void add(Complexnumber A) {
        this.real = A.real + this.real;
        this.imaginary = A.imaginary + this.imaginary;

    }
}

class Complex {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int real, image;
        System.out.println("Enter first complex number");
        System.out.println("Enter real part");
        real = scn.nextInt();
        System.out.println("Enter imaginary part");
        image = scn.nextInt();
        Complexnumber A = new Complexnumber(real, image);
        System.out.println("Enter second complex number");
        System.out.println("Enter real part");
        real = scn.nextInt();
        System.out.println("Enter imaginary part");
        image = scn.nextInt();
        Complexnumber sum = new Complexnumber(real, image);
        A.add(sum);
        System.out.println("Sum of complex numbers :" + A.real + "+" + A.imaginary + "i");
        scn.close();
    }
}