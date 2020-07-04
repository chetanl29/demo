package com.test;

import com.test.collections.DoublyLinkedListImpl;

public class TestDoublyLinkedList {

	public static void main(String[] args) {
		DoublyLinkedListImpl list = new DoublyLinkedListImpl();
		
		list.add("10");
		list.add(null);
		list.add(null);
		list.add("20");
		list.add("30");
		list.add("40");
		
		System.out.println("List Details ::= "+list);
		
		System.out.println("Element at Specific Position ::= "+list.get(1));
		
//		list.remove(2);
		
		System.out.println("List Details ::= "+list);
		
//		list.removeFirst();
		
		System.out.println("List Details ::= "+list);
		
		System.out.println("List Size ::= "+list.size());
		
//		list.removeLast();
		
		System.out.println("List Details ::= "+list);
		
		//System.out.println("Is null == null "+(null == null));
		
		System.out.println("Index of null ::= "+list.indexOf(null));
		
		System.out.println("Last Index of null ::= "+list.lastIndexOf(null));
		
		System.out.println("Remove any element from List ::= "+list.remove("40"));
		
		System.out.println("List Details ::= "+list);

	}

}
