package models.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import models.Book;
import models.MaterialCatalogInterface;
import models.MaterialCatalogMemoryVersion;

class MaterialCatalogTest {

	MaterialCatalogInterface catalog;
	Book b1, b2, b3;

	@BeforeEach
	void setUp() throws Exception {
		catalog = new MaterialCatalogMemoryVersion();
		b1 = new Book("1", "TEST BOOK 1", "", "", "", 12);
		b2 = new Book("2", "TEST BOOK 2", "", "", "", 12);
		b3 = new Book("", "TEST BOOK 3", "", "", "", 12);

	}

	@Test
	void testAddBookOneBook() {

//		System.out.println("Initial number of books: " + catalog.getNumberOfItems());
		catalog.addItem(b1);
		assertTrue(1 == catalog.getNumberOfItems());
	}

	@Test
	void testAddBookOneBookTwice() {

//		System.out.println("Initial number of books: " + catalog.getNumberOfItems());
		catalog.addItem(b1);
		catalog.addItem(b1);
		assertTrue(1 == catalog.getNumberOfItems()); // HashMap only keep 1 instance for each Key
	}

	@Test
	void testAddBookTwoBooks() {

//		System.out.println("Initial number of books: " + catalog.getNumberOfItems());
		catalog.addItem(b1);
		catalog.addItem(b2);
		assertTrue(2 == catalog.getNumberOfItems());
	}

}
