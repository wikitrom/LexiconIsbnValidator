package se.mibis.isbntools;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StockManagementTest {

	// @Before
	// public void setUp() throws Exception {
	//
	// }

	@Test
	public void testCanGetACorrectLocatorCode() {

		// external dependencies for the class under test are stubbed
		ExternalISBNDataServiceInterface testService = new ExternalISBNDataServiceInterface() {

			@Override
			public Book lookup(String isbn) {
				return new Book(isbn, "Mastering Java 9", "Edward Lavieri");
			}
		};

		StockManager stockManager = new StockManager();
		stockManager.setService(testService); // to be able to mock service

		String isbn = "1786468735";
		String locatorCode = stockManager.getLocatorCode(isbn);
		assertEquals("8735E3", locatorCode);
	}

}
