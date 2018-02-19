package models;

public class DVD extends Material {

	private String director;
	private String catalogNo;
	private int runnigTime;
	private boolean licenced;
	
	public DVD(int id, String title, String branch, String director, String catalogNo, int runnigTime) {
		super(id, title, branch);
		this.director = director;
		this.catalogNo = catalogNo;
		this.runnigTime = runnigTime;
		this.licenced = false; 
	}
	
	// public methods
	public boolean getLicence() {
		return licenced;
	}
	public void licence( ) {
		this.licenced = true;
	}
	
}
