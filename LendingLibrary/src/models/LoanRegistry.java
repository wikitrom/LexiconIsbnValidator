package models;

import uilities.LoanStatusType;

public class LoanRegistry {
	private int maxLoans = 100;
	private Loan[] registry;

	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	// constructors
	public LoanRegistry() {
		registry = new Loan[maxLoans];
	}

	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	// private methods
	private int getNextFreeRegistryPosition() throws RegistryOutOfSpaceException {

		for (int i = 0; i < registry.length; i++) {
			if (registry[i] == null) {
				return i;
			}
		}
		throw new RegistryOutOfSpaceException();
	}

	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	// public methods

	public void addLoan(Loan loan) throws RegistryBookNotAvailableException, RegistryOutOfSpaceException {
		if (isBookOnLoan(loan.getBook())) {
			throw new RegistryBookNotAvailableException();
		}

		try {
			int insertPosition = getNextFreeRegistryPosition();
			registry[insertPosition] = loan;
		} catch (RegistryOutOfSpaceException e) {
			throw new RegistryOutOfSpaceException();
		}
	}

	public Loan findLoan(String bookId) throws RegistryBookNotBorrowedException {
		for (int i = 0; i < registry.length; i++) {
			if (registry[i] != null) {
				if ((registry[i].getStatus() == LoanStatusType.CURRENT)
						&& registry[i].getBook().getId().equals(bookId)) {
					return registry[i];
				}
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
		int noLoans = 0;
		for (int i = 0; i < registry.length; i++) {
			if (registry[i] != null) {
				noLoans++;
			}
		}
		return noLoans;
	}

	public int numberOfActiveLoans() {
		int noActiveLoans = 0;
		for (int i = 0; i < registry.length; i++) {
			if ((registry[i] != null) && registry[i].getStatus() == LoanStatusType.CURRENT) {
				noActiveLoans++;
			}
		}
		return noActiveLoans;
	}
}
