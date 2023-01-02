import java.util.*;

public class Bank {
static Scanner scan = new Scanner(System.in);
static Calendar calendar = Calendar.getInstance();
static Random random = new Random();
static StringBuilder maskedPassword = new StringBuilder();

public static boolean isOpen, isUserLoggedIn, isUserSignedIn;
public double balance;
public String name, password, email, phoneNum;
public long accountNum, randomNum = (long) random.nextLong(999999L);

public Bank() {

    int dayOfTheWeekInMonth = calendar.get(Calendar.DAY_OF_WEEK);
    String[] dayOfTheWeekNames = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
    String dayOfTheWeek = dayOfTheWeekNames[dayOfTheWeekInMonth - 1];

    if (dayOfTheWeek != "Sunday") {
        isOpen = true;
    }
    
    if (isOpen) {
        System.out.println("\nWELCOME! we are open.");
    } else {
        System.out.println("Sorry it's " + dayOfTheWeek + " the bank is close. \n");
    }
}

public void signUp() {
    System.out.println("-----------------------");
    System.out.println("Sign up \n");
    System.out.print("Name: ");
    name = scan.nextLine();
    System.out.print("Password: ");
    password = scan.nextLine();
    System.out.print("Email: ");
    email = scan.nextLine();
    System.out.print("Phone Number: ");
    phoneNum = scan.nextLine();
    accountNum = randomNum;
    System.out.println("Your account number is " + accountNum);
    System.out.println("\nAccount created!");
    System.out.println("-----------------------");
    isUserSignedIn = true;
}

public void logIn() {
    System.out.println("-----------------------");
    System.out.println("Log in to your account \n");
    System.out.print("Account number: ");
    long accNum = scan.nextLong();
    System.out.print("Password: ");
    scan.nextLine();
    String pass = scan.nextLine();
    if (accNum == this.accountNum && pass.equals(this.password)) {
        System.out.println("\nLogged in successfully!");
        isUserLoggedIn = true;
    } else {
        System.out.println("\nIncorrect account number and password! Create new account if you don't have.");
    }
    System.out.println("-----------------------");
}


public void getAccountInfo() {

    maskedPassword.setLength(0);

    for (int i = 0; i <= this.password.length(); i++) {
        
        maskedPassword.append("*");
        
    }
    
    System.out.println("\n BALANCE: " + this.balance + "\n Account Number: " + this.accountNum + "\n Name: " + this.name + "\n Password: " + maskedPassword.toString() + "\n Email: " + this.email + "\n Phone Number: " + this.phoneNum);
}

public void depositMoney() {
    System.out.print("Amount: ");
    double depositMoney = scan.nextDouble();

    this.balance = (double) depositMoney;
}

public boolean withdrawMoney() {
    System.out.print("Amount: ");
    double withdrawAmount = scan.nextDouble();
    this.balance -= (double) withdrawAmount;
    int hour = calendar.get(Calendar.HOUR);
    int minutes = calendar.get(Calendar.MINUTE);
    int seconds = calendar.get(Calendar.SECOND);
    System.out.println("-----------------------");
    System.out.println("\n Receipt:");
    System.out.println("\n Time: " + hour + "-" + minutes + "-" + seconds + "\n Account Number: " + this.accountNum + "\n Name: " + this.name + "\n Amount: " + withdrawAmount + "\n Balance: " + String.format("%.2f", this.balance));
    System.out.println("-----------------------");
    return true;
}


}
