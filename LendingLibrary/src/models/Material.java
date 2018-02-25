package models;

public abstract class Material {
	private String id;
	private String type;
	private String title;
	private String branch;
	private Customer borrower;

	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	// constructors
	public Material(String id, String type, String title, String branch) {
		this.id = id;
		this.type = type;
		this.title = title;
		this.branch = branch;
		borrower = null;
	}

	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	// private methods
	private boolean itemIsOnLoan() {
		if (borrower == null) {
			return false;
		} else {
			return true;
		}
	}

	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	// public methods

	// abstract
	public abstract int getLoanPeriod(); // what is the loan period

	@Override
	public String toString() {
		return id + " : " + title;
	}

	@Override
	public boolean equals(Object obj) {
		if ((obj != null) && (getClass() == obj.getClass())) {
			Material item = (Material) obj;
			boolean res = (id == item.id) ? true : false;
			return res;
		} else {
			return false;
		}
	}

	public String getTitle() {
		return title;
	}

	public String getId() {
		return id;
	}

	public String getType() {
		return type;
	}

	public String getBranch() {
		return branch;
	}

	public void relocate(String newBranch) {
		branch = newBranch;
	}

	public boolean lend(Customer customer) {
		if (itemIsOnLoan()) {
			return false;
		} else {
			borrower = customer;
			return true;
		}
	}

	public boolean returnItem() {
		if (itemIsOnLoan()) {
			borrower = null;
			return true;
		} else {
			return false;
		}

	}

	public Customer getBorrower() {
		return borrower;
	}

	public String getBorrowerMailingName() {
		if (itemIsOnLoan()) {
			return borrower.getMailingName();
		} else {
			return "-";
		}
	}

}
