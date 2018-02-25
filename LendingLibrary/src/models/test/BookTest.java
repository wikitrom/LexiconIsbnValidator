package models.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import models.Book;

class BookTest {

	private Book book1, book2, book3;
	
	@BeforeEach
	void setUp() throws Exception {
		book1 = new Book("0", "", "", "", "", 0);
		book2 = new Book("1", "", "", "", "", 0);
		book3 = new Book("0", "", "", "", "", 0);

	}

	@Test
	void testEqualBooksExpectTrue() {

		assertTrue(book1.equals(book3));
	}

	@Test
	void testNonEqualBooksExpectFalse() {

		assertFalse(book1.equals(book2));
	}

}
