package com.examples.apps.structures;

public class StringUtils {

	private static final int MAX_NUMBER_CHARS = 256;

	/**
	 * Implement an algorithm to determine if a string has all unique characters. 
	 * What if you cannot use additional data structures?
	 */	
	public static boolean isUniqueChars(String input) {
		if (input.length() >= MAX_NUMBER_CHARS)
			return false;
		
		boolean[] chars= new boolean[MAX_NUMBER_CHARS];
		
		for (int index=0; index< input.length(); index++)	{
			int val= input.charAt(index);
			if (chars[val])	{ // The value already exists in chars array
				return false;
			}
			chars[val]= true;
		}
		
		return true;
	}

	public static String getSortedString(String inputString)	{
		char[] content= inputString.toCharArray();
		java.util.Arrays.sort(content);
		return new String(content);
	}

	/**
	 *  Given two strings, write a method to decide if one is a permutation of the other.
	 */		
	public static boolean isPermutation(String inputSource, String permutation) {
		if (inputSource.length() != permutation.length())
			return false;
		
		if (getSortedString(inputSource).equals(getSortedString(permutation)))
			return true;
		
		return false;
	}

	
	/**
	 *  Write a method to replace all spaces in a string with '%20'. You may assume that the
	 *	string has sufficient space at the end of the string to hold the additional characters,
	 *	and that you are given the "true" length of the string. (Note: if implementing in Java,
	 *	please use a character array so that you can perform this operation in place.)
	 */	
	public static String replaceCharacters(String inputSource, String replace) {
		char[] finalString= new char[inputSource.length()];
		char[] input= inputSource.toCharArray();
		int destIndex= 0;
		char spaceCharacter= ' ';
		
		for (int index= 0; index< input.length; index++)	{
			if (input[index] != spaceCharacter)	{
				finalString[destIndex]= input[index];
				destIndex++;
			}	else	{
				for (int replaceIndex= 0; replaceIndex < replace.length(); replaceIndex++)
					finalString[destIndex + replaceIndex]= replace.charAt(replaceIndex);
				destIndex= destIndex + replace.length();
			}
			
			if (destIndex>= finalString.length)
				break;				
		}
		
		return new String(finalString);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
