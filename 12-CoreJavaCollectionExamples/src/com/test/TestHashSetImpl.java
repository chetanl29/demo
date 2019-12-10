package com.test;

import com.test.collections.HashSetImpl;

public class TestHashSetImpl {

	public static void main(String[] args) {
		HashSetImpl impl = new HashSetImpl();
		impl.add(11);
		impl.add(15);
		impl.add(16);
		impl.add(17);
		impl.add(18);
		impl.add(20);
		impl.add(21);
		System.out.println("Set Contents::= "+impl);
		
		System.out.println("Set Contains Element ::= "+impl.contains(50));
		
		System.out.println("Size of Set before element removal ::= "+impl.size());
		
		System.out.println("Remove element from Set ::= "+impl.remove(10));
		
		System.out.println("Size of Set after element removal ::= "+impl.size());
		
		System.out.println("Set contents ::= "+impl);
	}

}
