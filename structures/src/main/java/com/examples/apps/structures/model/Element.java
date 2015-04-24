package com.examples.apps.structures.model;

public class Element implements Comparable<Element> {

	public String id;
	public int priority;
	
	public Element(String id, int priority)	{
		this.id= id;
		this.priority= priority;
	}
	
	public String getId()	{
		return this.id;
	}
	
	public int getPriority()	{
		return this.priority;
	}

	@Override
	public int compareTo(Element element) {
		// http://www.javapractices.com/topic/TopicAction.do?Id=10
		if (this == element)			
			return 0;
		else if (this.priority < element.getPriority())
			return -1;
		else
			return 1;
	}
}
