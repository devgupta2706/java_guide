package java9;

interface Flyer {
    public void fly();
}

interface Snake {
    public void snakeObservation();
}

interface Hawk extends Flyer, Snake {
    public void hawkDisplay();
}

class MultipleInterface implements Hawk {

    public static void main(String[] args) {
        MultipleInterface M = new MultipleInterface();
        System.out.printf("\nSnake Observation");
        M.fly();
        M.snakeObservation();
        System.out.printf("\nHawk Observation");
        M.fly();
        M.hawkDisplay();

    }

    @Override
    public void fly() {
        System.out.printf("\nI can fly. ");

    }

    @Override
    public void snakeObservation() {
        System.out.printf("without wings, takes help from hawk after Death.");
        System.out.printf("I have give my life to fly.");
        System.out.println("Good Bye Earth!!");
        System.out.println("I will take birth as some other organism.");

    }

    @Override
    public void hawkDisplay() {
        System.out.println("with wings.I help snake to fly.");
        System.out.println("I take snake life to help him.");
        System.out.println("Rest in Peace!!");

    }

}