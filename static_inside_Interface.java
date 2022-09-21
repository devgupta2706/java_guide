interface Inside {
    public static void inside_method() {
        System.out.println("Static Method Inside Interface\n");
    }
}

public class static_inside_Interface {
    public static void main(String[] args) {
        Inside.inside_method();
    }
}
