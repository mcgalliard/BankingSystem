import java.util.ArrayList; 
import java.util.Scanner; 
public class BankAdmin {
    private static ArrayList<BankUser> users = new ArrayList<BankUser>(); 
    static Scanner input = new Scanner(System.in); 
    public static BankUser admin = new BankUser("Admin","Admin",99); 
   
    public static String viewAccounts() {
        for(BankUser user: users) {
            System.out.println("Name: " + user.getFirstName() + ", " + user.getLastName()); 
            System.out.println("Balance $" + user.checkBalance()); 
            System.out.println("Index: " + users.indexOf(user) + "   Pin: " + user.getPin()); 
        }
        return ""; 
    }

    public static void deleteAccount(int ind) {users.remove(ind);}

    public static void addAccount(BankUser user) {users.add(user);}

    public static boolean verify(BankUser user, int tryPin) {return user.getPin() == tryPin;}

    public static BankUser[] checkPins(int pin) {
        for(int i = 0; i < users.size(); i++) {
            if (users.get(i).getPin() == pin) {
                return new BankUser[]{new BankUser("pass","pass",777),users.get(i)};
            }
        }
        return new BankUser[]{new BankUser("pass","pass",1000000)}; 
    }

    public static void adminPortal() {
        //System.out.println("Admin Command Loop entered"); 
        System.out.print("What would you like to do: "); 
        String command = input.nextLine(); 

        if(command.equals("delete")) {
            System.out.println("Index: "); 
            int ind = input.nextInt(); 
            deleteAccount(ind); 
            input.nextLine(); 
            BankAdmin.adminPortal(); 
        }

        if(command.equals("add")) {
            System.out.println("First name: "); 
            String fName = input.nextLine(); 
            System.out.println("Last name: "); 
            String lName = input.nextLine(); 
            System.out.println("Set pin: ");
            int newPin = input.nextInt(); 
            BankAdmin.addAccount(new BankUser(fName, lName, newPin)); 
            input.nextLine(); 
            BankAdmin.adminPortal(); 
        }

        if(command.equals("view")) {
            BankAdmin.viewAccounts(); 
            BankAdmin.adminPortal(); 
        }
    }

    public static void userPortal(BankUser current) {
        BankUser currentUser = current; 
        //System.out.println("User Command Loop entered"); 
        System.out.print("What would you like to do: "); 
        String command = input.nextLine(); 

        if(command.equals("check")) {
            System.out.println("Balance: $" + currentUser.checkBalance()); 
            BankAdmin.userPortal(currentUser); 
        }

        if(command.equals("deposit")) {
            System.out.print("Amount $");
            currentUser.deposit(input.nextDouble()); 
            input.nextLine(); 
            BankAdmin.userPortal(currentUser); 
        }

        if(command.equals("withdraw")) {
            System.out.print("Amount $");
            currentUser.withdraw(input.nextDouble()); 
            input.nextLine(); 
            BankAdmin.userPortal(currentUser);       
        }
    }
}

