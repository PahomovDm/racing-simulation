import java.util.Scanner;

class Test {

	private static Scanner scan = new Scanner(System.in);
	private static String name;
	public static void main(String[] args) {
	up();
	entry();
	trimLine();
	helloName();
	equalsEnter();
	}
	private static void up() {
	System.out.println("Program rasing-simulation\n");
	}
	private static void entry() {
	System.out.println("Please enter your name:");
	name = scan.nextLine();
	}
	private static String trimLine() {
		if (name == null) {
			 System.out.println("Null");
		}
		while (name.trim().equals("")) {
			System.out.println("Empty");
			entry();
		}
		return name;
	}
	private static void helloName() {
 		System.out.printf("Hello %s! This is Racing Simulator\n", name.trim());
	}
	private static void equalsEnter() {
		System.out.print("Press <Enter> to exit...");
		while (("\n").equals(scan.nextLine()));

	}
}
