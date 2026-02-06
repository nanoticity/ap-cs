package bank;

public class AccountManager {
  private Account[] accounts; 
  
  public AccountManager() {
    accounts = new Account[3];
    accounts[0] = new Account("John", 1234, 10.10);
    accounts[1] = new Account("Jen", 1111, 99.99);
    accounts[2] = new Account("Jay", 4321, 11.11);
    
  }

  public void printInfo() {
    for (Account account : accounts) {
      System.out.println(account.toString());
    }
  }
}
