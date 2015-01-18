package com.examples.apps.sales.core.models;

import com.examples.apps.sales.core.exceptions.InvalidSalesNumberException;
import com.examples.apps.sales.core.utils.Utils;

/**
 * This class represents an Item
 * @author aitor
 *
 */
public class Item {
	
	private String name;
	
	private double price;
	
	private double taxes= 0;
	
	private boolean isImported= false;
	
	private boolean taxesExempt= false;
	
	/**
	 * Class constructor
	 * 
	 * @param name The Item name
	 * @param price The Item price
	 * 
	 * @throws InvalidSalesNumberException If salesTaxes or importTaxes are lower than 0 
	 */		
	public Item(String name, double price) throws InvalidSalesNumberException	{
		this.setName(name);
		this.setPrice(price);
	}
	
	/**
	 * Set the Item name
	 * 
	 * @param newName New Item name
	 * 
	 * @return Item object instance
	 */		
	public Item setName(String newName)	{
		this.name= newName;
		return this;
	}
	
	/**
	 * Get the Item name
	 * 
	 * @return The Item name
	 */		
	public String getName()	{
		return this.name;
	}

	/**
	 * Set the Item price
	 * 
	 * @param newPrice New Item price
	 * 
	 * @return Item object instance
	 */		
	public Item setPrice(double newPrice) throws InvalidSalesNumberException	{
		if (newPrice < 0)
			throw new InvalidSalesNumberException(newPrice);		
		this.price= newPrice;
		return this;
	}

	/**
	 * Get the Item price
	 * 
	 * @return The Item price
	 */			
	public double getPrice()	{
		return this.price;
	}

	/**
	 * Set the Item taxes
	 * 
	 * @param newTaxes New item sales taxes
	 * 
	 * @return Item object instance
	 */		
	public Item setTaxes(double newTaxes)	{
		this.taxes= newTaxes;
		return this;
	}
	
	/**
	 * Get the Item taxes
	 * 
	 * @return The Item taxes
	 */			
	public double getTaxes()	{
		return this.taxes;
	}
	
	/**
	 * Set if Item is imported
	 * 
	 * @param newIsImported Flag to indicate if an Item is imported
	 * 
	 * @return Item object instance
	 */		
	public Item setIsImported(boolean newIsImported)	{
		this.isImported= newIsImported;
		return this;
	}
	
	/**
	 * Get if the Item is imported
	 * 
	 * @return Is the Item imported
	 */			
	public boolean getIsImported()	{
		return this.isImported;
	}
	
	/**
	 * Set if Item is exempt of sales taxes
	 * 
	 * @param newTaxesExempt Flag to indicate if an Item is tax-exempt
	 * 
	 * @return Item object instance
	 */		
	public Item setTaxesExempt(boolean newTaxesExempt)	{
		this.taxesExempt= newTaxesExempt;
		return this;
	}
	
	/**
	 * Get if the Item tax-exempt
	 * 
	 * @return Is the Item tax-exempt
	 */		
	public boolean getTaxesExempt()	{
		return this.taxesExempt;
	}
	
	/**
	 * Return a string with an Item representation
	 * 
	 * @return A string with Item values 
	 */		
	public String toString()	{
		return " [" + this.getName() + ": price= " + Utils.doubleFormat(this.getPrice()) + ", taxes= " + Utils.doubleFormat(this.getTaxes()) + 
				", total price= " + Utils.doubleFormat(this.getPrice() + this.getTaxes()) + "]\n";
	}	
				
}