package com.examples.apps.sales.core.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;

public class Utils{

	public static double round(double number)	{		
		BigDecimal amount= new BigDecimal(number);
		BigDecimal result= new BigDecimal(Math.ceil(amount.doubleValue() * 20) / 20);
		result.setScale(2, RoundingMode.HALF_UP);
		return result.doubleValue();
	}	
	
	public static String doubleFormat(double number)	{
		NumberFormat nf_out = NumberFormat.getNumberInstance(Locale.UK);
		nf_out.setMaximumFractionDigits(2);
		return nf_out.format(number);
	}
}