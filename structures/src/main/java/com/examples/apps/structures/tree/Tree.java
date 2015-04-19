package com.examples.apps.structures.tree;

import java.util.ArrayList;

public class Tree<T> {

	private Node<T> root= null;
	
	public Tree()	{		
	}
			
	public Tree(Node<T> root)	{
		setRoot(root);
	}
	
	public boolean isEmpty()	{
		if (root == null)
			return true;
		return false;
	}
	
	public Node<T> getRoot()	{
		return this.root;
	}
	
	public void setRoot(Node<T> root)	{
		this.root= root;
	}
	
	public int getNumberOfNodes()	{
		return this.root.getNumberOfDescendants() + 1;
	}
		
	public boolean exists(T key)	{
		return find(this.root, key);
	}
	
	private boolean find(Node<T> node, T keyNode) {
		boolean exists= false;
		if (node == null || keyNode == null)
			return false;
		
		if (node.getData().equals(keyNode))
			return true;
		for (Node<T> child: node.getChildren())	{
			if (find(child, keyNode))
				return true;
		}
		
		return exists;
	}
	
	private Node<T> findNode(Node<T> node, T keyNode)	{
		if (node == null)
			return null;
		if (node.getData().equals(keyNode))
			return node;
		
		Node<T> searchedNode= null;
		for (Node<T> child: node.getChildren())	{
			if ( (searchedNode= findNode(child, keyNode)) != null)	{
				return searchedNode;
			}
		}
		return null;
	}
	
	public ArrayList<Node<T>> getPreOrderTraversal() {
		ArrayList<Node<T>> preOrder= new ArrayList<Node<T>>();
		buildPreOrder(root, preOrder);
		return preOrder;
	}
	
	public ArrayList<Node<T>> getPostOrderTraversal() {
		ArrayList<Node<T>> postOrder= new ArrayList<Node<T>>();
		buildPostOrder(root, postOrder);
		return postOrder;		
	}
	
	private void buildPreOrder(Node<T> node, ArrayList<Node<T>> preOrder) {
		preOrder.add(node);
		for (Node<T> child: node.getChildren())	{
			buildPreOrder(child, preOrder);
		}
	}
	
	private void buildPostOrder(Node<T> node, ArrayList<Node<T>> postOrder) {
		for (Node<T> child: node.getChildren())	{
			buildPostOrder(child, postOrder);
		}		
		postOrder.add(node);
	}
	
	public ArrayList<Node<T>> getLongestPathFromRootToAnyLeaf() {
		ArrayList<Node<T>> longestPath = null;
		int max= 0;
		for (ArrayList<Node<T>> path: getPathsFromRootToAnyLeaf())	{
			if (path.size() > max)	{
				max= path.size();
				longestPath= path;
			}
		}
		return longestPath;
	}
	
	public int getMaxDepth() {
		return getLongestPathFromRootToAnyLeaf().size();
	}
	
	public ArrayList<ArrayList<Node<T>>> getPathsFromRootToAnyLeaf() {
		ArrayList<Node<T>> currentPath= new ArrayList<Node<T>>();
		ArrayList<ArrayList<Node<T>>> paths= new ArrayList<ArrayList<Node<T>>>();
		
		getPath(root, currentPath, paths);
		return paths;
	}
	
	private void getPath(Node<T> node, ArrayList<Node<T>> currentPath,
			ArrayList<ArrayList<Node<T>>> paths) {
		if (currentPath == null)
			return;
		
		currentPath.add(node);
		
		if (node.getChildren().size() == 0) {  // It's a leaf
			paths.add(clone(currentPath));
		}
		for (Node<T> child: node.getChildren())	{
			getPath(child, currentPath, paths);			
		}
		
		int index= currentPath.indexOf(node);
		for (int i= index; i< currentPath.size(); i++)	{
			currentPath.remove(i);
		}
		
	}
	
	private ArrayList<Node<T>> clone(ArrayList<Node<T>> list) {
		ArrayList<Node<T>> newList = new ArrayList<Node<T>>();
		for (Node<T> node : list)
			newList.add(new Node<T>(node));

		return newList;		
	}
	
	
}
