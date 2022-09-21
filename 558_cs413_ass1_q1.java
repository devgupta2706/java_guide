class Name {

    void naam() {// function for printing name
        System.out.printf("My name is Dev Gupta");
    }
}

class MainClass {// main class
    public static void main(String[] args) {
        Name N = new Name();// reference of class Name
        N.naam();// calling of function of class Name by its reference N
    }
}
