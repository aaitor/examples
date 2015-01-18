package com.examples.apps.sales.core;

import com.examples.apps.sales.core.exceptions.InvalidSalesNumberException;
import com.examples.apps.sales.core.models.Item;

/**
 * Items Factory class used to abstract the new Items creation. A more complex new business logic about
 * items creation can be encapsulated in this class.  
 * @author aitor
 *
 */
public class ItemsFactory {
	
	private SalesProperties prop;
	
	/**
	 * Class Constructor
	 *  
	 * @param salesProperties A SalesProperties object defining the Sales rules to calculate the Item and Receipt prices
	 */	
	public ItemsFactory(SalesProperties salesProperties) {
		this.prop= salesProperties;
	}

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
	public Item makeItem(String name, double price, String category, boolean isImported) throws InvalidSalesNumberException	{
		Item newItem= new Item(name, price);
		
		if (prop.getExemptCategories().contains(category.toUpperCase()))	{
			newItem.setTaxesExempt(true);
		}
		if (isImported)	{
			newItem.setIsImported(true);
		}
		
		return newItem;
	}
	
}