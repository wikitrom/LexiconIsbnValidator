package se.mibis.isbntools;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

public class Junit4ValidateISBNTest {

	// ----- positive tests
	@Test
	public void checkValid10DigitISBNs() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBN("1785887947");
		assertTrue("First value", result);
		result = validator.checkISBN("1786468735");
		assertTrue("Second value", result);
	}

	@Test
	public void checkValid10DigitISBNsEndingWithAnX() {
		ValidateISBN validator = new ValidateISBN();
 		boolean result = validator.checkISBN("067233710X");
		assertTrue(result);
	}

	@Test
	public void checkValid13DigitISBNs() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBN("978-0-306-40615-7");
		assertTrue("First value", result);
		result = validator.checkISBN("978-0672337109");
		assertTrue("Second value", result);
	}

	// ----- negative tests
	@Test
	public void checkInvalid10DigitIsbn() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBN("1785887946");
		assertFalse(result);
	}

	@Test
	public void checkInvalid13DigitIsbn() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBN("978-0-306-40615-0");  // checksum 0 is incorrect
		assertFalse(result);
	}
	
	@Test(expected = NumberFormatException.class)
	public void lessThan10DigitIsbnNotAllowed() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBN("1785884"); // 7 digit number
		assertFalse(result);
	}

	@Test(expected = NumberFormatException.class)
	public void elevenOrTwelveDigitIsbnNotAllowed() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBN("17858879433"); // 11 digit number
		assertFalse(result);
		result = validator.checkISBN("178588794333"); // 12 digit number
		assertFalse(result);

	}
	
	@Test(expected = NumberFormatException.class)
	public void moreThan13DigitIsbnNotAllowed() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBN("17858879470000"); // 14 digit number
		assertFalse(result);
	}

	@Test(expected = NumberFormatException.class)
	public void nonNumericISBN10AreNotAllowed() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBN("halloworld"); // ISBN-10 with non-numeric characters
		assertFalse(result);	
	}

	@Test(expected = NumberFormatException.class)
	public void nonNumericISBN13AreNotAllowed() {
		ValidateISBN validator = new ValidateISBN();
		boolean	result = validator.checkISBN("978-0-MMM-40615-7"); // ISBN-13 with non-numeric characters
		assertFalse(result);	
	}
	
	
}

// Example valid 10digit ISBN:
// 067233710X
// 1785887947
// 1786468735

// Examples valid 13 digit ISBN
// 978-0-306-40615-7
// 978-0672337109
