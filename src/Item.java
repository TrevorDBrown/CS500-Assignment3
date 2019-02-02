/*
 *	Assign3
 *	Trevor D. Brown - 1/31/2019
 *	Dr. Yang - CS 500-500 (Research Methods)
 *
 *	Item.java - the Item class; represents an Item in a given inventory
 */

public class Item {
	// Properties of an Item object
	private int itemID;				// itemID - integer; unique identifier of an Item
	private int quantityInStock;	// quantityInStock - integer; a count of stock for the given item. 
	private int restockAmount;		// restockAmount - integer; a count of the pending restock for the given item.
	
	// Item constructor - two parameters: itemID, quantityInStock
	public Item(int itemID, int quantityInStock) {
		this.itemID = itemID;
		this.quantityInStock = quantityInStock;
		this.restockAmount = 0;
	}
	
	// Item constructor - default, parameterless; for use in erroneous situations.
	public Item() {
		this.itemID = -1;
		this.quantityInStock = -1;
		this.restockAmount = -1;
	}
	
	// getItemID - parameterless; returns the itemID of the Item.
	public int getItemID() {
		return this.itemID;
	}
	
	// setItemID - one parameter; newItemID; replaces the current itemID of the Item.
	public void setItemID(int newItemID) {
		this.itemID = newItemID;
	}
	
	// getQuantityInStock - parameterless; returns the current quantityInStock of the Item.
	public int getQuantityInStock() {
		return this.quantityInStock;
	}
	
	// setQuantityInStock - one parameter: newQuantityInStock; replaces the current quantityInStock of the Item.
	public void setQuantityInStock(int newQuantityInStock) {
		this.quantityInStock = newQuantityInStock;
	}
	
	// getRestockAmount - parameterless; returns the current restockAmount of the Item.
	public int getRestockAmount() {
		return this.restockAmount;
	}
	
	// setRestockAmount - one parameter: newRestockAmount; replaces the current restockAmount of the Item.
	public void setRestockAmount(int newRestockAmount) {
		this.restockAmount = newRestockAmount;
	}
	
	// processRestock - parameterless; adds the restockAmount to quantityInStock, and zeroes out restockAmount.
	public void processRestock() {
		this.quantityInStock += this.restockAmount;
		this.restockAmount = 0;
	}
	
	// toString - parameterless; returns a logical format of the Item's properties.
	public String toString() {
		return this.itemID + " " + this.quantityInStock;
	}

}

