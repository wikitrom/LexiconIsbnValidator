package se.mibis.isbntools;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Ignore;
import org.junit.Test;

public class Junit4ValidateISBNTest {

	// positive tests
	@Test
	public void checkValidISBNs() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBN("1785887947");
		assertTrue("First value", result);
		result = validator.checkISBN("1786468735");
		assertTrue("Second value", result);
	}

	@Test
	public void checkValidISBNsEndingWithAnX() {
		ValidateISBN validator = new ValidateISBN();
 		boolean result = validator.checkISBN("067233710X"); // a valid isbn 
		assertTrue(result);
	}

	@Test
	public void checkValidThirteenDigitISBNs() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBN("978-0-306-40615-7");
		assertTrue("First value", result);
		result = validator.checkISBN("978-0672337109");
		assertTrue("Second value", result);
	}

	// negative tests
	@Test
	public void checkInvalidIsbn() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBN("1785887946");
		assertFalse(result);
	}

	@Test(expected = NumberFormatException.class)
	public void lessThan10DigitIsbnNotAllowed() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBN("178588794"); // 9 digit number
		assertFalse(result);
	}

	@Test(expected = NumberFormatException.class)
	public void moreThan13DigitIsbnNotAllowed() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBN("17858879470000"); // 14 digit number
		assertFalse(result);
	}

	@Test(expected = NumberFormatException.class)
	public void NonNumericISNBsAreNotAllowed() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBN("halloworld"); // 10 character string
		assertFalse(result);
	}

}

// Example valid 10digit ISBN:
// 067233710X
// 1785887947
// 1786468735

// Examples valid 13 digit ISBN
// 978-0-306-40615-7
//  978-0672337109
