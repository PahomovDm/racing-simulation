import java.util.Scanner;
public final class Test {

    private static Scanner scan = new Scanner(System.in);
    private static String name;

    private Test() {
    }

    public static void main(String[] args) {
        getInfo();
        enterName();
        trimLine();
        helloName();
        equalsEnter();
    }

    private static void getInfo() {
        System.out.println("Program rasing-simulation\n");
    }

    private static void enterName() {
        System.out.println("Please enter your name:");
        name = scan.nextLine();
    }

    private static String trimLine() {
        if (name == null) {
            System.out.println("Null");
        }
        while (name.trim().equals("")) {
            System.out.println("Empty");
            enterName();
        }
        return name;
    }

    private static void helloName() {
        System.out.printf("Hello %s! This is Racing Simulator\n", name.trim());
    }

    private static void equalsEnter() {
        while (("\n").equals(scan.nextLine())) {
            System.out.print("Press <Enter> to exit...");
        }
    }
}
