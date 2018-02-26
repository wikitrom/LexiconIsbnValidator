package ui;

import models.Book;
import models.Customer;
import models.DVD;
import models.Material;
import models.MaterialCatalogDatabaseVersion;
import models.MaterialCatalogInterface;
import models.MaterialNotFoundException;
import utilities.GenderType;

public class Main {

	public static void main(String[] args) {

		// MaterialCatalogInterface materialCatalog = new
		// MaterialCatalogMemoryVersion();
		MaterialCatalogInterface materialCatalog = new MaterialCatalogDatabaseVersion();

		Book book1 = new Book("1", "Introduction to Java", "Mats Bergstroem", "009955551112", "1st branch", 300);
		Book book2 = new Book("2", "Introduction to C", "Mats Bergstroem", "009955551113", "1st branch", 50);
		Book book3 = new Book("3", "Dummy book", "Mats Bergstroem", "009955551114", "2nd branch", 22);
		UI ui = new UI();

		Customer customer1 = new Customer("Mr", "Nisse", "Hult", "Java avenue 42", "+468555555", "hallo@wrold.com",
				GenderType.MALE);
		Customer customer2 = new Customer("Ms", "Lisa", "Simpson", "Java road 1", "+468555555", "hallo@wrold.com",
				GenderType.FEMALE);
		Customer customer3 = new Customer("Mr", "James", "Kirk");

		DVD dvd1 = new DVD("100", "Mitt liv som hund", "dvd branch", "Lasse Hellstroem", "dvd-m-l-s-h-42", 95);
		DVD dvd2 = new DVD("101", "Mitt liv som orm", "dvd branch", "Lasse Hellstroem", "dvd-m-l-s-h-42", 95);

//		 materialCatalog.addItem(book1);
//		 materialCatalog.addItem(book2);
//		 materialCatalog.addItem(book3);
//		 materialCatalog.addItem(dvd1);
//		 materialCatalog.addItem(dvd2);

		System.out.println("Checking for book with word 'dummy'in its title");
		try {
			Material foundBook = materialCatalog.findItem("Dummy");
			System.out.println("Book found with data:" );
			System.out.println(foundBook);
		} 
		catch (MaterialNotFoundException e) {
			System.out.println("Book not found, message: " + e);
		}
		System.out.println();
		ui.printHeader();
		System.out.println("-----------------------------------------------------------------");
		ui.printMaterialCatalog(materialCatalog.getMap());
		System.out.println("-----------------------------------------------------------------");
		System.out.println("Number of items in catalog: " + materialCatalog.getNumberOfItems());

		// try {
		// System.out.println();
		// Material foundBook = materialCatalog.findItem("dummy book");
		// System.out.println("Found the book titled \"" + foundBook.getTitle() + "\"");
		// } catch (MaterialNotFoundException e) {
		// System.out.println("Book not found!");
		// }
		//
		// System.out.println(customer3.getMailingName());
		// System.out.println(customer3.getExpiryDate());
		//
		// System.out.println(customer3);
		// // System.out.println(dvd1);
		// System.out.println(book2);
		// // System.out.println(dvd1.equals(dvd2));
		// // System.out.println(dvd1.equals(null));
		//
		// // TEST loan's
		// LoanRegistry registry = new LoanRegistry();
		//
		// Loan loan1 = new Loan(customer1, book1);
		// Loan loan2 = new Loan(customer1, book2);
		// Loan loan3 = new Loan(customer1, book3);
		// Loan loan4 = new Loan(customer2, book2);
		// Loan loan5 = new Loan(customer1, book2);
		//
		// try {
		// registry.addLoan(loan1);
		// } catch (Exception e) {
		// System.out.println("Caught exception 1: " + e.toString());
		// }
		//
		// try {
		// registry.addLoan(loan2);
		// } catch (Exception e) {
		// System.out.println("Caught exception 2: " + e.toString());
		// }
		// try {
		// registry.addLoan(loan3);
		// } catch (Exception e) {
		// System.out.println("Caught exception 3: " + e.toString());
		// }
		//
		// loan2.endLoan();
		//
		// try {
		// registry.addLoan(loan3);
		// } catch (Exception e) {
		// System.out.println("Caught exception 4: " + e.toString());
		// }
		//
		// try {
		// registry.addLoan(loan2);
		// } catch (Exception e) {
		// System.out.println("Caught exception 5: " + e.toString());
		// }
		//
		// try {
		// registry.addLoan(loan4);
		// } catch (Exception e) {
		// System.out.println("Caught exception 6: " + e.toString());
		// }
		//
		// try {
		// registry.addLoan(loan5);
		// } catch (Exception e) {
		// System.out.println("Caught exception 7: " + e.toString());
		// }
		//
		// System.out.println("Number of registered loanes are " +
		// registry.numberOfRegsteredLoans());
		// System.out.println("Number of currently active loanes are " +
		// registry.numberOfActiveLoans());
		// System.out.println("+++++++++++++++++++++++++");
		// System.out.println(loan1);
		// System.out.println(loan2);
		// System.out.println(loan3);
		// System.out.println(loan4);

	}
}

// Date today = new Date();
// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMM-dd");
// GregorianCalendar gCal = new GregorianCalendar(2019,00,01);
// gCal.add(GregorianCalendar.WEEK_OF_YEAR,13);
// Date myDate = gCal.getTime();
//
// System.out.println(sdf.format(myDate));
