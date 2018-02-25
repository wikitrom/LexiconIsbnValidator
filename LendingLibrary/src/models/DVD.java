package models;

public class DVD extends Material {

	private String director;
	private String catalogNo;
	private int runnigTime;
	private boolean licenced;

	public DVD(String id, String title, String branch, String director, String catalogNo, int runnigTime) {
		this(id, title, branch, director, catalogNo, runnigTime, false);
		
//		super(id, "DVD", title, branch);
//		this.director = director;
//		this.catalogNo = catalogNo;
//		this.runnigTime = runnigTime;
//		this.licenced = false;
	}

	public DVD(String id, String title, String branch, String director, String catalogNo, int runnigTime, boolean licenced) {
		super(id, "DVD", title, branch);
		this.director = director;
		this.catalogNo = catalogNo;
		this.runnigTime = runnigTime;
		this.licenced = licenced;
	}

	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	// private methods

	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	// public methods
	@Override
	public String toString() {
		return getType() + "  " + getId() + " " + getTitle() + " / " + getDirector();
	}

	@Override
	public int getLoanPeriod() { // abstract
		return 7;
	}

	@Override
	public boolean lend(Customer customer) {
		if (licenced) {
			return super.lend(customer);
		} else {
			return false;
		}
	}

	public boolean getLicenced() {
		return licenced;
	}

	public void licence() {
		this.licenced = true;
	}

	public String getDirector() {
		return director;
	}
	
	public int getRunningTime() {
		return runnigTime;
	}
	
	public String getCatalogNumber() {
		return catalogNo;
	}

}
