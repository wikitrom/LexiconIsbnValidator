package se.mibis.isbntools;

public class ValidateISBN {

	public boolean checkISBN(String isbn) throws NumberFormatException {

		int total = 0;

		isbn = isbn.replaceAll("-", ""); // trim ISBN-13 numbers

		if (isbn.length() == 13) {   // 13-digit ISBN
			int digit;
//			int checksum;

//			for (int i = 0; i < 12; i++) {			
			for (int i = 0; i < 13; i++) {

				if (Character.isDigit(isbn.charAt(i))) {
					digit = Character.getNumericValue(isbn.charAt(i));
					total += (i % 2 == 0) ? digit * 1 : digit * 3;
				} else {
					throw new NumberFormatException("Provided ISBN has non-numerical character: " + isbn.charAt(i));
				}
			}
//			checksum = 10 - (total % 10);
//			if (checksum == 10)
//				checksum = 0;
//			return (checksum == Character.getNumericValue(isbn.charAt(12)));
			return (total % 10== 0) ? true :false;  
			
		} else if (isbn.length() == 10) {
			for (int i = 0; i < 10; i++) {

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

		} else {
			throw new NumberFormatException("An ISBN number must have 10 or 13 digits.");
		}
	}

}
