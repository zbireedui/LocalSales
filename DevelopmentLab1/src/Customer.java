import java.util.ArrayList;
/**
 * ATM
 * @author Ireedui
 * Version 1.0
 * 
 * **/

public class Customer {
	/** customer name
	 * 
	 */
	   private String name; 
	// customer number
	   private int customerNumber; 
	 //customer accounts 
	   private ArrayList<String> accounts=new ArrayList<String>(); 
	   /** 
	    * Class constructor.
	    */
	   public void Customer() {
		   
	   }
	   //set name;
	    public void setName(String name) {
	        this.name = name;
	     }
	    //get name;
	    public String getName() {
	        return name;
	     }
	     // set customer number
	    public void setCustomerNumber(int number) {
	         this.customerNumber =number;
	      }
	    // get customer number
	    public int getCustomerNumber() {
	         return customerNumber;
	      }
	    // get accounts
	    public ArrayList<String> getAccounts() {
	        return accounts;
	     }

}
