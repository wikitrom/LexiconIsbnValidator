package models;

import java.util.TreeMap;

public class MaterialCatalogMemoryVersion implements MaterialCatalogInterface {

	private TreeMap<String, Material> materialMap;
	
	// constructors
	public MaterialCatalogMemoryVersion() {
		materialMap = new TreeMap<String, Material>();
	}
	
	// private methods
	
	// public methods
	public int getNumberOfItems() {
		return materialMap.size();
	}
	
	public void addItem(Material newItem) {
		materialMap.put(newItem.getId(), newItem);
	}
	
	public TreeMap<String, Material> getMap() {
		return materialMap;
	}
	
	public Material findItem(String title) throws MaterialNotFoundException {
		title = title.trim();

		for (Material element : materialMap.values()) {
			if (element.getTitle().equalsIgnoreCase(title)) {
				return element;
			}
		}
		throw new MaterialNotFoundException();
	}
}
