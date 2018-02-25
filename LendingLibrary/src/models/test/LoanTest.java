package models.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.GregorianCalendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import models.Book;
import models.Customer;
import models.Loan;

class LoanTest {

	private Book book;
	private Customer customer;
	private Loan loan;

	@BeforeEach
	void setUp() throws Exception {
	book = new Book("0", "", "", "", "", 0);
	customer = new Customer("", "", "");
	loan = new Loan(customer, book);
	}

	// @Test
	// void testGetDueDate() {
	// fail("Not yet implemented");
	// }
	//
	@Test
	void testEquals() {
		
	}

	@Test
	void testDueDate() {
		// Book book = new Book("0", "", "", "", "", 0);
		// Customer customer = new Customer("", "", "");
		// Loan loan = new Loan(customer, book);

		GregorianCalendar gcExpect = new GregorianCalendar();
		gcExpect.add(GregorianCalendar.DAY_OF_YEAR, 14);

		GregorianCalendar gcActual = new GregorianCalendar();
		gcActual.setTime(loan.getDueDate());

		assertEquals(gcExpect.get(GregorianCalendar.YEAR), gcActual.get(GregorianCalendar.YEAR));
//		assertEquals(2018, gcActual.get(GregorianCalendar.YEAR));
		assertEquals(gcExpect.get(GregorianCalendar.MONTH), gcActual.get(GregorianCalendar.MONTH));
//		assertEquals(2, gcActual.get(GregorianCalendar.MONTH));
		assertEquals(gcExpect.get(GregorianCalendar.DAY_OF_MONTH), gcActual.get(GregorianCalendar.DAY_OF_MONTH));
	}

}
