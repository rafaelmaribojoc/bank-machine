import java.util.*;

public class Main {

  //Instantiate objects

   static Bank account = new Bank();
   static Scanner scan = new Scanner(System.in);

  //Declaring variables

   long accountNum;
   String userInput; 

  public static void main(String[] args) {

    //Ask the user to sign or log in

    do {
      System.out.println("-----------------------");
      System.out.println("Choose number");
      System.out.println("\n1.Sign-up \n" + "2.Log-in");
      System.out.print("Enter number: ");
      int userInput = scan.nextInt();
      System.out.println("-----------------------");

      if (userInput == 1) {
        account.signUp();
      } else {
        account.logIn();
      }

    } while (Bank.isUserLoggedIn != true);

    //Check if the informations are all met before the bank will open

    while (Bank.isUserSignedIn && Bank.isUserLoggedIn && Bank.isOpen) {
      int userInput;
      boolean hasUserWithdrawn = false;

      do {
      System.out.println("-----------------------");
      System.out.println("Choose number");
      System.out.print("\n1. Account \n" + "2. Deposit \n" + "3. Withdraw \n" + "4. Exit \n" + "Enter number: ");;
      userInput = scan.nextInt();
      System.out.println("-----------------------");

      if (userInput == 1) {

        for (int i = 10; i <= 100; i += 10) {
          System.out.println("\r Loading: " + i + "%");
          try {
            Thread.sleep(100);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }

        account.getAccountInfo();
      } else if (userInput == 2) {
        account.depositMoney();
      } else if (userInput == 3) {
        hasUserWithdrawn = account.withdrawMoney();
      }

      } while(userInput != 4 && hasUserWithdrawn != true);

      Bank.isUserLoggedIn = false;
      Bank.isUserSignedIn = false;
    } 

  }
}