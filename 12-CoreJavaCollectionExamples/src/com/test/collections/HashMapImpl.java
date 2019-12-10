package com.test.collections;

import java.util.Arrays;

/*
 * put(Object,Object)
 * get(Object)
 * remove(Object)
 * containsKey(Object)
 * containsValue(Object)
 * size()
 * isEmpty()
 * 
 * */
public class HashMapImpl {
	private Entry[] container;
	private static int CAPACITY = 5;
	private int size = 0;
	
	public HashMapImpl() {
		this.container = new Entry[CAPACITY];
	}
	
	public boolean put(Object key, Object value) {
		if((container.length - size) <= CAPACITY) {
			increaseMapCapacity();
		}
		
		int bucket = hash(key);
		System.out.println("bucket ::= "+bucket);
		Entry existingEntry = container[bucket];
		Entry newEntry = new Entry(bucket,key, value, null);
		if(existingEntry == null) {
			container[bucket] = newEntry;
			size++;
			return true;
		}else {
			while(existingEntry.getNext() != null) {
				if(existingEntry.getKey().equals(key)) {
					existingEntry.setValue(value);
					return true;
				}
				existingEntry = existingEntry.getNext();
			}
			
			if(existingEntry.getKey().equals(key)) {
				existingEntry.setValue(value);
				return true;
			}else {
				existingEntry.setNext(newEntry);
				size++;
				return true;
			}
		}
	}

	public Object get(Object key) {
		Object value = null;
		int bucket = hash(key);
		Entry tempEntry = container[bucket];
		while(tempEntry != null) {
			if(tempEntry.getKey().equals(key)) {
				value =  tempEntry.getValue();
			}
			tempEntry = tempEntry.getNext();
		}
		System.out.println("Entry size ::= "+container.length);
		return value;
	}
	
	public Object remove(Object key) {
		Object value = null;
		int bucket = hash(key);
		Entry tempEntry = container[bucket];
		Entry previousEntry = null;
		System.out.println("Container Length before::= "+container.length);
		while(tempEntry != null) {
			if(tempEntry.getKey().equals(key)) {
				if(previousEntry == null) {
					container[bucket] = tempEntry.getNext();
				}else {
					previousEntry.setNext(tempEntry.getNext());
				}
				value = tempEntry.getValue();
				size--;
				break;
			}else {
				previousEntry = tempEntry;
				tempEntry = tempEntry.getNext();
			}
		}
		System.out.println("Container Length after::= "+container.length);
		return value;
	}
	
	public Object containsKey(Object key) {
		Object keyFound = null;
		int bucket = hash(key);
		Entry tempEntry = container[bucket];
		//if(tempEntry == null) {
		if(tempEntry == null && size == 0) {
			return false;
			//return keyFound;
		}else {
			while(tempEntry != null) {
				if(tempEntry.getKey().equals(key)) {
					keyFound =  tempEntry.getKey();
					break;
				}
				tempEntry = tempEntry.getNext();
			}
		}
		return keyFound != null ? true : false;
	}
	
	public boolean containsValue(Object value) {
		Entry[] temp; 
		Object tempValue;
		
		if((temp = container) != null && (size > 0 )) {
			for(int i = 0; i < temp.length ; i++) {
				for(Entry entry = temp[i]; entry != null ; entry = entry.getNext()) {
					if((tempValue = entry.getValue()) == value || (value != null && value.equals(tempValue))) {
						return true; 
					}
				}
			}
		}
		return false;
	}
	
	private void increaseMapCapacity() {
		container = Arrays.copyOf(container, container.length*2);
	}

	private int hash(Object key) {
		if(key == null) {
			System.out.println("HashCode ::::::= 0");
			return 0;
		}
		int hashCode = key.hashCode();
		System.out.println("HashCode ::= "+hashCode);
		return Math.abs(hashCode) % CAPACITY;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	private class Entry {
		
		private int hash;

		private Object key;

		private Object value;

		private Entry next;

		public Entry(int hash, Object key, Object value, Entry next) {
			super();
			this.hash = hash;
			this.key = key;
			this.value = value;
			this.next = next;
		}

		/*public int getHash() {
			return hash;
		}

		public void setHash(int hash) {
			this.hash = hash;
		}*/
		
		public Object getKey() {
			return key;
		}

		/*public void setKey(Object key) {
			this.key = key;
		}*/

		public Object getValue() {
			return value;
		}

		public void setValue(Object value) {
			this.value = value;
		}

		public Entry getNext() {
			return next;
		}

		public void setNext(Entry next) {
			this.next = next;
		}

		@Override
		public String toString() {
			return  key + " = " + value;
		}
		
	}
	
	@Override
	public String toString() {
		StringBuilder sData = new StringBuilder("[");	
		for(Entry entry : container) {
			Entry tempEntry = entry;
			while(tempEntry != null) {
				sData.append(tempEntry).append(",");
				tempEntry = tempEntry.getNext();
			}
		}
		int lastIndex = sData.lastIndexOf(",");
		return sData.substring(0, lastIndex != -1 ? lastIndex : 1 ).concat("]");
	}
	
}
