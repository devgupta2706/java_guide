import java.util.Scanner;

class bagADT {
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
        status = new boolean[20]; // status whether the order is in the cart or not.
    }

    void printOrder() {
        System.out.println("Do you want to add more customers (Y|N)");
        System.out.println("Customer Number " + Customer_Number);
        System.out.println("Item Name\t Price");
        for (int i = 0; i < 20; i++) {
            if (status[i] == true) {
                System.out.println(item_Name[i] + "\t" + price[i]);

            }
        }
    }
}

class Mainclass {
    public static void main(String[] args) {
        Customer[] C;
        char ch = 'Y';
        char che = 'Y';
        C = new Customer[20];
        Scanner sc = new Scanner(System.in);
        int j = 0;
        int remove;
        while (ch == 'Y' || ch == 'y') {
            C[j] = new Customer();
            int i = 0;
            while (ch == 'Y' || ch == 'y') {
                System.out.println("Enter Item Name");
                C[j].item_Name[i] = sc.nextLine();
                System.out.println("Enter Price");
                C[j].price[i] = sc.nextFloat();
                C[j].status[i] = true;
                i++;
                if (i >= 19)

                    System.out.println("Do you want to add more items (Y|N)");
                ch = sc.next().charAt(0);
            }
            System.out.println("Do you want to remove any items (Y|N)");
            ch = sc.next().charAt(0);
            while (ch == 'Y' || ch == 'y') {
                System.out.println("Enter the item Number you want to remove");
                remove = sc.nextInt();
                C[j].status[remove - 1] = false;
                System.out.println("Do you want to remove more items (Y|N)");
                ch = sc.next().charAt(0);
            }
            C[j].printOrder();
            System.out.println("Do you want to add more customers (Y|N)");
            ch = sc.next().charAt(0);
        }
    }
}
