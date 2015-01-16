package com.examples.apps.sales.core;

import static org.junit.Assert.*;
import org.junit.Test;

import com.examples.apps.sales.core.exceptions.InvalidSalesNumberException;
import com.examples.apps.sales.core.models.Item;

/**
 * Tests for {@link Test} class
 *
 */
public class ItemTest {

	private static final double DELTA = 1e-15;
	
	private static final String ITEM1_NAME= "book";
	private static final double ITEM1_PRICE= 12.49;
	private static final double ITEM1_TAXES= 2.20;
	private static final boolean ITEM1_ISIMPORTED= false;
	private static final boolean ITEM1_TAXESEXEMPT= false;
	
	
	@Test
	public void createItemObjectTest() throws InvalidSalesNumberException {
		Item item1= new Item(ITEM1_NAME, ITEM1_PRICE);
		item1.setTaxes(ITEM1_TAXES);
		item1.setIsImported(ITEM1_ISIMPORTED);
		item1.setTaxesExempt(ITEM1_TAXESEXEMPT);
		
		assertEquals(item1.getName(), ITEM1_NAME);
		assertEquals(item1.getPrice(), ITEM1_PRICE, DELTA);
		assertEquals(item1.getTaxes(), ITEM1_TAXES, DELTA);
		assertEquals(item1.getIsImported(), ITEM1_ISIMPORTED);
		assertEquals(item1.getTaxesExempt(), ITEM1_TAXESEXEMPT);
		assertTrue(item1.toString().contains(ITEM1_NAME));
	}
	
	@Test(expected=InvalidSalesNumberException.class)
	public void createInvalidObjectTest() throws InvalidSalesNumberException {
		Item item1= new Item(ITEM1_NAME, -10);		
		assertEquals(item1.getName(), ITEM1_NAME);
	}	
}
