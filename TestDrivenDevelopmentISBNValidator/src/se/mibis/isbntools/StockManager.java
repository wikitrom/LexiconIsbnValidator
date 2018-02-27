package se.mibis.isbntools;

public class StockManager {

	private ExternalISBNDataServiceInterface service;

	// constructors

	// private methods

	// protected methods - for mocking only
	protected void setService(ExternalISBNDataServiceInterface service) {
		this.service = service;
	}
	
	// public methods
	public String getLocatorCode(String isbn) {

		Book book = service.lookup(isbn);
		StringBuilder locator = new StringBuilder();

		locator.append(isbn.substring(isbn.length() - 4));
		locator.append(book.getAuthor().substring(0, 1));
		locator.append(book.getTitle().split(" ").length);
		return locator.toString();
	}

}
