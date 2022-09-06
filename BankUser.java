public class BankUser {
    private String firstName; 
    private String lastName; 
    private int pin; 
    private double balance; 

     public BankUser(String fName, String lName, int pin) {
         this.firstName = fName; 
         this.lastName = lName; 
         this.pin = pin; 
         this.balance = 0.0; 
    }

    public int getPin() {return this.pin;}
    public void setPin(int newPin) {this.pin = newPin;}
    public String getFirstName() {return this.firstName;}
    public String getLastName() {return this.lastName;}
    public double checkBalance() {return this.balance;}
    public void setBalance(double newBalance) {this.balance = newBalance;}
    public void deposit(double value) {this.balance += value;}
    public void withdraw(double value) {this.balance -= value;}
    public String toString() {return firstName + " " + lastName + "\n Balance: " + balance;} 
}

