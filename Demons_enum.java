
enum Months {
    Jan, Feb, Mar, Apr, May, Jun, Jul, Aug, Sep, Oct, Nov, Dec;
}

public class Demons_enum {
    public static void main(String[] args) {
        Months Mon[] = Months.values();
        for (Months m : Mon) {
            System.out.println(m + " at Index :" + m.ordinal());
        }
    }
}
