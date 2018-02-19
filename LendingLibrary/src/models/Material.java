package models;

public class Material {
	private int id;
	private String title;
	private String branch;
	
	//	Constructors
	public Material(int id, String title, String branch) {
		this.id = id;
		this.title = title;
		this.branch = branch;
	}
	
	//	public methods
	public String getTitle() {
		return title;
	}

	public int getId() {
		return id;
	}

	public String getBranch() {
		return branch;
	}

	public void relocate(String newBranch) {
		this.branch = newBranch;
	}
	
	public boolean lend(Customer customer) {
	return true;
	}
}
