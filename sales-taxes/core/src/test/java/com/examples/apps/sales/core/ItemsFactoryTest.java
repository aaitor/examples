package com.examples.apps.sales.core;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.examples.apps.sales.core.models.Item;

public class ItemsFactoryTest {

	private static final String ITEM1_NAME= "chocolate";
	private static final double ITEM1_PRICE= 12.49;	
	private static final String ITEM1_CATEGORY= "FOOD";
	private static final boolean ITEM1_ISIMPORTED= true;

	private double salesTaxes= 0.10;
	private double importTaxes= 0.05;
	private List<String> exemptCategories = Arrays.asList("AAAA", "FOOD");
	
	@Test
	public void createItemsFactoryTest() {
		SalesProperties prop= new SalesProperties(salesTaxes, importTaxes, exemptCategories);
		
		ItemsFactory factory= new ItemsFactory(prop);
		Item item1= factory.makeItem(ITEM1_NAME, ITEM1_PRICE, ITEM1_CATEGORY, ITEM1_ISIMPORTED);
		
		assertEquals(item1.getName(), ITEM1_NAME);
	}

}
