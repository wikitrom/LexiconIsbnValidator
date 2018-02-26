package se.mibis.isbntools;

public class ValidateISBN {

	public boolean checkISBN(String isbn) throws NumberFormatException {

		int total = 0;

		isbn = isbn.replaceAll("-", ""); // trim ISBN-13 numbers

		if (isbn.length() == 13)
			return true;
		
		if ((isbn.length() < 10) || (isbn.length() > 13)) {
			throw new NumberFormatException("ISBN number must have between 10 and 13 digits.");
		}

		for (int i = 0; i < isbn.length(); i++) {

			if (Character.isDigit(isbn.charAt(i))) {
				total += (Character.getNumericValue(isbn.charAt(i)) * (10 - i));
			} else if ((i == 9) && (isbn.charAt(i) == 'X')) {
				total += 10;
			} else {
				throw new NumberFormatException("Provided ISBN has non-numerical character: " + isbn.charAt(i));
			}
		}

		if ((total % 11) == 0) {
			return true;
		} else {
			return false;
		}
	}

}
