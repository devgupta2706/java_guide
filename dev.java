interface dev {
    static int i = 15;

    abstract void num();
}

abstract class B implements dev {
    private static void display() {
        System.out.println("dhsfh");
    }

    abstract void newfun();

    public abstract void num();

    void getvalue() {
        display();
    }
}