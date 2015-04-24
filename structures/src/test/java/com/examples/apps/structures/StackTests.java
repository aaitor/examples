package com.examples.apps.structures;

import static org.junit.Assert.*;

import java.util.Stack;

import org.junit.Test;

import com.examples.apps.structures.model.Element;

public class StackTests {
	@Test
	public void stackTest() {
		Stack<Element> stack= new Stack<Element>();
		
		assertTrue(stack.empty());
		
		stack.push(new Element("1", 1));
		stack.push(new Element("2", 2));
		stack.push(new Element("3", 3));
		
		assertEquals(3, stack.size());
		
		assertEquals(3, stack.peek().getPriority());
		assertEquals(3, stack.pop().getPriority());
		assertEquals(2, stack.peek().getPriority());
				
		
	}
}
