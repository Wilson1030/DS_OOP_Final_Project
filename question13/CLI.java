package question13;

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

	public static void main(String[] args) throws NegativeSalaryException, UnknownPayerException {
		// Create the single FinanceOffice object
		FinanceOffice FO = new FinanceOffice("UIC FO");
		while(true) {
			int choice_1 = readPosInt("Type an action (total:1 add:2 get:3 give:4 take:5 quit:6): ");
			switch (choice_1) {
				case 1:
					System.out.println("Total amount of debt: " + FO.totalDebt());;
					break;
				case 2:
					int choice_2 = readPosInt("Enter the payer type (student:1 employee:2 faculty member:3): ");
					switch(choice_2) {
						case 1:
							String student = readLine("Enter the name of the payer: ");
							int amount_1 = readPosInt("Enter the initial amount of money: ");
							Student stu = new Student(student, amount_1);
							System.out.println("Student \"" + stu.getName() + "\" with " + stu.getDebt() + " yuans of debt added");
							FO.addPayer(stu);
							break;
						case 2:
							String employee = readLine("Enter the name of the payer: ");
							int amount_2 = readPosInt("Enter the initial amount of money: ");
							Employee ep = new Employee(employee, amount_2);
							System.out.println("Employee \"" + ep.getName() + "\" with " + (-ep.getDebt()) + " yuans of salary added");
							FO.addPayer(ep);
							break;
						case 3:
							String facultyMember = readLine("Enter the name of the payer: ");
							int amount_3 = readPosInt("Enter the initial amount of money: ");
							FacultyMember fm = new FacultyMember(facultyMember, amount_3);
							System.out.println("Faculty member \"" + fm.getName() + "\" with " + (-fm.getDebt()) + " yuans of salary added");
							FO.addPayer(fm);
							break;
						default:
							System.out.println("Unknown type of payer!");
							break;
					}
					break;
				case 3:
					String choice_3 = readLine("Enter the name of the payer: ");
					// To find whether the name exist
					try {
						int answer_1 = FO.getDebt(choice_3);
						System.out.println(choice_3 + " has " + answer_1 + " yuans of debt");
					} catch (UnknownPayerException e) {
						System.out.println("Payer " + choice_3 + " unknown");
					}
					
					break;
				case 4:
					String choice_4 = readLine("Enter the name of the payer: ");
					int amount_4 = readPosInt("Enter the amount of money: ");
					try{
						if (FO.getPayer(choice_4) instanceof Student stu) {
							stu.pay(amount_4);
						} else if (FO.getPayer(choice_4) instanceof Employee ep) {
							ep.pay(amount_4);
						} else if (FO.getPayer(choice_4) instanceof FacultyMember fm) {
							fm.pay(amount_4);
						}
					} catch (UnknownPayerException e) {
						System.out.println("Payer " + choice_4 + " unknown");
					} catch (NegativeSalaryException e) {
						System.out.println("An employee cannot be overpaid by " + (amount_4 + FO.getDebt(choice_4)) + " yuans!");
					}
					break;
				case 5:
					String choice_5 = readLine("Enter the name of the payer: ");
					int amount_5 = readPosInt("Enter the amount of money: ");
					try{
						if (FO.getPayer(choice_5) instanceof Student stu) {
							stu.take(amount_5);
						} else if (FO.getPayer(choice_5) instanceof Employee ep) {
							ep.take(amount_5);
						} 
					} catch (UnknownPayerException e) {
						System.out.println("Payer " + choice_5 + " unknown");
					} catch (NegativeSalaryException e) {
                        System.out.println("BUG! This must never happen!");
                        System.exit(1);
					}
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