package com.examples.apps.structures;

import static org.junit.Assert.*;

import java.util.LinkedList;

import com.examples.apps.structures.model.Element;

import org.junit.Test;

public class LinkedListsTests {

	@Test
	public void linkedListTest() {
		LinkedList<Element> ll= new LinkedList<Element>();
		
		assertTrue(ll.isEmpty());
		
		ll.add(new Element("1", 1));
		ll.add(new Element("2", 2));
		ll.add(new Element("3", 3));
		
		assertEquals(3, ll.size());
		assertEquals(1, ll.getFirst().getPriority());
		assertEquals(3, ll.getLast().getPriority());
		
		ll.addFirst(new Element("4", 3));
		ll.addLast(new Element("5", 2));
		
		assertEquals(3, ll.getFirst().getPriority());
		assertEquals(2, ll.getLast().getPriority());
		
		Element testElement= new Element("test", 1);
		ll.add(2, testElement);
		
		assertEquals(2, ll.indexOf(testElement));
		
		assertTrue(ll.contains(testElement));
		
	}

}
