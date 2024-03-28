import java.util.List;

import controller.CustomerHelper;
import model.Customer;

/**
 * Larry Paucar - Lpaucar
 * CIS175 -Spring 2024
 * Mar 14, 2024
 */
public class CustomerTester {
	
	 public static void main(String[] args) {
		 
         Customer link = new Customer("Link");
         CustomerHelper ch = new CustomerHelper();
         ch.insertCustomer(link);
         
         Customer zoe = new Customer("Zoe");
         ch.insertCustomer(zoe);
         
         List<Customer> allCustomers = ch.showAllCustomers();
         for(Customer a: allCustomers) {
              System.out.println(a.toString());
         }
	 }

}
