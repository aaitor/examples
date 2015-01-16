package com.examples.apps.sales.core;

import com.examples.apps.sales.core.exceptions.InvalidSalesNumberException;
import com.examples.apps.sales.core.models.Item;

public class ItemsFactory {
	
	private SalesProperties prop;
	
	public ItemsFactory(SalesProperties salesProperties) {
		this.prop= salesProperties;
	}

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