package se.mibis.isbntools;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.internal.matchers.Null;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

public class StockManagementTest {

	ExternalISBNDataServiceInterface webService, dbService;
	StockManager stockManager;	
	
	 @Before
	 public void setUp() throws Exception {	// 
		// mock interfaces used by class under test
		webService = mock(ExternalISBNDataServiceInterface.class);	// 
		dbService = mock(ExternalISBNDataServiceInterface.class);

		stockManager = new StockManager();
		stockManager.setWebService(webService); 	// mock service
		stockManager.setDbService(dbService); 			// mock service		
	
	 }

	// positive tests
	
	// TESTs data using mocked classes
	@Test
	public void testCanGetACorrectLocatorCode() {

		// --- Preparation
		String isbn = "1786468735";
		when(dbService.lookup(anyString())).thenReturn(null);
		when(webService.lookup(anyString())).thenReturn(new Book(isbn, "Mastering Java 9", "Edward Lavieri"));		
		// --- Test
		String locatorCode = stockManager.getLocatorCode(isbn);
		assertEquals("8735E3", locatorCode);
	}

	// TEST behaviour (logic) using mocked classes (mockito framework
	@Test
	public void testDatabaseIsUsedIfDatabasePresent() {
		// --- Preparation
		// when lookup is called return a book
		String isbn = "1786468735";
		when(dbService.lookup(isbn)).thenReturn(new Book(isbn, "abc", "abc"));

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
		// when lookup is called return a book
		String isbn = "1786468735";
		when(dbService.lookup(isbn)).thenReturn(null);
		when(webService.lookup(isbn)).thenReturn(new Book(isbn, "abc", "abc"));
		
		// --- Test
		String locatorCode = stockManager.getLocatorCode(isbn);
		verify(dbService, times(1))
			.lookup("1786468735");
		verify(webService, times(1))
			.lookup("1786468735");
	}
}
