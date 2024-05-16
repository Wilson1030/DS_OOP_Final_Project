package question7;

public class CLI {
	private static Scanner input = new Scanner(System.in);

	// To build readLine
	private static String readLine(String str1) {
		System.out.print(str1);
		return input.nextLine();
	}

	// To build readPosInt
	private static int readPosInt(String str2) {
		while(true) {
			// Use try-catch
			try {
				System.out.print(str2);
				int num = input.nextInt();
				input.nextLine();
				if (num < 0) {
					System.out.println("Positive integers only!");
				} else {
					return num;
				} 
			} catch (InputMismatchException e) {
				System.out.println("You must type an integer!");
				input.nextLine();
			}
		}
	}

	public static void main(String[] args) {
		// Create the single FinanceOffice object
		FinanceOffice FO = new FinanceOffice("UIC FO");
	}
}