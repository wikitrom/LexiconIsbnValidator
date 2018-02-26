package ui;

import java.util.Map;

import models.Book;
import models.Material;

public class UI {

	public void printHeader() {
		String header = fixedLengthString("Type", 5) + " " + fixedLengthString("ID", 10) + " "
				+ fixedLengthString("Titel", 25) + " " + fixedLengthString("Author/Director", 20);
		System.out.println(header);
		;
	}

	public void printBook(Book book) {

		// String bookIdString = String.valueOf(book.getBookId());

		// System.out.println(fixedLengthString(bookIdString , 6) +
		// " " + fixedLengthString(book.getTitle(),20) +
		// " " + fixedLengthString(book.getAuthor(), 20));

		System.out.println(fixedLengthString(book.getId(), 6) + "  " + fixedLengthString(book.getTitle(), 20) + "  "
				+ fixedLengthString(book.getAuthor(), 20));

	}

	public String fixedLengthString(String start, int length) {
		// TODO: Fix padding problem
		if (start.length() >= length) {
			return start.substring(0, length);
		} else {
			while (start.length() < length) {
				start += " ";
			}
			return start;
		}
	}

	public String fixedLengthString(int number, int length) {
		String start = String.valueOf(number);
		return fixedLengthString(start, length);

	}

	public void printMaterialCatalog(Map<String, Material> materialCatalog) {
		for (Material element : materialCatalog.values()) {
			System.out.println(element.toString());
		}
	}

}
