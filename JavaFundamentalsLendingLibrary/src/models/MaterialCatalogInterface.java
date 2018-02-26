package models;

import java.util.Map;

public interface MaterialCatalogInterface {

	public int getNumberOfItems();
	public void addItem(Material item);
	public Map<String, Material> getMap();
	public Material findItem(String title) throws MaterialNotFoundException ;
}
