package com.examples.apps.structures;

import static org.junit.Assert.*;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

import org.junit.Test;

import com.examples.apps.structures.model.Element;

public class QueueTests {
	@Test
	public void queueTest() {
		Queue<Element> queue= new PriorityQueue<Element>();
		
		assertTrue(queue.isEmpty());
		
		
		queue.add(new Element("1", 1));
		queue.add(new Element("2", 2));
		queue.add(new Element("3", 3));
		
		assertEquals(3, queue.size());
		
		assertEquals(1, queue.peek().getPriority());
		assertEquals(1, queue.poll().getPriority());
		assertEquals(2, queue.peek().getPriority());
				
	}
}
