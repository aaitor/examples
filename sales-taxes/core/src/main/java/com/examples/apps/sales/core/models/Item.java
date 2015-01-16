package com.examples.apps.sales.core.models;

import com.examples.apps.sales.core.exceptions.InvalidSalesNumberException;
import com.examples.apps.sales.core.utils.Utils;

public class Item {
	
	private String name;
	
	private double price;
	
	private double taxes= 0;
	
	private boolean isImported= false;
	
	private boolean taxesExempt= false;
	
	public Item(String name, double price) throws InvalidSalesNumberException	{
		this.setName(name);
		this.setPrice(price);
	}
	
	public Item setName(String newName)	{
		this.name= newName;
		return this;
	}
	
	public String getName()	{
		return this.name;
	}

	public Item setPrice(double newPrice) throws InvalidSalesNumberException	{
		if (newPrice < 0)
			throw new InvalidSalesNumberException(newPrice);		
		this.price= newPrice;
		return this;
	}
	
	public double getPrice()	{
		return this.price;
	}

	public Item setTaxes(double newTaxes)	{
		this.taxes= newTaxes;
		return this;
	}
	
	public double getTaxes()	{
		return this.taxes;
	}
	
	public Item setIsImported(boolean newIsImported)	{
		this.isImported= newIsImported;
		return this;
	}
	
	public boolean getIsImported()	{
		return this.isImported;
	}
	
	public Item setTaxesExempt(boolean newTaxesExempt)	{
		this.taxesExempt= newTaxesExempt;
		return this;
	}
	
	public boolean getTaxesExempt()	{
		return this.taxesExempt;
	}
	
	public String toString()	{
		return " [" + this.getName() + ": price= " + Utils.doubleFormat(this.getPrice()) + ", taxes= " + Utils.doubleFormat(this.getTaxes()) + 
				", total price= " + Utils.doubleFormat(this.getPrice() + this.getTaxes()) + "]\n";
	}	
				
}