package models;

public class DVD extends Material {

	private String director;
	private String catalogNo;
	private int runnigTime;
	private boolean licenced;

	public DVD(String id, String title, String branch, String director, String catalogNo, int runnigTime) {
		super(id, title, branch);
		this.director = director;
		this.catalogNo = catalogNo;
		this.runnigTime = runnigTime;
		this.licenced = false;
	}

	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	// private methods
	
	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	// public methods
	@Override
	public int getLoanPeriod() {		//	abstract
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
	
	public boolean getLicence() {
		return licenced;
	}

	public void licence() {
		this.licenced = true;
	}
	
}
