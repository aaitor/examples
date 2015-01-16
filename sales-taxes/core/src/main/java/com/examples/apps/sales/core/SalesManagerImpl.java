package com.examples.apps.sales.core;

import com.examples.apps.sales.core.models.Item;
import com.examples.apps.sales.core.models.Receipt;
import com.examples.apps.sales.core.utils.Utils;


public class SalesManagerImpl implements SalesManager {
	
	private ItemsFactory itemsFactory;
	private double SALES_TAXES= 0.10;
	private double IMPORT_TAXES= 0.05;
	
	
	public SalesManagerImpl()	{
		itemsFactory= new ItemsFactory();
	}

	@Override
	public Item createItem(String name, double price, String category, boolean isImported) {
		
		Item item= itemsFactory.makeItem(name, price, category, isImported);
		
		double itemTaxes= 0;		
		
		if (!item.getTaxesExempt())	{
			itemTaxes= Utils.round(item.getPrice() * SALES_TAXES);
		}
			
		if (isImported)	{
			itemTaxes= itemTaxes + Utils.round(item.getPrice() * IMPORT_TAXES);			
		}		
				
		item.setTaxes(itemTaxes);		
		return item;
	}
	
	@Override
	public Item createItem(String name, double price, String category) {		
		return createItem(name, price, category, false);
	}
	
	
	@Override
	public Receipt createReceipt() {		
		return new Receipt();
	}

	@Override
	public Receipt addItemToReceipt(Receipt receipt, Item item) {
		receipt.addItem(item);

		return receipt;
	}

}