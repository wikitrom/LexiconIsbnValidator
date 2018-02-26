package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author uabtrom
 *
 */
public class MaterialCatalogDatabaseVersion implements MaterialCatalogInterface {

	public MaterialCatalogDatabaseVersion() {
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");

		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public int getNumberOfItems() {
		try {
			// connect to DB
			try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:50000/library")) {
				try (Statement stm = conn.createStatement()) {
					// execute query
					try (ResultSet rs = stm.executeQuery("select count(id) from materials")) {
						rs.next();
						return rs.getInt(1);
					}
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally { // clean-up

		}
	}

	@Override
	public void addItem(Material item) {

		try {
			// connect to DB
			try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:50000/library")) {

				// prepare statement and execute
				if (item instanceof Book) {
					String sql = "insert into materials (barcode,title,author,isbn,numberofpages,branch,type) values(?,?,?,?,?,?,'BOOK')";
					try (PreparedStatement stm = conn.prepareStatement(sql)) {
						stm.setString(1, item.getId());
						stm.setString(2, item.getTitle());
						stm.setString(3, ((Book) item).getAuthor());
						stm.setString(4, ((Book) item).getIsbn());
						stm.setInt(5, ((Book) item).getPageCount());
						stm.setString(6, item.getBranch());

						int result = stm.executeUpdate();

						System.out.println("BOOK records added; " + result);

					}
				} else if (item instanceof DVD) {
					String sql = "insert into materials (barcode,title,catalognumber,runningtime,licenced,branch,type) values(?,?,?,?,?,?,'DVD')";
					try (PreparedStatement stm = conn.prepareStatement(sql)) {
						stm.setString(1, item.getId());
						stm.setString(2, item.getTitle());
						stm.setString(3, ((DVD) item).getCatalogNumber());
						stm.setInt(4, ((DVD) item).getRunningTime());
						stm.setBoolean(5, ((DVD) item).getLicenced());
						stm.setString(6, item.getBranch());

						int result = stm.executeUpdate();

						System.out.println("DVD records added; " + result);
					}
				}

			}
		} catch (SQLException e) {

			System.out.println("Something went wrong!");
			System.err.println(e);

		} finally { // clean-up

		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see models.MaterialCatalogInterface#getMap()
	 */
	@Override
	public Map<String, Material> getMap() {
		Map<String, Material> materialMap = new TreeMap<String, Material>();

		try {
			// connect to DB
			try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:50000/library")) {
				try (Statement stm = conn.createStatement()) {
					// execute query
					String query = "SELECT * FROM materials";
					try (ResultSet rs = stm.executeQuery(query)) {
						while (rs.next()) { // parse all entries
							String id, title, author, isbn, branch, type, catalogNumber, director;
							Integer runningTime, numberOfPages;
							Boolean licenced;

							// retrieve material common data
							id = rs.getString("BARCODE"); // not same as ID in DB-table
							type = rs.getString("TYPE");
							title = rs.getString("TITLE");
							branch = rs.getString("BRANCH");

							// check type and retrieve type specific data
							if (type.equalsIgnoreCase("book")) { // we found a book
								author = rs.getString("AUTHOR");
								isbn = rs.getString("ISBN");
								numberOfPages = rs.getInt("NUMBEROFPAGES");

								Book item = new Book(id, title, author, isbn, branch, numberOfPages);
								materialMap.put(item.getId(), item);

							} else if (type.equalsIgnoreCase("dvd")) { // we found a dvd
								director = rs.getString("DIRECTOR");
								catalogNumber = rs.getString("CATALOGNUMBER");
								runningTime = rs.getInt("RUNNINGTIME");
								licenced = rs.getBoolean("LICENCED");

								DVD item = new DVD(id, title, branch, director, catalogNumber, runningTime, licenced);
								materialMap.put(item.getId(), item);
							} else { // we found something of unknown type
								// just skip the item
							}
						}
					}
					return materialMap;
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Material findItem(String findTitle) throws MaterialNotFoundException {

		try {
			// connect to DB
			try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:50000/library")) {
				try (Statement stm = conn.createStatement()) {
					// execute query
					String query = "SELECT * FROM materials WHERE title LIKE '%" + findTitle + "%'";
					try (ResultSet rs = stm.executeQuery(query)) {
						if (rs.next()) {
							// we found an item with matching title
							String id, title, author, isbn, branch, type, catalogNumber, director;
							Integer runningTime, numberOfPages;
							Boolean licenced;

							// retrieve material common data
							id = rs.getString("BARCODE"); // item ID, not same as ID in DB-table
							type = rs.getString("TYPE");
							title = rs.getString("TITLE");
							branch = rs.getString("BRANCH");

							if (type.equalsIgnoreCase("book")) { // we found a book
								author = rs.getString("AUTHOR");
								isbn = rs.getString("ISBN");
								numberOfPages = rs.getInt("NUMBEROFPAGES");
								Book foundItem = new Book(id, title, author, isbn, branch, numberOfPages);
								return foundItem;
								
							} else if (type.equalsIgnoreCase("dvd")) { // we found a dvd
								director = rs.getString("DIRECTOR");
								catalogNumber = rs.getString("CATALOGNUMBER");
								runningTime = rs.getInt("RUNNINGTIME");
								licenced = rs.getBoolean("LICENCED");
								DVD foundItem = new DVD(id, title, branch, director, catalogNumber, runningTime, licenced);
								return foundItem;
								
							} else { // we found something unknown
								throw new MaterialNotFoundException("Found Material of unknown type.");
							} //
						} else {
							throw new MaterialNotFoundException("No item found!");
						}
					}
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally { // clean-up

		}
	}

}

// FYI: Database table info for table: MATERIAL
// ID |INTEGER |0 |10 |10 |AUTOINCRE&|NULL |NO
// BARCODE |VARCHAR |NULL|NULL|20 |NULL |40 |YES
// TITLE |VARCHAR |NULL|NULL|200 |NULL |400 |YES
// AUTHOR |VARCHAR |NULL|NULL|200 |NULL |400 |YES
// ISBN |VARCHAR |NULL|NULL|20 |NULL |40 |YES
// BRANCH |VARCHAR |NULL|NULL|20 |NULL |40 |YES
// TYPE |VARCHAR |NULL|NULL|6 |NULL |12 |YES
// CATALOGNUMBER |VARCHAR |NULL|NULL|20 |NULL |40 |YES
// RUNNINGTIME |INTEGER |0 |10 |10 |NULL |NULL |YES
// LICENCED |BOOLEAN |NULL|NULL|1 |NULL |NULL |YES
// NUMBEROFPAGES |INTEGER |0 |10 |10 |NULL |NULL |YES
// DIRECTOR
