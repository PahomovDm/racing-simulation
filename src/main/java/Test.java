import java.util.Scanner;

public class Test {
	private static  String name;
	private static  Scanner scan = new Scanner (System.in);

	public static void main(String[] args) {
		
		System.out.println("Please enter your name:");
		
		trimLine();
		
		System.out.printf("Hello %s! This is Racing Simulator\n", name);
		System.out.print("Press <Enter> to exit...");
		
		equalsEnter();
	}
	
	static String trimLine ()
	{
		do {
			 name = scan.nextLine();
		} while (name.trim().equals(""));
		
		return name.trim();
	}

	static void equalsEnter ()
	{
		while (("\n").equals(scan.nextLine())) {
		;
		}

	}


}
