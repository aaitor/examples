package com.examples.apps.structures;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringsTests {


	@Test
	public void uniqueStringCharactersTest()	{
		String inputUnique= "AEIOU bcdf-123";
		String inputNotUnique= "AEIOU AE";
		
		assertTrue(StringUtils.isUniqueChars(inputUnique));
		assertFalse(StringUtils.isUniqueChars(inputNotUnique));
	}
	
	@Test
	public void permutationStringCharactersTest()	{
		String inputSource= "the dog";
		String isAPermutation= "dog hte";
		String isNotAPermutation= "dog jjj";
		
		assertTrue(StringUtils.isPermutation(inputSource, isAPermutation));
		assertFalse(StringUtils.isPermutation(inputSource, isNotAPermutation));
	}
	
	@Test
	public void replacteSpacesTest()	{	
		String inputSource= "Mr John Smith    ";
		
		assertEquals("Mr%20John%20Smith", StringUtils.replaceCharacters(inputSource, "%20"));
	}
	
	
	
	
}
