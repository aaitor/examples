package com.examples.apps.sales.core;

import java.util.Arrays;
import java.util.List;

import com.examples.apps.sales.core.models.Item;
import com.examples.apps.sales.core.models.Receipt;
import com.examples.apps.sales.core.utils.Utils;


public class SalesManagerImpl implements SalesManager {
	
	private ItemsFactory itemsFactory;
	private SalesProperties prop;
	private double salesTaxes= 0.10;
	private double importTaxes= 0.05;
	private List<String> exemptCategories = Arrays.asList("BOOK", "FOOD", "MEDICAL");
	
	public SalesManagerImpl()	{
		prop= new SalesProperties(salesTaxes, importTaxes, exemptCategories);
		itemsFactory= new ItemsFactory(prop);
	}

	@Override
	public Item createItem(String name, double price, String category, boolean isImported) {
		
		Item item= itemsFactory.makeItem(name, price, category, isImported);
		
		double itemTaxes= 0;		
		
		if (!item.getTaxesExempt())	{
			itemTaxes= Utils.round(item.getPrice() * prop.getSalesTaxes());
		}
			
		if (isImported)	{
			itemTaxes= itemTaxes + Utils.round(item.getPrice() * prop.getImportTaxes());			
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