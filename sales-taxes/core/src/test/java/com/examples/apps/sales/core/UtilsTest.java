package com.examples.apps.sales.core;

import static org.junit.Assert.*;

import org.junit.Test;

import com.examples.apps.sales.core.utils.Utils;

public class UtilsTest {

	private static double DOUBLE_VALUE= 0.5625;
	private static String FORMATTED_VALUE= "0.56";
	private static double ROUNDED_VALUE= 0.6;
	private static final double DELTA = 1e-10;
	
	@Test
	public void roundTest() {
		assertEquals(Utils.round(DOUBLE_VALUE), ROUNDED_VALUE, DELTA);
	}

	@Test
	public void doubleFormatTest() {
		assertEquals(Utils.doubleFormat(DOUBLE_VALUE), FORMATTED_VALUE);
	}
	
}
