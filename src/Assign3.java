/*
 *	Assign3
 *	Trevor D. Brown - 1/31/2019
 *	Dr. Yang - CS 500-500 (Research Methods)
 *
 *	Assign2.java - the main class for the program (includes main method)
 */

// Import Objects
import java.util.Collections;	// Collections object
import java.util.Scanner;		// Scanner object
import java.io.*;				// IO package

public class Assign3 {

	// main - main method for program.
	public static void main(String[] args) {
		// Declare an Inventory object, to store multiple Item objects
		Inventory ourInventory = new Inventory();
		
		// Read the contents of the inventory.txt file, and store its content as Item objects in ourInventory.
		readInventoryFile(ourInventory);
		
		// Read the contents of the sold.txt file, and store its content as Sale objects in ourInventory.
		readSalesFile(ourInventory);
		
		// Compute the restock amount, based on sales.
		ourInventory.computeRestock();
		
		// Execute tasks
		task1(ourInventory);
		task2(ourInventory);
		task3(ourInventory);
	}
	
	// void readInventoryFile(Inventory ourInventory) - opens and stores content of inventory.txt to given Inventory object.
	public static void readInventoryFile(Inventory ourInventory) {
		// Declare variables to be used in method:
		File inventoryFile = new File("inventory.txt");		// inventory.txt File object
		Scanner fin;		// Scanner object
		
		// Try/catch for reading inventory file.
		try {
			fin = new Scanner(inventoryFile);
			
			// While more content exists in the file, read the next line
			while(fin.hasNextLine()) {
				// Store the line of content as a new Item object.
				ourInventory.addItem(fin.nextInt(), fin.nextInt());
			}
			
			// Close the Scanner object.
			fin.close();
			
		}catch(Exception e) {
			// If any exception occurs, print the stack trace to the console.
			e.printStackTrace();
		}
	}
	
	// void readSalesFile(Inventory ourInventory) - opens and stores content of sold.txt to given Inventory object.
	public static void readSalesFile(Inventory ourInventory) {
		// Declare variables to be used in method:
		File salesFile = new File("sold.txt");		// sold.txt File object
		Scanner fin;		// Scanner object
		
		// Try/catch for reading sales file.
		try {
			fin = new Scanner(salesFile);
			
			// While the file has another integer, read the next value.
			while(fin.hasNextInt()) {
				// Store the integer as a new Sale object (or add to existing Sale object, if already stored before).
				ourInventory.addSale(fin.nextInt());
			}
			
			// Close the Scanner object.
			fin.close();
			
		}catch (Exception e) {
			// If any exception occurs, print the stack trace to the console.
			e.printStackTrace();
		}
		
	}
	
	// Task 1: Total Number of Items Sold, Total Number of times to reorder
	public static void task1(Inventory ourInventory) {
		System.out.println("Task 1: ");
		// Print total number of items sold:
		System.out.println("Total number of items sold: " + ourInventory.getNumberOfItemsSold());
		// Print total number of times to re-order:
		System.out.println("Total number of times to re-order: " + ourInventory.getNumberOfItemsRestocked() + "\n");
	}
	
	// Task 2: Display sorted list of items to re-order:
	public static void task2(Inventory ourInventory) {
		System.out.println("Task 2:");
		// Sort ourInventory by Quantity In Stock
		Collections.sort(ourInventory.getAllItems(), new SortItemByItemID());
		System.out.println("Sorted list of items to re-order: ");
		ourInventory.printAllRestock();
	}
	
	// Task 3: Display the id for the appliance which has the highest number in stock
	public static void task3(Inventory ourInventory) {
		System.out.println("Task 3:");
		Collections.sort(ourInventory.getAllSales(), new SortSalesByQuantityOrdered());
		System.out.println("Sorted list of items sold:");
		ourInventory.printAllSales();
	}

}
