package com.examples.apps.sales.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.examples.apps.sales.core.exceptions.InvalidSalesNumberException;
import com.examples.apps.sales.core.models.Item;
import com.examples.apps.sales.core.models.Receipt;

import au.com.bytecode.opencsv.CSVReader;

/**
 * Tests for {@link SalesManagerImpl} class
 *
 */
public class SalesManagerImplTest {

	
	private static final double salesTaxes= 0.10;
	private static final double importTaxes= 0.05;
	private static final List<String> exemptCategories = Arrays.asList("BOOK", "FOOD", "MEDICAL");	
	private static SalesProperties salesProperties;
	
	private static final String ITEM1_NAME= "music cd";
	private static final double ITEM1_PRICE= 15.70;
	private static final String ITEM1_CATEGORY= "MUSIC";
	private static final boolean ITEM1_ISIMPORTED= true;
	
	private static final String FILE_RECEIPT1= "receipt1.txt";
	private static final String FILE_RECEIPT2= "receipt2.txt";
	private static final String FILE_RECEIPT3= "receipt3.txt";
	
	private static final double RECEIPT1_TAXES= 1.5;
	private static final double RECEIPT1_TOTAL= 29.83;	
	private static final double RECEIPT2_TAXES= 7.65;
	private static final double RECEIPT2_TOTAL= 65.15;
	private static final double RECEIPT3_TAXES= 6.7;
	private static final double RECEIPT3_TOTAL= 74.68;
	
	private static final double DELTA = 1e-10;
	
	private static final char CSV_SPLITBY= ';';
	private static SalesManagerImpl manager;
	
    @BeforeClass
    public static void initializeObjects()    {
    	try {
			salesProperties= new SalesProperties(salesTaxes, importTaxes, exemptCategories);
		} catch (InvalidSalesNumberException e) {
			e.printStackTrace();
		}
    	manager= new SalesManagerImpl(salesProperties);
    }
	
	@Test
	public void createReceiptObjectTest() throws InvalidSalesNumberException {
		
		Item item1= manager.createItem(ITEM1_NAME, ITEM1_PRICE, ITEM1_CATEGORY, ITEM1_ISIMPORTED);		
				
		Receipt receipt1= manager.addItemToReceipt(manager.createReceipt(), item1);
		
		assertTrue(receipt1.getItems().size() == 1);
		assertTrue(receipt1.toString().contains(ITEM1_NAME));
	}	
	
	@Test
	public void receipt1Test() throws InvalidSalesNumberException {

		Receipt receipt= manager.createReceipt();
		List<Item> listItems= getItemsFromCSV(FILE_RECEIPT1);
		
		for (Item item: listItems)	{
			receipt.addItem(item);
		}
		System.out.println("Receipt 1: " + receipt.toString());
				
		assertEquals(receipt.getSalesTaxes(), RECEIPT1_TAXES, DELTA);
		assertEquals(receipt.getTotalPrice(), RECEIPT1_TOTAL, DELTA);
	}
	
	@Test
	public void receipt2Test() throws InvalidSalesNumberException {

		Receipt receipt= manager.createReceipt();
		List<Item> listItems= getItemsFromCSV(FILE_RECEIPT2);
		
		for (Item item: listItems)	{
			receipt.addItem(item);
		}
		System.out.println("Receipt 2: " + receipt.toString());
				
		assertEquals(receipt.getSalesTaxes(), RECEIPT2_TAXES, DELTA);
		assertEquals(receipt.getTotalPrice(), RECEIPT2_TOTAL, DELTA);
	}	
	
	@Test
	public void receipt3Test() throws InvalidSalesNumberException {

		Receipt receipt= manager.createReceipt();
		List<Item> listItems= getItemsFromCSV(FILE_RECEIPT3);
		
		for (Item item: listItems)	{
			receipt.addItem(item);
		}
		System.out.println("Receipt 3: " + receipt.toString());
				
		assertEquals(receipt.getSalesTaxes(), RECEIPT3_TAXES, DELTA);
		assertEquals(receipt.getTotalPrice(), RECEIPT3_TOTAL, DELTA);
	}		
	
	public List<Item> getItemsFromCSV(String filename)	{
		List<Item> listItems= new ArrayList<Item>();
		
		try {
			String csvFile= getClass().getClassLoader().getResource(filename).getFile();			
			CSVReader reader = new CSVReader(new FileReader(csvFile), CSV_SPLITBY);
			String [] nextLine;
			
			while ((nextLine = reader.readNext()) != null) {
				listItems.add(manager.createItem(
						nextLine[1], Double.parseDouble(nextLine[2]), nextLine[3], Boolean.parseBoolean(nextLine[4])));
			}
			reader.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.getMessage();
			e.printStackTrace();
		} catch (InvalidSalesNumberException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listItems;
	}
	
	
	
}