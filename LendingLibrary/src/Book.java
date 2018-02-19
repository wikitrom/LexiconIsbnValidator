
public class Book {

	private int bookId;
	private String isbn;
	private String title, author;
	
	// Constructors
	public Book(int bookId, String title, String author, String isbn) {
		this.bookId = bookId;
		this.title = title;
		this.author	= author;
		this.isbn = isbn;
			
	}
	
	// public methods
	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getIsbn() {
		return isbn;
	}

	public int getBookId() {
		return bookId;
	}
}
