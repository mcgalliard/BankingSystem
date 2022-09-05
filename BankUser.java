public class BankUser {
    String firstName; 
    String lastName; 
    int pin; 

     public BankUser(String fName, String lName, int pin) {
         this.firstName = fName; 
         this.lastName = lName; 
         this.pin = pin; 
         System.out.println("New user successfully created!");
         System.out.println("Name: " + lName + ", " + fName); 
         System.out.println("Pin: " + pin);  
    }
}