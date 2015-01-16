package com.examples.apps.sales.core;

import java.util.List;
import com.examples.apps.sales.core.models.Item;
import com.examples.apps.sales.core.models.Receipt;

public interface SalesManager {

	/**
	 * Create a new empty Receipt
	 * @return The receipt created
	 */
	Receipt createReceipt();
	
	/**
	 * Create a new empty Receipt
	 * @return The receipt created
	 */
	Receipt addItemToReceipt(Receipt receipt, Item item);
			
	/**
	 * Create a new Item
	 * @return The item created
	 */
	Item createItem(String name, double price, String category,	boolean isImported);

	/**
	 * Create a new Item
	 * @return The item created
	 */	
	Item createItem(String name, double price, String category);

	
	
}