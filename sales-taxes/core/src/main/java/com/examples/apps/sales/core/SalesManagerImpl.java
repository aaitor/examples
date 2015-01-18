package com.examples.apps.sales.core;

import com.examples.apps.sales.core.exceptions.InvalidSalesNumberException;
import com.examples.apps.sales.core.models.Item;
import com.examples.apps.sales.core.models.Receipt;
import com.examples.apps.sales.core.utils.Utils;

/**
 * Implementation of the <code>SalesManager</code> interface.
 * @author aitor
 *
 */
public class SalesManagerImpl implements SalesManager {
	
	private ItemsFactory itemsFactory;
	private SalesProperties salesProperties;
	
	/**
	 * Class Constructor
	 *  
	 * @param prop A SalesProperties object defining the Sales rules to calculate the Item and Receipt prices
	 */
	public SalesManagerImpl(SalesProperties prop)	{
		salesProperties= prop;
		itemsFactory= new ItemsFactory(salesProperties);
	}

	/**
	 * {@inheritDoc}}
	 */
	@Override
	public Item createItem(String name, double price, String category, boolean isImported) throws InvalidSalesNumberException {
		
		Item item= itemsFactory.makeItem(name, price, category, isImported);
		
		double itemTaxes= 0;		
		
		if (!item.getTaxesExempt())	{
			itemTaxes= Utils.round(item.getPrice() * salesProperties.getSalesTaxes());
		}
			
		if (isImported)	{
			itemTaxes= itemTaxes + Utils.round(item.getPrice() * salesProperties.getImportTaxes());			
		}		
				
		item.setTaxes(itemTaxes);		
		return item;
	}

	/**
	 * {@inheritDoc}}
	 */	
	@Override
	public Item createItem(String name, double price, String category) throws InvalidSalesNumberException {		
		return createItem(name, price, category, false);
	}
	
	/**
	 * {@inheritDoc}}
	 */	
	@Override
	public Receipt createReceipt() {		
		return new Receipt();
	}

	/**
	 * {@inheritDoc}}
	 */
	@Override
	public Receipt addItemToReceipt(Receipt receipt, Item item) throws InvalidSalesNumberException {
		receipt.addItem(item);

		return receipt;
	}

}