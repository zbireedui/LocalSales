import java.util.ArrayList;
import java.util.Collection;
/**
 * ATM
 * @author Ireedui
 * Version 1.0
 * 
 * **/

public class Bank {
	// bank name
	   private String name; 
	// Costumers of bank;
	   private ArrayList<String> customers=new ArrayList<String>(); 
	   /** 
	    * Class constructor.
	    */
	   public void Bank() {
	   }
	 //set name;
	   public void setName(String name) {
	        this.name = name;
	     }
	 //get name;
	     public String getName() {
	        return name;
	     }
	  //set customers;
	     public void setCostumers(Collection<? extends String> state) {
		         this.customers.addAll(state);
		     }
	   //get customers;
		public ArrayList<String> getCostumers() {
		        return customers;
		     }
		
}
