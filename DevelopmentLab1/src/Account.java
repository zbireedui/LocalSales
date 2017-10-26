/**
 * ATM
 * @author Ireedui
 * Version 1.0
 * 
 * **/
public class Account {
	// account number
	private int accountNumber;
	// just now balance
	private int balance;

	/** 
	    * Class constructor.
	    */
	public void account() {
		this.accountNumber = 0;
		this.balance = 0;
	   }
	// set balance
    public void setBalance(int balance) {
        this.balance = balance;
     }
    // get balance
    public int getBalance() {
        return balance;
     }
    // get account number
     public int getAccountNumber() {
        return accountNumber;
     }
     // set account number
     public void setAccountNumber(int AccountNumber) {
         this.accountNumber = AccountNumber;
      }
     // calculate deposit
	 public void deposit(int deposit) {
	    	int temp;
	    	temp = getBalance()+deposit;
	    	setBalance(temp);
	   }
	 // calculate withdraw
	   public void withdraw(int deposit) {
		   int temp;
	    	temp = getBalance()-deposit;
	    	setBalance(temp);
	   }


}
