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
	private int getNextFreeRegistryPosition() throws RegistryNoMoreSpaceException {

		for (int i = 0; i < registry.length; i++) {
			if (registry[i] == null) {
				return i;
			}
		}
		throw new RegistryNoMoreSpaceException();
	}

	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	// public methods

	// addLoan
	public void addLoan(Loan loan) throws RegistryBookNotAvailable, RegistryNoMoreSpaceException {
		if (isBookOnLoan(loan.getBook())) {
			throw new RegistryBookNotAvailable();
		}

		try {
			int insertPosition = getNextFreeRegistryPosition();
			// TODO: if no more space, handle and throw RegistryNoMoreSpace exception.
			registry[insertPosition] = loan;
		} catch (RegistryNoMoreSpaceException e) {
			throw new RegistryNoMoreSpaceException();
		}
	}

	// findLoan
	public Loan findLoan(int bookId) throws RegistryBookNotBorrowedException {
		Loan foundLoan = null;

		for (int i = 0; i < registry.length; i++) {
			if (registry[i] != null) {
				if ((registry[i].getStatus() == LoanStatusType.CURRENT) && registry[i].getBook().getId() == bookId) {
					return registry[i];
				}
			}
		}
		throw new RegistryBookNotBorrowedException();
	}

	// isBookOnLoan
	public boolean isBookOnLoan(Book book) {
		try {
			Loan loan = findLoan(book.getId());
			return true;
		} catch (RegistryBookNotBorrowedException e) {
			return false;
		}
	}
}
