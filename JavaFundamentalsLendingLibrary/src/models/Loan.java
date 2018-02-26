package models;

import java.util.Date;
import java.util.GregorianCalendar;

import utilities.LoanStatusType;

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
		setDueDate(startDate, 14);
	}

	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	// private methods
	private void setDueDate(Date now, int daysOffset) {
		// due date is 2 weeks from now
		GregorianCalendar gCal = new GregorianCalendar();
		gCal.setTime(now);
		gCal.add(GregorianCalendar.DAY_OF_YEAR, daysOffset);
		dueDate = gCal.getTime();
	}

	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	// public methods
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("Loan id=");
		sb.append(id);
		sb.append(":\n-------------------");
		sb.append("\nStatus: ");
		sb.append(status.toString());
		sb.append("\nCustomer: ");
		sb.append(customer.getMailingName());
		sb.append("\nBook: ");
		sb.append(book.getTitle());
		sb.append("\nLent on: ");
		sb.append(startDate.toString());
		sb.append("\nDue: ");
		sb.append(dueDate.toString());
		sb.append("\nReturned on: ");
		if (returnDate != null) {
			sb.append(returnDate.toString());
		} else {
			sb.append("-");
		}
		return sb.toString();
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

	public void endLoan() {
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
