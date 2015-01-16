package com.examples.apps.sales.core;

import java.util.Arrays;
import java.util.List;

import com.examples.apps.sales.core.exceptions.InvalidSalesNumberException;

public class SalesProperties {

	private List<String> exemptCategories = Arrays.asList();
	private double salesTaxes= 0.10;
	private double importTaxes= 0.05;
	
	public SalesProperties(double salesTaxes, double importTaxes, List<String> categories) throws InvalidSalesNumberException	{
		setSalesTaxes(salesTaxes);
		setImportTaxes(importTaxes);
		setExemptCategories(categories);
	}
	
	public SalesProperties setExemptCategories(List<String> categories)	{
		this.exemptCategories= categories;
		return this;
	}
	
	public List<String> getExemptCategories()	{
		return exemptCategories;
	}
		
	public SalesProperties setSalesTaxes(double newSalesTaxes) throws InvalidSalesNumberException	{
		if (newSalesTaxes < 0)
			throw new InvalidSalesNumberException(newSalesTaxes);
		this.salesTaxes= newSalesTaxes;
		return this;
	}
	
	public double getSalesTaxes()	{
		return salesTaxes;
	}
		
	public SalesProperties setImportTaxes(double newImportTaxes) throws InvalidSalesNumberException	{
		if (newImportTaxes < 0)
			throw new InvalidSalesNumberException(newImportTaxes);
		
		this.importTaxes= newImportTaxes;
		return this;
	}
	
	public double getImportTaxes()	{
		return importTaxes;
	}

	
}