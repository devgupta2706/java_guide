class Istriangle {

    void check(int a, int b, int c) {
        if (a + b > c && a + c > b && b + c > a) {// checking the required condition
            System.out.printf("Triangle exists");

        } else {// if condition doesnot satisfy
            System.out.printf("Triangle doesnot exists");
        }

    }

}

class MainClass {
    public static void main(String[] args) {
        int a = 3, b = 7, c = 5;
        Istriangle object = new Istriangle();// reference of the class Istriangle
        object.check(a, b, c);// method calling
    }
}
