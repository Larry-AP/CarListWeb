package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Larry Paucar - Lpaucar
 * CIS175 -Spring 2024
 * Mar 14, 2024
 */
@Entity
@Table(name="customer")
public class Customer {
	
	@Id
	@GeneratedValue
	private int id;
    private String customerName;
    
    public Customer() {
		super();
	}
	
	public Customer(int id, String customerName) {
		super();
		this.id = id;
		this.customerName = customerName;
	}

	public Customer(String customerName) {
		super();
		this.customerName = customerName;
	}
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", customerName=" + customerName + "]";
	}
    
}
