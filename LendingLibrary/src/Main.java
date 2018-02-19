
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

//		Customer henrik = new Customer("Mr", "Henrik", "�man", "unknown", "+46555555555", "unknown", GenderType.MALE);
//		Customer mats = new Customer("Mr", "Mats", "Bergstr�m");
//		Customer tove = new Customer("Miss", "Tove", "Hult");		
//		
//		System.out.println("Customer number: " + mats.getCustomerId() +
//				" Mailing name: " + mats.getMailingName() +
//				" Gender: " + mats.getGender());
//		System.out.println("Customer number: " + tove.getCustomerId() +
//				"  Mailing name: " + tove.getMailingName() +
//				" Gender: " + tove.getGender());
//		System.out.println("Customer number: " + henrik.getCustomerId() +
//				" Mailing name: " + henrik.getMailingName() +
//				" Gender: " + henrik.getGender());
//		
//		
//		
//		System.out.println(tove.getMailingName());
//		System.out.println("Adress: " + henrik.getAddress()	+ "\nPhone: " + henrik.getPhoneNumber());
//		System.out.println("Total number of customers: " + Customer.getNumberOfCustomers());
