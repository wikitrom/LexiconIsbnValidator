
public class Main {

	public static void main(String[] args) {

		Book book1 = new Book(1, "Introduction to Java", "Mats Bergström", "009955551112");		
		Book book2 = new Book(2, "Introduction to C", "Mats Bergström", "009955551113");
		Book book3 = new Book(1234567, "Dummy book", "Mats Bergström", "009955551114");
		UI ui = new UI();
		ui.printHeader();
		ui.printBook(book1);
		ui.printBook(book2);
		ui.printBook(book3);
		
	}

}

//		Customer henrik = new Customer("Mr", "Henrik", "Åman", "unknown", "+46555555555", "unknown", GenderType.MALE);
//		Customer mats = new Customer("Mr", "Mats", "Bergström");
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
