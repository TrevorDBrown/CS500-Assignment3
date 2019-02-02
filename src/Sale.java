/*
 *	Assign3
 *	Trevor D. Brown - 1/31/2019
 *	Dr. Yang - CS 500-500 (Research Methods)
 *
 *	Sale.java - the Sale class; represents a Sale in a given inventory
 */

public class Sale {
	// Properties of a Sale object:
	private int itemID;				// itemID - integer; a unique value per Sale object
	private int quantityOrdered;	// quantityOrdered - integer; the count of how many of the given Item were ordered.
	
	// Sale constructor - two parameters: itemID and quantityOrdered; creates a new Sale object.
	public Sale(int itemID, int quantityOrdered) {
		this.itemID = itemID;
		this.quantityOrdered = quantityOrdered;
	}
	
	// Sale constructor - parameterless (default); used for erroneous cases.
	public Sale() {
		this.itemID = -1;
		this.quantityOrdered = -1;
	}
	
	// getItemID - parameterless; returns the itemID associated with the Sale object.
	public int getItemID() {
		return this.itemID;
	}
	
	// setItemID - one parameter: newItemID; replaces the itemID of the Sale object.
	public void setItemID(int newItemID) {
		this.itemID = newItemID;
	}
	
	// getQuantityOrdered - parameterless; returns the quantityOrdered of the Sale object.
	public int getQuantityOrdered() {
		return this.quantityOrdered;
	}
	
	// setQuantityOrdered - one parameter: newQuantityOrdered; sets a new quantity of the Sale object.
	public void setQuantityOrdered(int newQuantityOrdered) {
		this.quantityOrdered = newQuantityOrdered;
	}
	
	// toString - parameterless; returns a logically formatted string representing a Sale object.
	public String toString() {
		return this.itemID + " " + this.quantityOrdered;
	}

}
