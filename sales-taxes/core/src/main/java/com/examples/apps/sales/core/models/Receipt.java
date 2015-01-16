package com.examples.apps.sales.core.models;

import java.util.ArrayList;
import java.util.List;

import com.examples.apps.sales.core.exceptions.InvalidSalesNumberException;
import com.examples.apps.sales.core.utils.Utils;

public class Receipt {

	private List<Item> items= new ArrayList<Item>();
	private double salesTaxes= 0;
	private double totalPrice= 0;
	
	public Receipt()	{
		
	}
	
	public Receipt addItem(Item newItem) throws InvalidSalesNumberException	{
		items.add(newItem);

		addToSalesTaxes(newItem.getTaxes());		
		addToTotalPrice(newItem.getTaxes() + newItem.getPrice());
		
		return this;
	}
	
	public List<Item> getItems()	{
		return items;
	}
	
	public Receipt setSalesTaxes(double newSalesTaxes) throws InvalidSalesNumberException	{
		if (newSalesTaxes < 0)
			throw new InvalidSalesNumberException(newSalesTaxes);
		this.salesTaxes= Utils.round(newSalesTaxes);
		return this;
	}
	
	public double getSalesTaxes()	{
		return salesTaxes;
	}
	
	public Receipt addToSalesTaxes(double newSalesTaxes) throws InvalidSalesNumberException	{
		return setSalesTaxes(getSalesTaxes() + newSalesTaxes);
	}
	
	public Receipt setTotalPrice(double newTotalPrice) throws InvalidSalesNumberException	{
		if (newTotalPrice < 0)
			throw new InvalidSalesNumberException(newTotalPrice);
		this.totalPrice= newTotalPrice;
		return this;
	}
	
	public double getTotalPrice()	{
		return totalPrice;
	}	
	
	public Receipt addToTotalPrice(double newTotalPrice) throws InvalidSalesNumberException	{
		return setTotalPrice(getTotalPrice() + newTotalPrice);
	}		
	
	
	public Receipt deleteItem(Receipt receipt, Item item) {
		throw new UnsupportedOperationException("Not yet Implemented");		
	}
	
	public String toString()	{
		String output= "Items: {\n";
		for (Item item: items)	{
			output= output + item.toString();
		}
		output= output + "} - Sales Taxes: " + Utils.doubleFormat(this.getSalesTaxes()) + " - Total: " + Utils.doubleFormat(this.getTotalPrice());
		return output + "\n";
	}
}