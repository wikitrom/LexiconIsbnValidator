package ui;
import models.Book;

public class UI {

	public void printHeader() {
		System.out.println("BookID  Title                 Author");;
	}
	
	public void printBook(Book book) {
		
//		String bookIdString = String.valueOf(book.getBookId());
		
//		System.out.println(fixedLengthString(bookIdString , 6) +
//				"  " + fixedLengthString(book.getTitle(),20) +
//				"  " + fixedLengthString(book.getAuthor(), 20));

			System.out.println(fixedLengthString(book.getBookId(), 6) +
				"  " + fixedLengthString(book.getTitle(),20) +
				"  " + fixedLengthString(book.getAuthor(), 20));

	}
	
	private String fixedLengthString(String start, int length) {	
		// TODO: Fix padding problem 
		if (start.length() >= length) {
			return start.substring(0, length);
		} else {
			while (start.length() < length) {
				start += " ";
			}
			return start;
		}
	}
	
	private String fixedLengthString(int number, int length) {	
		// TODO: Fix padding problem 
		
		String start = String.valueOf(number);		
		
//		if (start.length() >= length) {
//			return start.substring(0, length);
//		} else {
//			while (start.length() < length) {
//				start += " ";
//			}
//			return start;
//			
//		}
//		
		
		return fixedLengthString(start, length);
				
	}
	
	public void printBookCatalog(Book[] bookCatalog) {
		for (int c = 0; c < bookCatalog.length; c++)  {
			if (bookCatalog[c] != null) {
				printBook(bookCatalog[c]);
			}
		}
	}
}
