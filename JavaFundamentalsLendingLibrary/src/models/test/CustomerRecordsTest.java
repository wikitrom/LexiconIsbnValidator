package models.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import models.Customer;
import models.CustomerNotFoundException;
import models.CustomerRecords;

class CustomerRecordsTest {

	private CustomerRecords records;
	private Customer c1, c2, c3;

	@BeforeEach
	void setUp() throws Exception {
		records = new CustomerRecords();
		c1 = new Customer("Mr", "Per-Erik", "Westberg");
		c2 = new Customer("Mr", "Jan-Erik", "Svensson");
		c3 = new Customer("Ms", "Lena", "Brorsson");
	}

	@Test
	void testAddCustomerOneCustomer() {

		assertEquals(0, records.getNumberOfCustomers());
		records.addCustomer(c1);
		assertEquals(1, records.getNumberOfCustomers());
	}

	@Test
	void testAddCustomerOneCustomerTwiceNoDuplicates() {

		assertEquals(0, records.getNumberOfCustomers());
		records.addCustomer(c1);
		records.addCustomer(c1); // should not be added to records twice
		assertEquals(1, records.getNumberOfCustomers());
	}

	@Test
	void testAddCustomerTwoCustomers() {

		assertEquals(0, records.getNumberOfCustomers());
		records.addCustomer(c1);
		records.addCustomer(c2);
		assertEquals(2, records.getNumberOfCustomers());
	}

	@Test
	void testFindByNameFullFirstName() throws CustomerNotFoundException {
		records.addCustomer(c1);
		records.addCustomer(c2);
		records.addCustomer(c3);
		assertEquals(3, records.getNumberOfCustomers());

		// test
		Customer foundCustomer = records.findByName("Jan-Erik");
		assertNotNull(foundCustomer);
	}

	@Test
	void testFindPartFirstName() throws CustomerNotFoundException {
		records.addCustomer(c1);
		records.addCustomer(c2);
		records.addCustomer(c3);
		assertEquals(3, records.getNumberOfCustomers());

		// test
		Customer foundCustomer = records.findByName("Per.*");
		assertNotNull(foundCustomer);
	}

	@Test
	void testFindByNameFullSurname() throws CustomerNotFoundException {
		records.addCustomer(c1);
		records.addCustomer(c2);
		records.addCustomer(c3);
		assertEquals(3, records.getNumberOfCustomers());

		// test
		Customer foundCustomer = records.findByName("Westberg");
		assertNotNull(foundCustomer);
	}

	@Test
	void testFindPartSurname() throws CustomerNotFoundException {
		records.addCustomer(c1);
		records.addCustomer(c2);
		records.addCustomer(c3);
		assertEquals(3, records.getNumberOfCustomers());

		// test
		Customer foundCustomer = records.findByName("Bror.*");
		assertNotNull(foundCustomer);
	}

	@Test
	void testFindByNameCustomerNotFound() {
		records.addCustomer(c1);
		records.addCustomer(c2);
		records.addCustomer(c3);
		assertEquals(3, records.getNumberOfCustomers());

		// test
		try {
			Customer foundCustomer = records.findByName("Nisse");
			fail("Expected exception, not to find customer instance: " + foundCustomer.getMailingName());
		} catch (CustomerNotFoundException e) {
		}
	}

}
