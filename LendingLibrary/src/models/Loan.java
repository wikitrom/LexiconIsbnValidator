package models;

import java.util.Date;
import java.util.GregorianCalendar;

import uilities.LoanStatusType;

public class Loan {
	private static int idCount = 0; // keep track of next available id
	private int id;
	private Customer customer;
	private Book book;
	private Date startDate, dueDate, returnDate;
	private LoanStatusType status;

	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	// constructors
	public Loan(Customer customer, Book book) {
		id = ++idCount;
		this.customer = customer;
		this.book = book;
		this.status = LoanStatusType.CURRENT;
		startDate = new Date();

		// due date is 2 weeks from now
		GregorianCalendar gCal = new GregorianCalendar();
		gCal.add(GregorianCalendar.DAY_OF_YEAR, 14);
		setDueDate(gCal.getTime());
	}

	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	// private methods
	private void setDueDate(Date expiryDate) {
		dueDate = expiryDate;
	}

	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	// public methods
	@Override
	public String toString() {
		// FIX: returnDate might be null
		return "Loan [id=" + id + ", customer=" + customer.getMailingName() + ", book=" + book.getTitle()
				+ ", startDate=" + startDate.toString() + ", dueDate=" + dueDate.toString() + ", returnDate="
				+ returnDate.toString() + ", status=" + status.toString() + "]";
	}

	// @Override
	// public int hashCode() {
	// final int prime = 31;
	// int result = 1;
	// result = prime * result + id;
	// return result;
	// }

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Loan other = (Loan) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public Customer getCustomer() {
		return customer;
	}

	public Book getBook() {
		return book;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public LoanStatusType getStatus() {
		return status;
	}
	public void endLoan(Loan loan) {
		status = LoanStatusType.HISTORIC;
		returnDate = new Date();
	}
	
	// Date today = new Date();
	// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMM-dd");
	// GregorianCalendar gCal = new GregorianCalendar(2019,00,01);
	// gCal.add(GregorianCalendar.WEEK_OF_YEAR,13);
	// Date myDate = gCal.getTime();
	//
	// System.out.println(sdf.format(myDate));

}
