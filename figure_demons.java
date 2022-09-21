interface Flyer {
    void takeOff();

    void land();

    void fly();
};

class Vehicle {
}

class Animal {
    void eat() {
        System.out.println("I can fly without any problem\n");
    }
}

class Kryptonian extends Animal {

}

class Aeroplane extends Vehicle implements Flyer {

    @Override
    public void takeOff() {
        System.out.println("I can Takeoff\n");
    }

    @Override
    public void land() {
        System.out.println("I can land without any problem\n");
    }

    @Override
    public void fly() {
        System.out.println("I can fly without any problem\n");
    }

}

class Bird extends Animal implements Flyer {

    @Override
    public void takeOff() {
        System.out.println("I can Takeoff\n");
    }

    @Override
    public void land() {
        System.out.println("I can land without any problem\n");
    }

    @Override
    public void fly() {
        System.out.println("I can fly without any problem\n");
    }

    public void layEggs() {
        System.out.println("Only I can Lay Eggs\n");
    }

    public void BuildNest() {
        System.out.println("Only I can Build nest\n");
    }

    @Override
    public void eat() {
        System.out.println("I can eat during Flying\n");
    }
}

class Superman extends Kryptonian implements Flyer {

    @Override
    public void takeOff() {
        System.out.println("I can Takeoff\n");
    }

    @Override
    public void land() {
        System.out.println("I can land without any problem\n");
    }

    @Override
    public void fly() {
        System.out.println("I can fly without any problem\n");
    }

    void LeapBuilding() {
        System.out.println("Only I can LeapBuilding who is  WarmBlooded\n");
    }

    void stopBullet() {
        System.out.println("Only I can Stop Bullet No one can do this else me\n");
    }
}

class UdneWaale {
    public static void main(String[] args) {
        Aeroplane A = new Aeroplane();
        Bird B = new Bird();
        Superman S = new Superman();
        System.out.println("Aeroplane Qualities\n");
        A.takeOff();
        A.fly();
        A.land();
        System.out.println("Bird Qualities\n");
        B.eat();
        B.fly();
        B.land();
        B.takeOff();
        B.layEggs();
        B.BuildNest();
        System.out.println("Superman Qualities\n");
        S.eat();
        S.takeOff();
        S.LeapBuilding();
        S.land();
        S.fly();
        S.stopBullet();

    }
}