package com.examples.apps.sales.core;

import com.examples.apps.sales.core.exceptions.InvalidSalesNumberException;
import com.examples.apps.sales.core.models.Item;
import com.examples.apps.sales.core.models.Receipt;

/**
 * Sales Taxes core application interface used to interact with application business logic. 
 * @author aitor
 *
 */
public interface SalesManager {

	/**
	 * Create a new empty Receipt. This receipt can be used to add Items.
	 * 
	 * @return The receipt created
	 */
	Receipt createReceipt();
	
	/**
	 * Add one Item to a Receipt
	 * 
	 * @param receipt The Receipt where the manager will add the Item
	 * @param item The Item to add to the receipt
	 * 
	 * @return A receipt with new Item added
	 * 
	 * @throws InvalidSalesNumberException If the Item to add has invalid information. 
	 */
	Receipt addItemToReceipt(Receipt receipt, Item item) throws InvalidSalesNumberException;
			
	/**
	 * Create an Item
	 * 
	 * @param name The Item name
	 * @param price The Item price
	 * @param category The Item category
	 * @param isImported Flag to indicate if the Item is imported
	 * 
	 * @return The Item created
	 * 
	 * @throws InvalidSalesNumberException If the Item to add has invalid information. 
	 */
	Item createItem(String name, double price, String category,	boolean isImported) throws InvalidSalesNumberException;

	/**
	 * Create an Item. The Item created will have the isImported flag to false
	 * 
	 * @param name The Item name
	 * @param price The Item price
	 * @param category The Item category
	 * 
	 * @return The Item created
	 * 
	 * @throws InvalidSalesNumberException If the Item to add has invalid information. 
	 */
	Item createItem(String name, double price, String category) throws InvalidSalesNumberException;
	
}
