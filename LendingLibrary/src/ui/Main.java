package ui;
import java.text.NumberFormat;
import java.util.Locale;

import models.Book;
import models.BookCatalog;
import models.Customer;
import models.DVD;
import uilities.GenderType;

public class Main {

	public static void main(String[] args) {

//		double d = 1.2345;
//		Locale sweden = new Locale("se", "se");
//		NumberFormat nf = NumberFormat.getNumberInstance(sweden);
//		System.out.println(nf.format(d));
		
		BookCatalog bookCatalog = new BookCatalog();
		
		Book book1 = new Book(1, "Introduction to Java", "Mats Bergström", "009955551112", "1st branch", 300);		
		Book book2 = new Book(2, "Introduction to C", "Mats Bergström", "009955551113", "1st branch", 50);
		Book book3 = new Book(3, "Dummy book", "Mats Bergström", "009955551114","2nd branch", 22);
		UI ui = new UI();
		
		bookCatalog.addBook(book1);
		bookCatalog.addBook(book2);
		bookCatalog.addBook(book3);
				
		ui.printHeader();
		ui.printBookCatalog(bookCatalog.getBookArray());
		
		System.out.println(book1.getTitle() + " is at " + book1.getBranch());
		book1.relocate("2nd  branch");
		System.out.println(book1.getTitle() + " is at " + book1.getBranch());
		
		Book foundBook = bookCatalog.findBook("dummy book");
		if (foundBook != null) {
			System.out.println("Found the book titled \"" + foundBook.getTitle() + "\"");
		}
		
		Customer customer = new Customer("Mr", "Nisse", "Hult", "Javavägen 1", "+468555555","hallo@wrold.com", GenderType.MALE);
		System.out.println(customer.getExpiryDate());
		System.out.println(customer.getMailingName());
		
		DVD dvd1 = new DVD(100, "Mitt liv som hund", "dvd branch", "Lasse Hellström", "dvd-m-l-s-h-42", 95);
		System.out.println(dvd1.getTitle());		
		System.out.println(dvd1.lend(customer));
		System.out.println(dvd1.getTitle() + " licence is : " + dvd1.getLicence());
		dvd1.licence();
		System.out.println(dvd1.getTitle() + " licence is : " + dvd1.getLicence());
		
		
		System.out.println(book2.getTitle() + " is at " + book2.getBranch());
		book2.sendForRepair();
		System.out.println(book2.getTitle() + " is at " + book2.getBranch());		
	}
}

//		Date today = new Date();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMM-dd");
//		GregorianCalendar gCal = new GregorianCalendar(2019,00,01);
//		gCal.add(GregorianCalendar.WEEK_OF_YEAR,13);				
//		Date myDate =  gCal.getTime();
//		
//		System.out.println(sdf.format(myDate));
		
