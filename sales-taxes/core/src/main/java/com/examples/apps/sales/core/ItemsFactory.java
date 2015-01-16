package com.examples.apps.sales.core;

import java.util.Arrays;
import java.util.List;

import com.examples.apps.sales.core.models.Item;

public class ItemsFactory {

	private List<String> exemptCategories = Arrays.asList("BOOK", "FOOD", "MEDICAL");
	
	public Item makeItem(String name, double price, String category, boolean isImported)	{
		Item newItem= new Item(name, price);
		
		if (exemptCategories.contains(category.toUpperCase()))	{
			newItem.setTaxesExempt(true);
		}
		if (isImported)	{
			newItem.setIsImported(true);
		}
		
		return newItem;
	}
	
}