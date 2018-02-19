package ui;
import models.Book;
import models.BookCatalog;

public class Main {

	public static void main(String[] args) {

		BookCatalog bookCatalog = new BookCatalog();
		
		Book book1 = new Book(1, "Introduction to Java", "Mats Bergström", "009955551112");		
		Book book2 = new Book(2, "Introduction to C", "Mats Bergström", "009955551113");
		Book book3 = new Book(3, "Dummy book", "Mats Bergström", "009955551114");
		UI ui = new UI();
		
		bookCatalog.addBook(book1);
		bookCatalog.addBook(book2);
		bookCatalog.addBook(book3);
				
		ui.printHeader();
		ui.printBookCatalog(bookCatalog.getBookArray());

		
		Book foundBook = bookCatalog.findBook("dummy book");
		if (foundBook != null) {
			System.out.println("Found the book titled \"" + foundBook.getTitle() + "\"");
		}
	}

}
