package com.examples.apps.structures.tree;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class NaryTreeTest {
	
	private static Node<String> ceo;
	private static Tree<String> company;
	
	@BeforeClass
	public static void setupCompanyStructure()	{
		ceo= getCompanyCeo();
		company= getCompanyStructure(ceo);
	}

	
	@Test
	public void testCeoNumberOfDescendants() {		
		assertEquals(16, ceo.getNumberOfDescendants());
	}	
	
	@Test
	public void testCompanyNumberOfEmployees() {		
		assertEquals(17, company.getNumberOfNodes());
	}	
	
	@Test
	public void testRemoveChildren() {		
		ceo.removeChildren();
		assertEquals(0, ceo.getNumberOfDescendants());
	}	
	
	
	
	public static Tree<String> getCompanyStructure(Node<String> root)	{
		return new Tree<String>(root);
	}	
	
	public static Node<String> getCompanyCeo() {
		Node<String> ceo= new Node<String>("CEO");
		
		Node<String> cto= new Node<String>("CTO");
		Node<String> cfo= new Node<String>("CFO");
		Node<String> cmo= new Node<String>("CMO");
		
		Node<String> itManager1= new Node<String>("IT Manager 1");
		Node<String> itManager2= new Node<String>("IT Manager 2");
		
		Node<String> itDeveloper1= new Node<String>("IT Developer 1");
		Node<String> itDeveloper2= new Node<String>("IT Developer 2");
		Node<String> itDeveloper3= new Node<String>("IT Developer 3");
		Node<String> itDeveloper4= new Node<String>("IT Developer 4");
		Node<String> itDeveloper5= new Node<String>("IT Developer 5");
		
		itManager1.addChild(itDeveloper1);
		itManager1.addChild(itDeveloper5);
		itManager2.addChild(itDeveloper2);
		itManager2.addChild(itDeveloper3);
		itManager2.addChild(itDeveloper4);
		
		Node<String> finManager1= new Node<String>("Financial Manager 1");
		Node<String> accountant1= new Node<String>("Accountant 1");
		
		finManager1.addChild(accountant1);
		
		Node<String> mktManager1= new Node<String>("Business Manager 1");
		Node<String> mktManager2= new Node<String>("Business Manager 2");
		Node<String> mktManager3= new Node<String>("Business Manager 3");
		
		Node<String> mktStaff1= new Node<String>("Business Staff 1");
		
		mktManager3.addChild(mktStaff1);
		
		cto.addChild(itManager1);
		cto.addChild(itManager2);
		
		cfo.addChild(finManager1);
		
		cmo.addChild(mktManager1);
		cmo.addChild(mktManager2);
		cmo.addChild(mktManager3);
		
		ceo.addChild(cto);
		ceo.addChild(cfo);
		ceo.addChild(cmo);
		
		return ceo;
	}

	
}
