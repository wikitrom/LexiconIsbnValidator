package se.mibis.isbntools;

public class StockManager {

	private ExternalISBNDataServiceInterface webService;
	private ExternalISBNDataServiceInterface dbService;

	// constructors

	// private methods

	protected void setDbService(ExternalISBNDataServiceInterface dbService) {
		this.dbService = dbService;
	}

	// protected methods - for testing only
	protected void setWebService(ExternalISBNDataServiceInterface webService) {
		this.webService = webService;
	}

	// public methods
	public String getLocatorCode(String isbn) {
		Book book = dbService.lookup(isbn);

		if (book == null) {
			book = webService.lookup(isbn);
		}
		StringBuilder locator = new StringBuilder();

		locator.append(isbn.substring(isbn.length() - 4));
		locator.append(book.getAuthor().substring(0, 1));
		locator.append(book.getTitle().split(" ").length);
		return locator.toString();
	}

}
