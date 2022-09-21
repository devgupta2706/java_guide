interface week {
    public int day();
}

enum Day implements week {
    Monday,
    Tuesday,
    Wednesday,
    Thursday,
    Friday,
    Saturday,
    Sunday;

    public int day() {
        return ordinal() + 1;
    }
}

public class Extexding_enum_from_interface {
    public static void main(String args[]) {
        Day Din[] = Day.values();
        for (Day d : Din) {
            System.out.println("It is day number "
                    + d.day()
                    + " of a week.");
            System.out.println(d);
        }
    }
}
