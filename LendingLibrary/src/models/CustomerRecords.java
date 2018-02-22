package models;

import java.util.HashSet;

public class CustomerRecords {

	private HashSet<Customer> customers;

	// constructors
	public CustomerRecords() {
		customers = new HashSet<Customer>();
	}

	// private methods

	// public methods
	public int getNumberOfCustomers() {
		return customers.size();
	}
	public void addCustomer(Customer newCustomer) {
		customers.add(newCustomer);
	
	}

	public Customer findByName(String name) throws CustomerNotFoundException {

		for (Customer customer : customers) {
			if ((customer.getSurname().matches(name)) || (customer.getFistName().matches(name))) {
				return customer;
			}
		}
		throw new CustomerNotFoundException();
	}

}
