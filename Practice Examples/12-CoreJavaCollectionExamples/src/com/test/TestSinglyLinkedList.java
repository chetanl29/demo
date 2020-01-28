package com.test;

import com.test.collections.SinglyLinkedListImpl;

public class TestSinglyLinkedList {

	public static void main(String[] args) {
		
		SinglyLinkedListImpl list = new SinglyLinkedListImpl();
		
		list.add("10");
		list.add("10");
		list.add("20");
		list.add("30");
		list.add("40");
		
		System.out.println("List Details ::= "+list);
		
		list.addFirst("50");
		
		System.out.println("List Details ::= "+list);
		
		list.addLast("60");
		
		System.out.println("List Details ::= "+list);
		
		list.addFirst(null);
		
		System.out.println("List Details ::= "+list);
		
		//System.out.println("Element at specific location ::= "+list.get(5));
		
		//System.out.println("Element at first Location ::= "+list.getFirst());
		
		//System.out.println("Element at Last Location ::= "+list.getLast());
		
		//System.out.println("Element to be removed ::= "+list.remove(0));
		
	//	System.out.println("List Details ::= "+list.remove("10"));
		
		System.out.println("List Details ::= "+list);
		
		System.out.println("Index Of List Details ::= "+list.indexOf("60"));
		
		System.out.println("Last Index of List Details ::= "+list.lastIndexOf(null));
		
		list.add(7,null);
		
		list.set(5, "r");
		
		System.out.println("List Details ::= "+list);
	}

}
