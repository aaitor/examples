package com.examples.apps.sales.core.models;

import java.util.ArrayList;
import java.util.List;

import com.examples.apps.sales.core.exceptions.InvalidSalesNumberException;
import com.examples.apps.sales.core.utils.Utils;

/**
 * This class represents a Receipt
 * @author aitor
 *
 */
public class Receipt {

	private List<Item> items= new ArrayList<Item>();
	private double salesTaxes= 0;
	private double totalPrice= 0;
	
	/**
	 * Class constructor
	 * 
	 */		
	public Receipt()	{		
	}

	/**
	 * Add one Item
	 * @param newItem The Item to add
	 * 
	 * @return A receipt with new Item added
	 * 
	 * @throws InvalidSalesNumberException If the Item to add has invalid information. 
	 */	
	public Receipt addItem(Item newItem) throws InvalidSalesNumberException	{
		items.add(newItem);

		addToSalesTaxes(newItem.getTaxes());		
		addToTotalPrice(newItem.getTaxes() + newItem.getPrice());
		
		return this;
	}
	
	/**
	 * Get the Items added to the Receipt
	 * 
	 * @return The list of Items
	 */		
	public List<Item> getItems()	{
		return items;
	}
	
	/**
	 * Set the sales taxes
	 * 
	 * @param newSalesTaxes New sales taxes
	 * 
	 * @return Receipt object instance
	 */		
	public Receipt setSalesTaxes(double newSalesTaxes) throws InvalidSalesNumberException	{
		if (newSalesTaxes < 0)
			throw new InvalidSalesNumberException(newSalesTaxes);
		this.salesTaxes= Utils.round(newSalesTaxes);
		return this;
	}
	
	/**
	 * Get the Receipt sales taxes
	 * 
	 * @return The sales taxes
	 */		
	public double getSalesTaxes()	{
		return salesTaxes;
	}

	/**
	 * Add sales taxes to the Receipt
	 * 
	 * @param newSalesTaxes New sales taxes
	 * 
	 * @return Receipt object instance
	 */			
	public Receipt addToSalesTaxes(double newSalesTaxes) throws InvalidSalesNumberException	{
		return setSalesTaxes(getSalesTaxes() + newSalesTaxes);
	}
	
	/**
	 * Set the total price
	 * 
	 * @param newTotalPrice New Total Price
	 * 
	 * @return Receipt object instance
	 */			
	public Receipt setTotalPrice(double newTotalPrice) throws InvalidSalesNumberException	{
		if (newTotalPrice < 0)
			throw new InvalidSalesNumberException(newTotalPrice);
		this.totalPrice= newTotalPrice;
		return this;
	}
	
	/**
	 * Get the Receipt total price
	 * 
	 * @return The total price
	 */		
	public double getTotalPrice()	{
		return totalPrice;
	}	
	
	/**
	 * Add to the existing Total Price of to the Receipt
	 * 
	 * @param newTotalPrice Total price to add
	 * 
	 * @return Receipt object instance
	 */		
	public Receipt addToTotalPrice(double newTotalPrice) throws InvalidSalesNumberException	{
		return setTotalPrice(getTotalPrice() + newTotalPrice);
	}		
	
	/**
	 * NOT YET IMPLEMENTED
	 * Delete an Item of the Receipt 
	 * 
	 * @param Item The item to remove
	 * 
	 * @return Receipt object instance
	 */		
	public Receipt deleteItem(Item item) {
		throw new UnsupportedOperationException("Not yet Implemented");		
	}
	
	/**
	 * Return a string with a Receipt representation
	 * 
	 * @return A string with Receipt values 
	 */		
	public String toString()	{
		String output= "Items: {\n";
		for (Item item: items)	{
			output= output + item.toString();
		}
		output= output + "} - Sales Taxes: " + Utils.doubleFormat(this.getSalesTaxes()) + " - Total: " + Utils.doubleFormat(this.getTotalPrice());
		return output + "\n";
	}
}