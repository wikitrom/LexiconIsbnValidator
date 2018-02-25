package models;

/**
 * Class representing a Book object.
 * @author Mats - hackingtrom@gmail.com
 * 
 */
public class Book extends Material {

	private String isbn;
	private String author;
	private int numberOfPages;

	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	// Constructors
	public Book(String id, String title, String author, String isbn, String branch, int pages) {
		super(id, "BOOK", title, branch);    // send data to parent object
		this.author = author;
		this.isbn = isbn;
		this.numberOfPages = pages;
	}

	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	// private methods

	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	// public methods
	@Override
	public String toString() {
		return getType() + " " + getId() + " " + getTitle() + " / " + getAuthor();
	}

	@Override
	public int getLoanPeriod() { // abstract
		return 21;
	}

	public String getAuthor() {
		return author;
	}

	public String getIsbn() {
		return isbn;
	}

	public int getPageCount() {
		return numberOfPages;
	}

	public void sendForRepair() {
		relocate("Repair shop");
	}
}
