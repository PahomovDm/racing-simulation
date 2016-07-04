import java.util.Scanner;

public class Test {

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner (System.in);
		String name;
		
		System.out.println("Please enter your name:");
		do {
			 name = scan.nextLine();
		} while (name.trim().equals(""));
		
		System.out.printf("Hello %s! This is Racing Simulator\n", name);
		System.out.print("Press <Enter> to exit...");
		
		while (("\n").equals(scan.nextLine())) {
		;
		}
		
	}

}
