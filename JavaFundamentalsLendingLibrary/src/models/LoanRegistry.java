package models;

import java.util.ArrayList;

import utilities.LoanStatusType;

public class LoanRegistry {
	private ArrayList<Loan> registry;

	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	// constructors
	public LoanRegistry() {
		registry = new ArrayList<Loan>();
	}

	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	// private methods
//	private int getNextFreeRegistryPosition() throws RegistryOutOfSpaceException {
//
//		for (int i = 0; i < registry.length; i++) {
//			if (registry[i] == null) {
//				return i;
//			}
//		}
//		throw new RegistryOutOfSpaceException();
//	}

	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	// public methods

	public void addLoan(Loan loan) throws RegistryBookNotAvailableException {
		if (isBookOnLoan(loan.getBook())) {
			throw new RegistryBookNotAvailableException();
		}
		registry.add(loan);
	}

	public Loan findLoan(String bookId) throws RegistryBookNotBorrowedException {
		for (Loan loan : registry) {
			if (loan.getStatus() == LoanStatusType.CURRENT && loan.getBook().getId().equals(bookId)) {
				return loan;
			}
		}
		throw new RegistryBookNotBorrowedException();
	}

	public boolean isBookOnLoan(Book book) {
		try {
			Loan loan = findLoan(book.getId());
			return true;
		} catch (RegistryBookNotBorrowedException e) {
			return false;
		}
	}

	
	// bonus methods
	public int numberOfRegsteredLoans() {
		return registry.size();
	}

	public int numberOfActiveLoans() {
		int noActiveLoans = 0;
		for (Loan loan : registry) 
		{
			if (loan.getStatus() == LoanStatusType.CURRENT) {
				noActiveLoans++;
			}
		}
		return noActiveLoans;
	}
}
