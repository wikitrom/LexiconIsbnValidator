package models;
import uilities.GenderType;

public class Customer {

	private static int customerIdCount = 0;
	private int customerId;
	boolean isValid = false;
	private String title, firstName, surname;
	private String address, phoneNumber, email;
	private GenderType gender;

	// Constructors
	public Customer(String title, String firstName, String surname) {
		this.customerId = ++customerIdCount;
		this.isValid = true;
		setName(title, firstName, surname);
		setAddress("unknown");
		setPhoneNumber("unknown");
		setEmail("unknown");
		setGender(GenderType.UNKNOWN);
	}

	public Customer(String title, String firstName, String surname, String address, String phoneNumber, String email,
			GenderType gender) {
		this.customerId = ++customerIdCount;
		this.isValid = true;
		setName(title, firstName, surname);
		setAddress(address);
		setPhoneNumber(phoneNumber);
		setEmail(email);
		setGender(gender);
	}

	// Private methods
	private void setName(String title, String firstName, String surname) {
		this.title = title;
		this.firstName = firstName;
		this.surname = surname;
	}

	// Public methods
	public static int getNumberOfCustomers() {
		return customerIdCount;
	}

	public String getMailingName() {
		StringBuilder sb = new StringBuilder(title);
		sb.append(" ");
		sb.append(firstName.substring(0, 1));
		sb.append(" ");
		sb.append(surname);
		return (sb.toString());
	}

	public int getCustomerId() {
		return customerId;
	}

	// Public methods - generated
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public GenderType getGender() {
		return gender;
	}

	public void setGender(GenderType gender) {
		this.gender = gender;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

}
