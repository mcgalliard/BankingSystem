//Basic Banking Application
//Christopher McGalliard 

import java.util.Scanner; 
public class BankingSystem {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); 
		System.out.println("Welcome to the bank!");

		System.out.print("Are you an admin: "); 
		String isAdmin = input.nextLine(); 

		if(isAdmin.equals("yes")) {
			System.out.print("Enter your pin: "); 
			int adminPin = input.nextInt(); 
			if(BankAdmin.verify(BankAdmin.admin,adminPin)) {
				BankAdmin.adminPortal(); 
			} else {
				System.out.println("Pin Failed"); 
			}
			input.nextLine(); 
		} else {
			System.out.print("Are you a new user: "); 
			String isNewUser = input.nextLine(); 
			if(isNewUser.equals("yes")) {
				System.out.print("First name: "); 
				String fName = input.nextLine(); 
				System.out.print("Last name: "); 
				String lName = input.nextLine(); 
				System.out.print("Set pin: ");
				int newPin = input.nextInt(); 
				BankUser newUser = new BankUser(fName, lName, newPin);
				BankAdmin.addAccount((newUser)); 
				input.nextLine(); 
				BankAdmin.userPortal(newUser); 
			} else { 
				System.out.print("Enter your pin: "); 
				int userPin = input.nextInt(); 
				if(BankAdmin.checkPins(userPin)[0].getPin() == 777) {
					BankUser currentUser = BankAdmin.checkPins(userPin)[1]; 
					BankAdmin.userPortal(currentUser); 
				} else {
					System.out.println("Pin Failed"); 
				}
				input.nextLine(); 
			}
		}
	}
}
