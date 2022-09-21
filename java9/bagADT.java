public class bagADT {
    int Customer_Number;
    String item_Name[];
    float price[];
    boolean status[];
}

class Customer extends bagADT {
    public static int n = 0;

    public Customer() {

        item_Name = new String[20]; // Maximum Quantity is 20 that a customer
        price = new float[20]; // can order at a time.
        Customer_Number = ++n; // static integer is taken to get the customer number increment on every order.
        status = new boolean[20]; // status whwther the order is in the cart or not.
    }
}

class Mainclass {
    public static void main(String[] args) {
        Customer C;
        C = new Customer();
        while (true) {

        }
    }
}
