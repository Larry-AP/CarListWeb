package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Larry Paucar - Lpaucar
 * CIS175 -Spring 2024
 * Mar 14, 2024
 */
@Entity
public class ListDetails {
	
	@Id
	@GeneratedValue
	private int id;
    private String listName;
    private LocalDate dateCreated;
    @ManyToOne (cascade=CascadeType.PERSIST)
    private Customer customer;
    @OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
    private List<CarInfo> listOfCars;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getListName() {
		return listName;
	}
	public void setListName(String listName) {
		this.listName = listName;
	}
	
	public LocalDate getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<CarInfo> getListOfCars() {
		return listOfCars;
	}
	public void setListOfCars(List<CarInfo> listOfCars) {
		this.listOfCars = listOfCars;
	}
	
	@Override
	public String toString() {
		return "ListDetails [id=" + id + ", listName=" + listName + ", dateCreated=" + dateCreated + ", customer="
				+ customer + ", listOfCars=" + listOfCars + "]";
	}
	public ListDetails() {
		super();
	}
    
	public ListDetails(int id, String listName, LocalDate dateCreated, Customer customer, List<CarInfo> listOfCars) {
		this.id = id;
	    this.listName = listName;
	    this.dateCreated = dateCreated;
	    this.customer = customer ;
	    this.listOfCars = listOfCars; 
	}
	public ListDetails(String listName, LocalDate dateCreated, Customer customer, List<CarInfo> listOfCars) {
		this.listName = listName;
	    this.dateCreated = dateCreated;
	    this.customer = customer;
	    this.listOfCars = listOfCars; 
			         
	}
	public ListDetails(String listName, LocalDate dateCreated, Customer customer) {
		this.listName = listName;
		this.dateCreated = dateCreated;
		this.customer = customer;
	}

}
