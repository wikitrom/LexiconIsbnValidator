package models;

import java.util.Date;
import java.util.GregorianCalendar;

import uilities.GenderType;

public class Customer {

	private static int customerIdCount = 0;
	private int customerId;
	boolean isValid = false;
	private String title, firstName, surname;
	private String address, phoneNumber, email;
	private GenderType gender;
	private Date expiryDate;

	// Constructors
	public Customer(String title, String firstName, String surname) {
		this(title, firstName, surname, "unknown", "unknown", "unknown", GenderType.UNKNOWN);
	}

	public Customer(String title, String firstName, String surname, String address, String phoneNumber, String email,
			GenderType gender) {
		GregorianCalendar gCal = new GregorianCalendar();
		gCal.add(GregorianCalendar.YEAR, 1);

		this.customerId = ++customerIdCount;
		this.isValid = true;
		setExpiryDate(gCal.getTime());
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
	@Override
	public String toString() {
		return getMailingName();
	}

	@Override // generated
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + customerId;
		result = prime * result + (isValid ? 1231 : 1237);
		return result;
	}

	@Override // generated
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (customerId != other.customerId)
			return false;
		if (isValid != other.isValid)
			return false;
		return true;
	}

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

	public String getFistName() {
		return firstName;
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

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

}
