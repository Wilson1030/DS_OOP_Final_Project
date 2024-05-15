package question6;

import java.util.Scanner;
import java.util.InputMismatchException;

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
		String str1 = readLine("Type some text: ");
		System.out.println("Text read is: " + str1);
		int i = readPosInt("Type an integer: ");
		System.out.println("Integer read is: " + i);
		String str2 = readLine("Type some text again: ");
		System.out.println("Text read is: " + str2);
	}
}