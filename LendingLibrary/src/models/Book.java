package models;

/**
 * Class representing a Book object.
 * @author Mats - hackingtrom@gmail.com
 * 
 */
public class Book extends Material {

	private String isbn;
	private String author;
	private int pageCount;

	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	// Constructors
	public Book(String id, String title, String author, String isbn, String branch, int pages) {
		super(id, title, branch);
		this.author = author;
		this.isbn = isbn;
		this.pageCount = pages;
	}

	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	// private methods

	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	// public methods
	@Override
	public String toString() {
		return "BOOK: " + getId() + " " + getTitle() + " / " + getAuthor();
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
		return pageCount;
	}

	public void sendForRepair() {
		relocate("Repair shop");
	}
}
