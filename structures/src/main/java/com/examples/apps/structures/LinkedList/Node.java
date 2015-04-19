package com.examples.apps.structures.LinkedList;

public class Node {

	Node next= null;
	Object data;
	
	public Node(Object data)	{
		this.data= data;
	}
	
	public void appendToTail(Object data)	{
		Node end= new Node(data);
		Node n= this;
		while (n.next != null)	{
			n= n.next;
		}
		n.next= end;
	}
	
	public Node deleteNode(Node head, Object data)	{
		Node n= head;
		if (n.data.equals(data))
			return head.next;
		while (n.next != null)	{
			if (n.next.data.equals(data))	{
				n.next= n.next.next;
				return head;
			}
			n= n.next;
		}
		return head;
	}
	
}
