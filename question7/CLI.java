package question7;

import java.util.InputMismatchException;
import java.util.Scanner;

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

	public static void main(String[] args) throws NegativeSalaryException {
		// Create the single FinanceOffice object
		FinanceOffice FO = new FinanceOffice("UIC FO");
		while(true) {
			int choice_1 = readPosInt("Type an action (total:1 add:2 get:3 give:4 take:5 quit:6):");
			switch (choice_1) {
				case 1:
					FO.totalDebt();
					break;
				case 2:
					int choice_2 = readPosInt("Enter the payer type (student:1 employee:2 faculty member:3)");
					switch(choice_2) {
						case 1:
							String student = readLine("Enter the name of the payer:");
							int amount_1 = readPosInt("Enter the initial amount of money:");
							Student stu = new Student(student, amount_1);
							System.out.println("Student \"" + stu.getName() + "\" with " + stu.getDebt() + " yuans of debt added");
							FO.addPayer(stu);
							break;
						case 2:
							String employee = readLine("Enter the name of the payer:");
							int amount_2 = readPosInt("Enter the initial amount of money:");
							Employee ep = new Employee(employee, amount_2);
							System.out.println("Employee \"" + ep.getName() + "\" with " + (-ep.getDebt()) + " yuans of salary added");
							FO.addPayer(ep);
							break;
						case 3:
							String facultyMember = readLine("Enter the name of the payer:");
							int amount_3 = readPosInt("Enter the initial amount of money:");
							FacultyMember fm = new FacultyMember(facultyMember, amount_3);
							System.out.println("Faculty member \"" + fm.getName() + "\" with " + (-fm.getDebt()) + " yuans of salary added");
							break;
						default:
							System.out.println("Unknown type of payer!");
							break;
					}
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				case 6:
					System.out.println("Goodbye!");
					System.exit(0);
				default:
					System.out.println("Unknown action!");
			}
		}
	}
}