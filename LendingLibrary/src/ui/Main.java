package ui;

import java.text.NumberFormat;
import java.util.Locale;

import models.Book;
import models.BookCatalog;
import models.BookNotFoundException;
import models.Customer;
import models.DVD;
import uilities.GenderType;

public class Main {

	public static void main(String[] args) {

		// double d = 1.2345;
		// Locale sweden = new Locale("se", "se");
		// NumberFormat nf = NumberFormat.getNumberInstance(sweden);
		// System.out.println(nf.format(d));

		BookCatalog bookCatalog = new BookCatalog();

		Book book1 = new Book(1, "Introduction to Java", "Mats Bergstroem", "009955551112", "1st branch", 300);
		Book book2 = new Book(2, "Introduction to C", "Mats Bergstroem", "009955551113", "1st branch", 50);
		Book book3 = new Book(3, "Dummy book", "Mats Bergstroem", "009955551114", "2nd branch", 22);
		UI ui = new UI();

		bookCatalog.addBook(book1);
		bookCatalog.addBook(book2);
		bookCatalog.addBook(book3);

		Customer customer1 = new Customer("Mr", "Nisse", "Hult", "Java avenue 42", "+468555555", "hallo@wrold.com",
				GenderType.MALE);
		Customer customer2 = new Customer("Ms", "Lisa", "Simpson", "Java road 1", "+468555555", "hallo@wrold.com",
				GenderType.FEMALE);
		Customer customer3 = new Customer("Mr", "James", "Kirk");

		DVD dvd1 = new DVD(100, "Mitt liv som hund", "dvd branch", "Lasse Hellstroem", "dvd-m-l-s-h-42", 95);
		DVD dvd2 = new DVD(100, "Mitt liv som hund", "dvd branch", "Lasse Hellstroem", "dvd-m-l-s-h-42", 95);

		ui.printHeader();
		ui.printBookCatalog(bookCatalog.getBookArray());

		// System.out.println(book1.getTitle() + " is at " + book1.getBranch());
		// book1.relocate("2nd branch");
		// System.out.println(book1.getTitle() + " is at " + book1.getBranch());
		//
		// System.out.println(book2.getTitle() + " is at " + book2.getBranch());
		// book2.sendForRepair();
		// System.out.println(book2.getTitle() + " is at " + book2.getBranch());

		try {
			Book foundBook = bookCatalog.findBook("dummy book");
			if (foundBook != null) {
				System.out.println("Found the book titled \"" + foundBook.getTitle() + "\"");
			}
		} catch (BookNotFoundException e) {
			System.out.println("Book not found!");
		}

		System.out.println(customer3.getMailingName());
		System.out.println(customer3.getExpiryDate());

		System.out.println(customer3);
		System.out.println(dvd1);
		System.out.println(book2);
		System.out.println(dvd1.equals(dvd2));
		System.out.println(dvd1.equals(null));

		/*
		 * // try lending dvd
		 * 
		 * // dvd NOT licenced System.out.println(dvd1.getTitle() + " licence is : " +
		 * dvd1.getLicence()); // System.out.println(dvd1.getTitle() + " is lent out: "
		 * + dvd1.lend(customer)); System.out.println("Lending out " + dvd1.getTitle() +
		 * " is sucess: " + dvd1.lend(customer1)); System.out.println(dvd1.getTitle() +
		 * " is lent out to " + dvd1.getBorrowerMailingName());
		 * 
		 * // dvd is licenced dvd1.licence(); System.out.println(dvd1.getTitle() +
		 * " licence is : " + dvd1.getLicence()); System.out.println("Lending out " +
		 * dvd1.getTitle() + " is sucess: " + dvd1.lend(customer1));
		 * System.out.println(dvd1.getTitle() + " is lent out to " +
		 * dvd1.getBorrowerMailingName());
		 * 
		 * // lend out dvd twice System.out.println("Lending out " + dvd1.getTitle() +
		 * " is sucess: " + dvd1.lend(customer1));
		 * 
		 * // test lending out book1 System.out.println(book1.getTitle() +
		 * " is lent out to " + book1.getBorrowerMailingName());
		 * System.out.println("Lending out " + book1.getTitle() + " is sucess: " +
		 * book1.lend(customer2)); System.out.println(book1.getTitle() +
		 * " is lent out to " + book1.getBorrowerMailingName());
		 * 
		 * // lend out twice System.out.println("Lending out " + book1.getTitle() +
		 * " is sucess: " + book1.lend(customer2));
		 * 
		 * // return borrowed item System.out.println("Returning lent item " +
		 * book1.getTitle() + " is sucess: " + book1.returnItem());
		 * System.out.println(book1.getTitle() + " is lent out to " +
		 * book1.getBorrowerMailingName());
		 * 
		 * // lend out again, other customer System.out.println("Lending out " +
		 * book1.getTitle() + " is sucess: " + book1.lend(customer1));
		 * System.out.println(book1.getTitle() + " is lent out to " +
		 * book1.getBorrowerMailingName());
		 * 
		 * // test loan period System.out.println("Loan period for " + dvd1.getTitle() +
		 * " is " + dvd1.getLoanPeriod() + " days");
		 * System.out.println("Loan period for " + book1.getTitle() + " is " +
		 * book1.getLoanPeriod() + " days");
		 * 
		 */

	}
}

// Date today = new Date();
// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMM-dd");
// GregorianCalendar gCal = new GregorianCalendar(2019,00,01);
// gCal.add(GregorianCalendar.WEEK_OF_YEAR,13);
// Date myDate = gCal.getTime();
//
// System.out.println(sdf.format(myDate));
