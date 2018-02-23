package models;

import java.util.TreeMap;

public class MaterialCatalog {

	private TreeMap<String, Material> materialMap;
	
	// constructors
	public MaterialCatalog() {
		materialMap = new TreeMap<String, Material>();
	}
	
	// private methods
	
	// public methods
	public int getNumberOfItems() {
		return materialMap.size();
	}
	// TODO: remove
	public int getNumberOfMaterial() {
		return getNumberOfItems();
	}
	
	public void addMaterial(Material newMaterial) {
		materialMap.put(newMaterial.getId(), newMaterial);
	}
	
	public TreeMap<String, Material> getMap() {
		return materialMap;
	}
	
	public Material findMaterial(String title) throws MaterialNotFoundException {
		title = title.trim();

		for (Material element : materialMap.values()) {
			if (element.getTitle().equalsIgnoreCase(title)) {
				return element;
			}
		}
		throw new MaterialNotFoundException();
	}
}
