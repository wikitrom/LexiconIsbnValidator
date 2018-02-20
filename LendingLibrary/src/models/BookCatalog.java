package models;

public class BookCatalog {
	private int catalogSize = 100;
	private Book[] bookArray = new Book[catalogSize];
	private int nextPosition = 0;

	// constructors

	// public methods
	public Book[] getBookArray() {
		return bookArray;
	}

	public void addBook(Book newBook) {
		bookArray[nextPosition] = newBook;
		nextPosition++;
	}

	public Book findBook(String title) throws BookNotFoundException {
		for (int i = 0; i < catalogSize; i++) {
			try {
				if (bookArray[i].getTitle().equalsIgnoreCase(title)) {
					return bookArray[i];
				}
			} catch (Exception e) {
				throw new BookNotFoundException();
			}
		}
		return null;
	}
}
