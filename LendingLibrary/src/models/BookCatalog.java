package models;

import java.util.HashMap;

public class BookCatalog {
	private HashMap<String, Book> bookMap;

	// constructors
	public BookCatalog() {
		bookMap = new HashMap<String, Book>();
	}

	// public methods
	public HashMap<String, Book> getBookMap() {
		return bookMap;
	}

	public int getNumberOfBooks() {
		return bookMap.size();
	}

	public void addBook(Book newBook) {
		bookMap.put(newBook.getId(), newBook);
	}

	public Book findBook(String title) throws BookNotFoundException {
		title = title.trim();

		for (Book element : bookMap.values()) {
			if (element.getTitle().equalsIgnoreCase(title)) {
				return element;
			}
		}
		throw new BookNotFoundException();
	}
}
