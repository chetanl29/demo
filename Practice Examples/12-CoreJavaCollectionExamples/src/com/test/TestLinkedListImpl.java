package com.test;

import com.test.collections.LinkedListImpl;

public class TestLinkedListImpl {

	public static void main(String[] args) {
		LinkedListImpl list = new LinkedListImpl();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		System.out.println("List Details ::="+list);
		
		System.out.println("Details ::= "+list.get(2));
		
		System.out.println("Details removed ::= "+list.remove(2));
		
		System.out.println("List size ::="+list.size());
		
		System.out.println("List Details ::="+list);
		
		list.addFirst("e");
		
		System.out.println("List Details adding at First ::="+list);
		
		list.addLast("f");
		
		System.out.println("List Details adding at Last ::= "+list);
		
		list.addAtIndex(2, "z");
		
		System.out.println("List Details adding at index ::= "+list);
		
		list.removeFirst();
		
		System.out.println("After removing First Element ::= "+list);
		
		list.removeLast();
		
		System.out.println("After removing Last Element ::= "+list);
		
		
		System.out.println("List Size ::= "+list.size());

	}

}
