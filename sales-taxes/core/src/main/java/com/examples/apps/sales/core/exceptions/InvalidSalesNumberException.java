package com.examples.apps.sales.core.exceptions;

/**
 * Thrown when trying to use an invalid value with SalesProperties
*/
@SuppressWarnings("serial")
public class InvalidSalesNumberException extends Exception {

	private double number;
	
	/**
	 * Class constructor
	 * 
	 * @param number The invalid number
	 */		
	public InvalidSalesNumberException(double number)	{
		this.number= number;
	}
	
	/**
     * {@inheritDoc}}
     */
	@Override
	public String getMessage()  {
		return "Invalid value: " + number + " , the value should be >= 0.";
	}	
}
