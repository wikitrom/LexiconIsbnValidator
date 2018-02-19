
public class BookCatalog {

	private Book[] bookArray = new Book[100];
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

	public Book findBook(String title) {
		for (int i = 0; i < nextPosition; i++) {
			if (bookArray[i].getTitle().equalsIgnoreCase(title)) {
				return bookArray[i];
			}
		}
		return null;
	}
}
