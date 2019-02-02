/*
 *  Assign3
 *	Trevor D. Brown - 1/31/2019
 *	Dr. Yang - CS 500-500 (Research Methods)
 *
 *	SortSalesByQuantityOrdered.java - an implementation of the Comparator interface
 */

import java.util.Comparator;

public class SortSalesByQuantityOrdered implements Comparator<Sale> {

	// compare - two parameters: item1 and item2; compares restockAmount values. 
	public int compare(Sale sale1, Sale sale2) {
		return sale2.getQuantityOrdered() - sale1.getQuantityOrdered();
	}
}
