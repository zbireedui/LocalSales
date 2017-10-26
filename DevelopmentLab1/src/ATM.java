/**
 * ATM
 * @author Ireedui
 * Version 1.0
 * 
 * **/
public class ATM {
	// What bank;
	   private String bank; 
	// what state
	   private String state; 
	// who current customer
	   private Customer currentCustomer; 
	// What current account
	   private Account currentAccount; 
	   
	   /** 
	    * Class constructor.
	    */
	   public void ATM() {
	   }
	   // set bank
	   public void setBank(String bank) {
	        this.bank = bank;
	     }
	   // get bank
	   public String getBank() {
	        return bank;
	     }
	   //set state
		public void setState(String state) {
		        this.state = state;
		     }
		//get state
		public String getState() {
		        return state;
		     }
		//set current customer
		public void setCurrentCustomer(Customer state) {
	         this.currentCustomer = state;
	     }
		// get current customer	
		public Customer getCurrentCustomer() {
	        return currentCustomer;
	     }
		public void withdraw() {
			
	   }
}
