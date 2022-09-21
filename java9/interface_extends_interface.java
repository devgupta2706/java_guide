package java9;

/*
Q1. Demonstrate
to show that an interface can extend another interface


Q2. Demonstrate
to show that interface can implement multiple interfaces


Q3: Demonstrate
that whether an abstract class implement interface.
 */
interface Flyer {
    public void fly();
}

interface Supermen extends Flyer {
    public void supermanQualities();
}

class Interface implements Supermen {
    @Override
    public void fly() {
        System.out.printf("\n I can fly " + "");

    }

    @Override
    public void supermanQualities() {
        System.out.println("without wings");

    }

    public static void main(String[] args) {
        Interface I = new Interface();
        System.out.printf("\nSuperman Qualities");
        I.fly();
        I.supermanQualities();
    }

}