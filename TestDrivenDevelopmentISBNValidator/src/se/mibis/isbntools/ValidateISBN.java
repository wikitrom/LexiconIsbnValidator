package se.mibis.isbntools;

public class ValidateISBN {

	private static final int SHORT_ISBN_LENGTH = 10;
	private static final int SHORT_ISBN_MULTIPLIER = 11;
	private static final int LONG_ISBN_LENGTH = 13;
	private static final int LONG_ISBN_MULTIPLIER = 10;

	public boolean checkISBN(String isbn) throws NumberFormatException {
		isbn = isbn.replaceAll("-", ""); // trim ISBN-13 numbers

		if (isbn.length() == LONG_ISBN_LENGTH) { // 13-digit ISBN
			return isValidLongISBN(isbn);
		} else if (isbn.length() == SHORT_ISBN_LENGTH) {
			return isValidShortISBN(isbn);
		}
		throw new NumberFormatException("An ISBN number must have 10 or 13 digits.");

	}

	private boolean isValidShortISBN(String isbn) {
		int total = 0;

		for (int i = 0; i < SHORT_ISBN_LENGTH; i++) {
			if (Character.isDigit(isbn.charAt(i))) {
				total += (Character.getNumericValue(isbn.charAt(i)) * (SHORT_ISBN_LENGTH - i));
			} else if ((i == 9) && (isbn.charAt(i) == 'X')) {
				total += 10;
			} else {
				throw new NumberFormatException("Provided ISBN has non-numerical character: " + isbn.charAt(i));
			}
		}

		return ((total % SHORT_ISBN_MULTIPLIER) == 0);
	}

	private boolean isValidLongISBN(String isbn) {
		int total = 0;
		int digit = 0;
		// int checksum;

		// for (int i = 0; i < 12; i++) {

		for (int i = 0; i < LONG_ISBN_LENGTH; i++) {
			if (Character.isDigit(isbn.charAt(i))) {
				digit = Character.getNumericValue(isbn.charAt(i));
				total += (i % 2 == 0) ? digit * 1 : digit * 3;
			} else {
				throw new NumberFormatException("Provided ISBN has non-numerical character: " + isbn.charAt(i));
			}
		}
		// checksum = 10 - (total % 10);
		// if (checksum == 10)
		// checksum = 0;
		// return (checksum == Character.getNumericValue(isbn.charAt(12)));
		return (total % LONG_ISBN_MULTIPLIER == 0);
	}

}
