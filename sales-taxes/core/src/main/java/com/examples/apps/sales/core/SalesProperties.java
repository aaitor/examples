package com.examples.apps.sales.core;

import java.util.Arrays;
import java.util.List;

import com.examples.apps.sales.core.exceptions.InvalidSalesNumberException;

/**
 * Class used to encapsulate the main application properties 
 * @author aitor
 *
 */
public class SalesProperties {

	private List<String> exemptCategories = Arrays.asList();
	private double salesTaxes= 0.10;
	private double importTaxes= 0.05;
	
	/**
	 * Class constructor
	 * 
	 * @param salesTaxes The Sales Taxes. Usually 0.1
	 * @param importTaxes The Item Import Taxes. Usually 0.05
	 * @param categories List of exempt categories
	 * 
	 * @throws InvalidSalesNumberException If salesTaxes or importTaxes are lower than 0 
	 */	
	public SalesProperties(double salesTaxes, double importTaxes, List<String> categories) throws InvalidSalesNumberException	{
		setSalesTaxes(salesTaxes);
		setImportTaxes(importTaxes);
		setExemptCategories(categories);
	}

	/**
	 * Set the exempt categories
	 * 
	 * @param categories List of exempt categories
	 * 
	 * @return SalesProperties object instance
	 */	
	public SalesProperties setExemptCategories(List<String> categories)	{
		this.exemptCategories= categories;
		return this;
	}

	/**
	 * Get the exempt categories
	 * 
	 * @return The exempt categories list
	 */		
	public List<String> getExemptCategories()	{
		return exemptCategories;
	}

	/**
	 * Set the sales taxes
	 * 
	 * @param newSalesTaxes New sales taxes value
	 * 
	 * @return SalesProperties object instance
	 */		
	public SalesProperties setSalesTaxes(double newSalesTaxes) throws InvalidSalesNumberException	{
		if (newSalesTaxes < 0)
			throw new InvalidSalesNumberException(newSalesTaxes);
		this.salesTaxes= newSalesTaxes;
		return this;
	}
	
	/**
	 * Get the sales taxes
	 * 
	 * @return The sales taxes value
	 */		
	public double getSalesTaxes()	{
		return salesTaxes;
	}

	/**
	 * Set the import taxes
	 * 
	 * @param newImportTaxes New import taxes value
	 * 
	 * @return SalesProperties object instance
	 */			
	public SalesProperties setImportTaxes(double newImportTaxes) throws InvalidSalesNumberException	{
		if (newImportTaxes < 0)
			throw new InvalidSalesNumberException(newImportTaxes);
		
		this.importTaxes= newImportTaxes;
		return this;
	}

	/**
	 * Get the import taxes
	 * 
	 * @return The import taxes value
	 */	
	public double getImportTaxes()	{
		return importTaxes;
	}

	
}