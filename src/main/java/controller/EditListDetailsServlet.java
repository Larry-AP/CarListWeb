package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CarInfo;
import model.Customer;
import model.ListDetails;

/**
 * Servlet implementation class EditListDetailsServlet
 */
@WebServlet("/editListDetailsServlet")
public class EditListDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditListDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ListDetailsHelper dao = new ListDetailsHelper();
		
		CarInfoHelper cih = new CarInfoHelper(); 
		CustomerHelper ch = new CustomerHelper();
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		ListDetails listToUpdate = dao.searchForListDetailsById(tempId);
		
		String newListName = request.getParameter("listName");
		
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		
		String customerName = request.getParameter("customerName");
		//find our add the new shopper
		Customer newCustomer = ch.findCustomer(customerName);
		
		LocalDate ld; try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day)); } catch (NumberFormatException ex) {
			     ld = LocalDate.now();
			}
			try {
			//items are selected in list to add 
			String[] selectedItems = request.getParameterValues("allItemsToAdd"); List<CarInfo> selectedItemsInList = new ArrayList<CarInfo>();
			for (int i = 0; i < selectedItems.length; i++) { System.out.println(selectedItems[i]);
			     CarInfo c =
			cih.searchForItemById(Integer.parseInt(selectedItems[i]));
			                    selectedItemsInList.add(c);
			     }
			          listToUpdate.setListOfCars(selectedItemsInList);

		} catch (NullPointerException ex) {
			// no items selected in list - set to an empty list
		     List<CarInfo> selectedItemsInList = new
		ArrayList<CarInfo>();
		     listToUpdate.setListOfCars(selectedItemsInList);
		     }
		     listToUpdate.setListName(newListName);
		     listToUpdate.setDateCreated(ld);
		     listToUpdate.setCustomer(newCustomer);
		     dao.updateList(listToUpdate);
		     getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
		}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
