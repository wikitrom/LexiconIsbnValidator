package models;

import java.util.TreeMap;

public interface MaterialCatalogInterface {

	public int getNumberOfItems();
	public void addItem(Material item);
	public TreeMap<String, Material> getMap();
	public Material findItem(String title) throws MaterialNotFoundException ;
}
