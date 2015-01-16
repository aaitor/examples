package com.examples.apps.sales.core;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import com.examples.apps.sales.core.exceptions.InvalidSalesNumberException;


public class SalesPropertiesTest {

	private double salesTaxes= 0.10;
	private double importTaxes= 0.05;
	private List<String> exemptCategories = Arrays.asList("BOOK", "FOOD", "MEDICAL");
	private static final double DELTA = 1e-10;
	
	@Test
	public void createObjectTest() {
		SalesProperties prop = null;
		try {
			prop = new SalesProperties(salesTaxes, importTaxes, exemptCategories);
		} catch (InvalidSalesNumberException e) {
			e.printStackTrace();
		}
		
		assertEquals(salesTaxes, prop.getSalesTaxes(), DELTA);
		assertEquals(importTaxes, prop.getImportTaxes(), DELTA);
		assertEquals(exemptCategories.size(), prop.getExemptCategories().size());
	}

	@Test(expected=InvalidSalesNumberException.class)
	public void createInvalidObjectTest() throws InvalidSalesNumberException {
		SalesProperties prop= new SalesProperties(-5, importTaxes, exemptCategories);
		assertEquals(importTaxes, prop.getImportTaxes(), DELTA);
	}
	
	
}
