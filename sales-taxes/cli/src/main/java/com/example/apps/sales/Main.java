package com.example.apps.sales;

import com.examples.apps.sales.core.SalesManagerImpl;
import com.examples.apps.sales.core.models.Receipt;

public class Main {

    public static void main(String[] args)  {
        System.out.println("Initializing Sales Taxes app");
        
        SalesManagerImpl manager= new SalesManagerImpl();
        
        Receipt receipt1= manager.createReceipt();
        Receipt receipt2= manager.createReceipt();
        Receipt receipt3= manager.createReceipt();
        
        receipt1.addItem(manager.createItem("Book", 12.49, "BOOK", false))
	    		.addItem(manager.createItem("music CD", 14.99, "MUSIC", false))
	    		.addItem(manager.createItem("chocolate bar", 0.85, "FOOD", false));
        
        receipt2.addItem(manager.createItem("Imported Box of chocolates", 10.00, "FOOD", true))
        		.addItem(manager.createItem("Imported Bottle of perfume", 47.50, "PERFUME", true));
        
        receipt3.addItem(manager.createItem("Imported Bottle of perfume", 27.99, "PERFUME", true))
	        	.addItem(manager.createItem("Bottle of perfume", 18.99, "PERFUME"))
	        	.addItem(manager.createItem("Headache pills", 9.75, "MEDICAL"))
	        	.addItem(manager.createItem("Imported Box of chocolates", 11.25, "FOOD", true));
        

        System.out.println(receipt1.toString());
        System.out.println(receipt2.toString());
        System.out.println(receipt3.toString());
    }

}