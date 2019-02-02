/*
 *	Assign3
 *	Trevor D. Brown - 1/31/2019
 *	Dr. Yang - CS 500-500 (Research Methods)
 *
 *	Inventory.java - the Inventory class, which represents the inventory of a given store.
 */

import java.util.*;		// util Package

public class Inventory {
		// Properties of an Inventory object
		ArrayList<Item> ourItems;		// ourItems - ArrayList<Items>; stores all items in the store.
		ArrayList<Sale> ourSales;
		
		// Inventory constructor - default, parameterless; initializes the ourItems property.
		public Inventory() {
			ourItems = new ArrayList<>();
			ourSales = new ArrayList<>();
		}
		
		/* The following code is related to inventory items */
		
		/*
		 * addItem - two parameters: itemID and quantityInStock; passes parameter to Item constructor, and
		 * adds new item to the ourItems ArrayList.
		 */
		public void addItem(int itemID, int quantityInStock) {
			this.ourItems.add(new Item(itemID, quantityInStock));
		}
		
		
		/*
		 * getItem(int itemID) - one parameter: itemID; finds the Item specified by itemID.
		 */
		public Item getItem(int itemID) {
			for (Item item: ourItems) {
				if (item.getItemID() == itemID) {
					return item;
				}
			}
			
			return new Item();
		}
		
		/*
		 * getAllItems - parameterless; returns the entire ArrayList<Item>
		 */
		public ArrayList<Item> getAllItems(){
			return this.ourItems;
		}
		
		/*
		 * getTotalItemsInStock - parameterless; returns the size of the ArrayList<Item>
		 */
		public int getTotalItemsInStock() {
			return this.ourItems.size();
		}
		
		/*
		 * getTotalQuantityInStock - parameterless; returns the total quantity in stock 
		 * (collective for all items)
		 */
		public int getTotalQuantityInStock() {
			int total = 0;
			
			for (Item item: this.ourItems) {
				total += item.getQuantityInStock();
			}
			
			return total;
		}
		
		/*
		 * getItemWithLargestQuantityInStock - parameterless; returns the Item object 
		 * with the largest quantityInStock value.
		 */
		public Item getItemWithLargestQuantityInStock() {
			Item largestItem = new Item();
			
			for (Item item: this.ourItems) {
				if (item.getQuantityInStock() > largestItem.getQuantityInStock()) {
					largestItem = item;
				}
			}
			
			return largestItem;
			
		}
		
		/*
		 * printAllItems - parameterless; prints a formatted list of all Items (itemID and quantityInStock)
		 */
		public void printAllItems() {
			System.out.println("Current Inventory");
			for (Item item: this.ourItems) {
				System.out.println(item);
			}
			System.out.println("");
		}
		
		/*
		 * printAllRestock - parameterless; prints a formatted list of all Items being restocked (itemID and restockAmount)
		 */
		public void printAllRestock() {
			for(Item item: this.ourItems) {
				if (item.getRestockAmount() > 0) {
					System.out.println(item.getItemID() + " " + item.getRestockAmount());
				}
			}
			System.out.println("");
		}
		
		/* The following code is related to sales */
		
		/*
		 * addSale - one parameter: itemID; add sale to ArrayList, for later processing.
		 */
		public boolean addSale(int itemID) {
			for (Sale sale: ourSales) {
				if (sale.getItemID() == itemID) {
					sale.setQuantityOrdered(sale.getQuantityOrdered() + 1);
					return true;
				}
			}
			
			ourSales.add(new Sale(itemID, 1));
			return false;
		}
		
		/*
		 * addSale - one parameter: index; remove sale from ArrayList (use index since itemID may appear multiple times)
		 */
		public void removeSale(int itemID, int quantityRemoved) {
			for (Sale sale: ourSales) {
				if (sale.getItemID() == itemID) {
					if (quantityRemoved > sale.getQuantityOrdered()) {
						sale.setQuantityOrdered(0);
					}else {
						sale.setQuantityOrdered(sale.getQuantityOrdered() - quantityRemoved);
					}
				}
			}
		}
		
		/*
		 * computeRestock - parameterless; checks current inventory against orders.
		 * Determines reorder using following rules:
		 * 	- If sold out (0 in stock) reorder 20% more than sold, minimum 2
		 *  - If item not sold, no restock
		 *  - If item sells, but still in stock, reorder 20% less than sold, minimum 1.
		 */
		public void computeRestock() {
			for (Item item: ourItems) {
				for (Sale sale: ourSales) {
					if (sale.getItemID() == item.getItemID()) {
						int currentStock = item.getQuantityInStock();
						int saleQuantity = sale.getQuantityOrdered();
						int restockAmount = 0;
						
						
						if (currentStock <= 0) {
							restockAmount = (int)Math.round(saleQuantity * .2);
							
							if (restockAmount < 2) {
								restockAmount = 2;
							}
							
							item.setRestockAmount(saleQuantity + restockAmount);

						}else if ((currentStock - saleQuantity) > 0) {
							restockAmount = (int)Math.round(saleQuantity * .2);
							
							if (restockAmount < 1) {
								restockAmount = 1;
							}
							
							item.setRestockAmount(restockAmount);
						}
					}
				}
			}
			
		}
		
		/*
		 * processSales - parameterless; deducts the purchased quantity from the quantity in stock.
		 */
		public void processSales() {
			for(Sale sale: ourSales) {
				for (Item item: ourItems) {
					if (sale.getItemID() == item.getItemID()) {
						item.setQuantityInStock(item.getQuantityInStock() - sale.getQuantityOrdered());
						ourSales.remove(sale);
					}
				}
			}
		}
		
		/*
		 * getNumberOfItemsSold - parameterless; returns the total number of items sold (by quantity)
		 */
		public int getNumberOfItemsSold() {
			int totalNumberOfItemsSold = 0;
			for(Sale sale: ourSales) {
				totalNumberOfItemsSold += sale.getQuantityOrdered();
			}
			return totalNumberOfItemsSold;
		}
		
		/*
		 * getNumberOfItemsRestocked - parameterless; returns the number of items restocked (ignore quantity)
		 */
		public int getNumberOfItemsRestocked() {
			int totalNumberOfItemsRestocked = 0;
			for (Item item: ourItems) {
				if (item.getRestockAmount() > 0) {
					totalNumberOfItemsRestocked += 1;
				}
			}
			return totalNumberOfItemsRestocked;
		}
		
		/*
		 * getAllSales - parameterless; returns the ourSales Sale ArrayList, for use elsewhere.
		 */
		public ArrayList<Sale> getAllSales(){
			return this.ourSales;
		}
		
		/*
		 * printAllSales - parameterless; prints a formatted list of all Sales (itemID and restock quantity)
		 */
		public void printAllSales() {
			for (Sale sale: this.ourSales) {
				System.out.println(sale);
			}
			System.out.println("");
		}
		
}
