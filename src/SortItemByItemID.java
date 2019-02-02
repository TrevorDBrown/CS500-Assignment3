/*
 *  Assign3
 *	Trevor D. Brown - 1/31/2019
 *	Dr. Yang - CS 500-500 (Research Methods)
 *
 *	SortItemByItemID.java - an implementation of the Comparator interface
 */

import java.util.Comparator;

public class SortItemByItemID implements Comparator<Item>{
	
	// compare - two parameters: item1 and item2; compares itemID values. 
	public int compare(Item item1, Item item2) {
		return item1.getItemID() - item2.getItemID();
	}
}
