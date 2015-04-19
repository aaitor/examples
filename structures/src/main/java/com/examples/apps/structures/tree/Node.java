package com.examples.apps.structures.tree;

import java.util.ArrayList;
import java.util.List;

public class Node<T> {

	private T data;
	private List<Node<T>> children;
	private Node<T> parent;
	
	public Node(T data)	{
		this.data= data;
		this.children= new ArrayList<Node<T>>();
	}
	
	public Node(Node<T> node)	{
		this.data= (T) node.getData();
		this.children= new ArrayList<Node<T>>();
		
	}

	public void addChild(Node<T> child) {
		child.setParent(this);
		this.children.add(child);
	}
	
	public void addChildAt(int index, Node<T> child) {
		child.setParent(this);
		this.children.set(index, child);
	}
	
	public void setChildren(List<Node<T>> children) {
		for (Node<T> child: children)
			child.setParent(this);
		this.children= children;
	}
	
	public void removeChildren() {
		this.children.clear();
	}
	
	public Node<T> removeChildAt(int index) {
		return this.children.remove(index);
	}
	
	public void removeThisIfItsAChild(Node<T> childToBeDeleted) {
		this.children.remove(childToBeDeleted);
	}
	
	public T getData() {
		return this.data;
	}
	
	public void setData(T data) {
		this.data= data;
	}
	
	public Node<T> getParent() {
		return this.parent;
	}
	
	public void setParent(Node<T> parent) {
		this.parent= parent;
	}
	
	public List<Node<T>> getChildren() {
		return this.children;
	}
	
	public Node<T> getChildAt(int index) {
		return this.children.get(index);
	}
	
	public int getNumberOfDescendants()	{
		int numberOfDescendants= this.children.size();
		for (Node<T> child: this.children)	{
			numberOfDescendants += child.getNumberOfDescendants();
		}
		return numberOfDescendants;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj instanceof Node)	{
			if ( ((Node<T>) obj).getData().equals(this.data))
				return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return this.data.toString();
	}
				
	
	
	
}
