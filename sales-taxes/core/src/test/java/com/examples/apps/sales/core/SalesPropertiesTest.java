package com.examples.apps.sales.core;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class SalesPropertiesTest {

	private double salesTaxes= 0.10;
	private double importTaxes= 0.05;
	private List<String> exemptCategories = Arrays.asList("BOOK", "FOOD", "MEDICAL");
	private static final double DELTA = 1e-10;
	
	@Test
	public void createObjectTest() {
		SalesProperties prop= new SalesProperties(salesTaxes, importTaxes, exemptCategories);
		
		assertEquals(salesTaxes, prop.getSalesTaxes(), DELTA);
		assertEquals(importTaxes, prop.getImportTaxes(), DELTA);
		assertEquals(exemptCategories.size(), prop.getExemptCategories().size());
	}

}
