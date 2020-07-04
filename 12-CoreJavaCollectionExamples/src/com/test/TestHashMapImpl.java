package com.test;

import com.test.collections.HashMapImpl;

public class TestHashMapImpl {

	public static void main(String[] args) {
		HashMapImpl impl = new HashMapImpl();
		impl.put(11, "Hi");
		impl.put(11, "Hi");
		System.out.println("Map Contents ::= "+impl);
		impl.put(15, "Hi");
		impl.put(16, "Hi");
		impl.put(17, "Hi");
		impl.put(18, "Hi");
		impl.put(19, "Hi");
		impl.put(20, "Hi");
		impl.put(21, "bye");
		impl.put(21, "sye");
		impl.put(31, "hello");
		impl.put(31, "helloooo");
		impl.put(null, null);
		System.out.println("Map Contents :::= "+impl);
		
		System.out.println("Map Size ::= "+impl.size());
		
		System.out.println("Map Get ::= "+impl.get(12));
		
		//System.out.println("Map Remove ::= "+impl.remove(11));
		impl.put(11, "Hi");
		
		System.out.println("Map Contents ::= "+impl);
		
		System.out.println("Map Size ::= "+impl.size());
		
		System.out.println("Map Contains Key ::= "+impl.containsKey(61));
		
		System.out.println("Map Conatins Value ::= "+impl.containsValue(null));
	}

}
