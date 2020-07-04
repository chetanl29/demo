package com.test.collections;

import java.util.Arrays;

/*
 * add(Object)
 * contains(Object)
 * remove(Object)
 * size()
 * isEmpty()
 * 
 * */
public class HashSetImpl {
	
	private HashMapImpl mapImpl = null;
	
	public HashSetImpl() {
		mapImpl = new HashMapImpl();
	}
	
	public boolean add(Object key) {
		return mapImpl.put(key, null);
	}
	
	public boolean contains(Object key) {
		return mapImpl.containsKey(key) != null ? true : false;
	}
	
	public boolean remove(Object key) {
		return mapImpl.remove(key) != null;
	}
	
	public int size() {
		return mapImpl.getSize();
	}
	
	public boolean isEmpty() {
		return mapImpl.isEmpty();
	}
	
	@Override
	public String toString() {
		return mapImpl.toString();
	}
	
	private class HashMapImpl {
		
		private Entry[] container;
		
		private final int CAPACITY = 5;
		
		private int size = 0;
		
		public HashMapImpl() {
			container = new Entry[CAPACITY];
		}
		
		private int hash(Object key) {
			int hashCode = key.hashCode();
			return Math.abs(hashCode % CAPACITY);
		}
		
		public boolean put(Object key,Object value) {
			if((container.length - size) <= size) {
				increaseMapCapacity();
			}
			Entry newEntry = new Entry(key, value, null);
			int bucket = hash(key);
			Entry existingEntry = container[bucket];
			
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
		
		public Object containsKey(Object key) {
			Object keyFound = null;
			int bucket = hash(key);
			Entry tempEntry = container[bucket];
			if(tempEntry == null) {
				return keyFound;
			}else {
				while(tempEntry != null) {
					if(tempEntry.getKey().equals(key)) {
						keyFound = tempEntry.getKey();
						break;
					}
					tempEntry = tempEntry.getNext();
				}
			}
			return keyFound;
		}
		
		public boolean containsValue(Object value) {
			Entry[] temp;
			Object tempValue;
			
			if((temp = container) != null && (size >0)) {
				for(int i = 0; i < temp.length; i++) {
					for(Entry entry = temp[i]; entry != null; entry = entry.getNext()) {
						if((tempValue = entry.getValue()) == value || (value != null && value.equals(tempValue))) {
							return true;
						}
					}
				}
			}
			return false;
		}
		
		public Object remove(Object key) {
			Object value = null;
			int bucket = hash(key);
			Entry tempEntry = container[bucket];
			Entry previousEntry = null;
			while(tempEntry != null) {
				if(tempEntry.getKey().equals(key)) {
					if(previousEntry == null) {
						container[bucket] = tempEntry.getNext();
					}else {
						previousEntry.setNext(tempEntry.getNext());
					}
					value = tempEntry.getKey();
					size--;
					break;
				}else {
					previousEntry = tempEntry;
					tempEntry = tempEntry.getNext();
				}
			}
			return value;
		}
		
		private void increaseMapCapacity() {
			container = Arrays.copyOf(container, container.length * 2);
		}

		public int getSize() {
			return size;
		}
		
		public boolean isEmpty() {
			return size == 0;
		}
		
		@Override
		public String toString() {
			StringBuilder sData = new StringBuilder("[");
			for(Entry entry : container) {
				Entry tempEntry = entry;
				while(tempEntry != null) {
					sData.append(tempEntry.getKey()).append(",");
					tempEntry = tempEntry.getNext();
				}
			}
			int lastIndex = sData.lastIndexOf(",");
			return sData.substring(0 , lastIndex != -1 ? lastIndex : 1).concat("]");
		}

		private class Entry {
			
			private Object key;
			
			private Object value;
			
			private Entry next;
			
			public Entry(Object key, Object value, Entry next) {
				super();
				this.key = key;
				this.value = value;
				this.next = next;
			}

			public Object getKey() {
				return key;
			}

			public void setKey(Object key) {
				this.key = key;
			}

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
				return key + " = "+value;
			}
		}
		
	}
	
	

}
