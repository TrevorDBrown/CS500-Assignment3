/*
 *  Assign3
 *	Trevor D. Brown - 1/31/2019
 *	Dr. Yang - CS 500-500 (Research Methods)
 *
 *	SortItemByQuantity.java - an implementation of the Comparator interface
 */

import java.util.Comparator;

public class SortItemByQuantity implements Comparator<Item>{
	
	// compare - two parameters: item1 and item2; compares quantityInStock values. 
	public int compare(Item item1, Item item2) {
		return item1.getQuantityInStock() - item2.getQuantityInStock();
	}

}
