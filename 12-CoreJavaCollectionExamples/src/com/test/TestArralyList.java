package com.test;

import com.test.collections.ArrayListImpl;
import com.test.collections.IteratorI;

public class TestArralyList {

	public static void main(String[] args) {
		ArrayListImpl list = new ArrayListImpl();
		list.add("10");
		list.add(null);
		list.add("a");
		list.add("a");
		list.add('d');
		list.add(10.00);
		System.out.println("List Contents ::= "+list);
		
		//System.out.println("Removed content ::= "+list.remove(2));
		
		System.out.println("List Contents ::= "+list);
		
		System.out.println("Is Empty ::= "+list.isEmpty()+" Size::= "+list.size());
		
		//list.clear();
		
		System.out.println("Getting List element by index ::= "+list.get(0));
		
		System.out.println("Is Empty ::= "+list.isEmpty()+" Size::= "+list.size());
		
		/*list.remove(null);
		
		list.remove("z");*/
		
		list.remove(10.00);
		
		list.add(1,"z");
		
		//list.set(0,"m");
		
		Object[] obj = list.toArray();
		
		for(Object o : obj) {
			System.out.println("Object Data := "+o);
		}
		
		
		System.out.println("List Contents ::= "+list+" Size::= "+list.size());
		
		System.out.println("List Contents ::::::::::= "+list);
		
		System.out.println("Element Position ::= "+list.indexOf("r"));
		
		System.out.println("Element Contains ::= "+list.contains("x"));
		
		System.out.println("List Contents ::= "+list);
		
		System.out.println("Last Index Of Element ::= "+list.lastIndexOf("a"));
		
		
		/*IteratorI itr =  list.iterator();
		list.remove("m");
		System.out.println("List Contents :::=  "+list);
		list.add(5, "j");
		System.out.println("List Contents ::=  "+list);
		while(itr.hasNext()) {
			System.out.println("List Value ::= "+itr.next());
		}*/
		
	}

}
