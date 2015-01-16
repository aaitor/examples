package com.example.apps.sales;

import java.util.Arrays;
import java.util.List;

import com.examples.apps.sales.core.SalesManagerImpl;
import com.examples.apps.sales.core.SalesProperties;
import com.examples.apps.sales.core.exceptions.InvalidSalesNumberException;
import com.examples.apps.sales.core.models.Receipt;

public class Main {

	private static final double salesTaxes= 0.10;
	private static final double importTaxes= 0.05;	
	private static final List<String> exemptCategories = Arrays.asList("BOOK", "FOOD", "MEDICAL");
	private static SalesProperties salesProperties;
	
    public static void main(String[] args)  {
        System.out.println("Initializing Sales Taxes app");
        
		try {
	        salesProperties= new SalesProperties(salesTaxes, importTaxes, exemptCategories);
	        SalesManagerImpl manager= new SalesManagerImpl(salesProperties);
	        
	        Receipt receipt1= manager.createReceipt();
	        Receipt receipt2= manager.createReceipt();
	        Receipt receipt3= manager.createReceipt();
	        
	        receipt1.addItem(manager.createItem("Book", 12.49, "BOOK"))
		    		.addItem(manager.createItem("music CD", 14.99, "MUSIC"))
		    		.addItem(manager.createItem("chocolate bar", 0.85, "FOOD"));
	        
	        receipt2.addItem(manager.createItem("Imported Box of chocolates", 10.00, "FOOD", true))
	        		.addItem(manager.createItem("Imported Bottle of perfume", 47.50, "PERFUME", true));
	        
	        receipt3.addItem(manager.createItem("Imported Bottle of perfume", 27.99, "PERFUME", true))
		        	.addItem(manager.createItem("Bottle of perfume", 18.99, "PERFUME"))
		        	.addItem(manager.createItem("Headache pills", 9.75, "MEDICAL"))
		        	.addItem(manager.createItem("Imported Box of chocolates", 11.25, "FOOD", true));
	        

	        System.out.println(receipt1.toString());
	        System.out.println(receipt2.toString());
	        System.out.println(receipt3.toString());

		} catch (InvalidSalesNumberException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    }

}