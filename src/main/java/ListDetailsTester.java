import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.CustomerHelper;
import controller.ListDetailsHelper;
import model.CarInfo;
import model.Customer;
import model.ListDetails;

/**
 * Larry Paucar - Lpaucar
 * CIS175 -Spring 2024
 * Mar 14, 2024
 */
public class ListDetailsTester {
    public static void main(String[] args) {

	Customer drea = new Customer("Drea");
	
    ListDetailsHelper ldh = new ListDetailsHelper();
    
    CarInfo m3 = new CarInfo("BMW", "M3", "2006");
    CarInfo supra = new CarInfo("Toyota", "Supra", "2024");
    
    List<CarInfo> dreasCars = new ArrayList<CarInfo>();
    	dreasCars.add(m3);
    	dreasCars.add(supra);
    	ListDetails dreasList = new ListDetails("Drea's CarList", LocalDate.now(), drea);
	
	dreasList.setListOfCars(dreasCars);
	ldh.insertNewListDetails(dreasList);
	
	List<ListDetails> allLists = ldh.getLists();
	for(ListDetails a: allLists) {
		System.out.println(a.toString());
		}
	}
}