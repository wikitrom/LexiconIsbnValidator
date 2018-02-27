package se.mibis.isbntools;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.internal.matchers.Null;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

public class StockManagementTest {

	// @Before
	// public void setUp() throws Exception {
	//
	// }

	// positive tests
	
	// TESTs data using stubbed dependencies
	@Test
	public void testCanGetACorrectLocatorCode() {

		// external dependencies for the class under test are stubbed
		ExternalISBNDataServiceInterface testWebService = new ExternalISBNDataServiceInterface() {

			@Override
			public Book lookup(String isbn) {
				return new Book(isbn, "Mastering Java 9", "Edward Lavieri");
			}
		};

		ExternalISBNDataServiceInterface testDbService = new ExternalISBNDataServiceInterface() {

			@Override
			public Book lookup(String isbn) {
				// TODO Auto-generated method stub
				return null;
			}
		};

		StockManager stockManager = new StockManager();
		stockManager.setWebService(testWebService); 	// stub service
		stockManager.setDbService(testDbService); 			// stub service

		String isbn = "1786468735";
		String locatorCode = stockManager.getLocatorCode(isbn);
		assertEquals("8735E3", locatorCode);
	}

	// TEST behaviour (logic) using mocked classes (mockito framework
	@Test
	public void testDatabaseIsUsedIfDatabasePresent() {
		// --- Preparation
		// mock interfaces used by class under test
		ExternalISBNDataServiceInterface dbService = mock(ExternalISBNDataServiceInterface.class);
		ExternalISBNDataServiceInterface webService = mock(ExternalISBNDataServiceInterface.class);

		// when lookup is called return a book
		when(dbService.lookup("1786468735")).thenReturn(new Book("1786468735", "abc", "abc"));

		String isbn = "1786468735";
		StockManager stockManager = new StockManager();
		stockManager.setWebService(webService); // to be able to mock service
		stockManager.setDbService(dbService); // to be able to mock service

		// --- Test
		String locatorCode = stockManager.getLocatorCode(isbn);

		verify(dbService, times(1))
			.lookup("1786468735");
		verify(webService, times(0))
			.lookup(anyString());
	}

	@Test
	public void testWebserviceIsUsedIfNoDataInDatabase() {
		// --- Preparation
		// mock interfaces used by class under test
		ExternalISBNDataServiceInterface dbService = mock(ExternalISBNDataServiceInterface.class);
		ExternalISBNDataServiceInterface webService = mock(ExternalISBNDataServiceInterface.class);

		// when lookup is called return a book
		when(dbService.lookup("1786468735")).thenReturn(null);
		when(webService.lookup("1786468735")).thenReturn(new Book("1786468735", "abc", "abc"));
		String isbn = "1786468735";
		StockManager stockManager = new StockManager();
		stockManager.setWebService(webService); // to be able to stub service
		stockManager.setDbService(dbService); // to be able to stub service

		// --- Test
		String locatorCode = stockManager.getLocatorCode(isbn);

		verify(dbService, times(1))
			.lookup("1786468735");
		verify(webService, times(1))
			.lookup("1786468735");
	}
}
