package models.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import models.Book;
import models.BookCatalog;

class BookCatalogTest {

	BookCatalog catalog;
	Book b1, b2, b3;

	@BeforeEach
	void setUp() throws Exception {
		catalog = new BookCatalog();
		b1 = new Book(1, "TEST BOOK 1", "", "", "", 12);
		b2 = new Book(2, "TEST BOOK 2", "", "", "", 12);
		b3 = new Book(3, "TEST BOOK 3", "", "", "", 12);

	}

	@Test
	void testAddBookOneBook() {

		System.out.println("Initial number of books: " + catalog.getNumberOfBooks());
		catalog.addBook(b1);
		assertTrue(1 == catalog.getNumberOfBooks());
	}

	@Test
	void testAddBookOneBookTwice() {

		System.out.println("Initial number of books: " + catalog.getNumberOfBooks());
		catalog.addBook(b1);
		catalog.addBook(b1);
		assertTrue(1 == catalog.getNumberOfBooks()); // HashMap only keep 1 instance for each Key
	}

	@Test
	void testAddBookTwoBooks() {

		System.out.println("Initial number of books: " + catalog.getNumberOfBooks());
		catalog.addBook(b1);
		catalog.addBook(b2);
		assertTrue(2 == catalog.getNumberOfBooks());
	}

}
