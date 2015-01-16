package com.examples.apps.sales.core;

import static org.junit.Assert.*;

import org.junit.Test;

import com.examples.apps.sales.core.exceptions.InvalidSalesNumberException;
import com.examples.apps.sales.core.models.Item;
import com.examples.apps.sales.core.models.Receipt;

/**
 * Tests for {@link Receipt} class
 *
 */
public class ReceiptTest {
	
	private static final String ITEM1_NAME= "book";
	private static final double ITEM1_PRICE= 12.49;
	private static final double ITEM1_TAXES= 2.20;
	private static final boolean ITEM1_ISIMPORTED= false;
	private static final boolean ITEM1_TAXESEXEMPT= false;
	
	
 
	@Test
	public void createReceiptObjectTest() {
		Receipt receipt1= new Receipt();
		try {
			receipt1.addItem(createTestItem());
		} catch (InvalidSalesNumberException e) {
			e.printStackTrace();
		}
		
		assertTrue(receipt1.getItems().size() == 1);
		assertTrue(receipt1.toString().contains(ITEM1_NAME));
	}

	public Item createTestItem() throws InvalidSalesNumberException	{
		Item item= new Item(ITEM1_NAME, ITEM1_PRICE);
		item.setTaxes(ITEM1_TAXES);
		item.setIsImported(ITEM1_ISIMPORTED);
		item.setIsImported(ITEM1_TAXESEXEMPT);
		return item;
	}
	
}
