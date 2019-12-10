package com.test.collections;

import java.util.Arrays;

/*
 * 1. add(Object)
 * 2. add(index,element)
 * 3. set(index,element)
 * 4. remove(index)
 * 5. remove(Object)
 * 6. clear()
 * 7. isEmpty()
 * 8. indexOf(Object)
 * 9. lastIndexOf(Object)
 * 10. contains(Object)
 * 11. toArray()
 * 12. toString()
 * 
 * */
public class ArrayListImpl {
	
	private final int SIZE_FACTOR = 5;
	//private final int CAPACITY_FACTOR = 2;
	private final Object[] DEFAULT_ARRAY = {};
	private Object[] data;
	private int actSize;
	
	public ArrayListImpl() {
		this.data = DEFAULT_ARRAY;
	}
	
	public void add(Object element) {
		ensureCapacity(actSize+1);
		data[actSize++] = element;
	}
	
	public void add(int index, Object element) {
		checkRange(index);
		ensureCapacity(actSize+1);
		System.arraycopy(data, index, data, index+1, actSize-index);
		data[index] = element;
		actSize++;
	}
	
	private void checkRange(int index) {
		if(index > actSize || index < 0) {
			throw new RuntimeException("Invalid index::= "+index);
		}
	}

	private void ensureCapacity(int iCapacityFactor) {
		if(data == DEFAULT_ARRAY) {
			iCapacityFactor = Math.max(SIZE_FACTOR, iCapacityFactor);
		}
		increaseListSize(iCapacityFactor);
	}
	
	private void increaseListSize(int iCapacityFactor) {
		data = Arrays.copyOf(data, iCapacityFactor);
	}
	
	public Object get(int index) {
		/*if(index < actSize) {
			return data[index];
		}else {
			throw new RuntimeException("Invalid Index::="+index);
		}*/
		checkRange(index);
		return data[index];
	}
	
	public Object remove(int index) {
		if(index < actSize) {
			Object obj = data[index];
			data[index] = null;
			int tmp = index;
			while(tmp < actSize) {
				data[tmp] = data[++tmp];
				data[tmp] = null;
			}
			actSize--;
			return obj;
		}else {
			throw new RuntimeException("Invalid Index::="+index);
		}
	}
	
	public boolean remove(Object element) {
		for(int i = 0;i < actSize;i++) {
			if(element == data[i]) {
				copyElement(i);
				return true;
			}
			else if(element.equals(data[i])) {
				copyElement(i);//remove element
				return true;
			}
		}
		return false;
	}

	public int size() {
		return actSize;
	}
	
	@Override
	public String toString() {
		StringBuilder sData = new StringBuilder("[");
		//for(Object obj : data) {
		for(int i = 0; i < actSize ; i++) {
			//if(obj != null) {
				sData.append(data[i]).append(",");
			//}
		}
		int lastIndex = sData.lastIndexOf(",");
		return sData.substring(0, lastIndex != -1 ? lastIndex : 1).concat("]");
	}
	
	public boolean isEmpty() {
		return actSize == 0;
	}
	
	public void clear() {
		for (int i = 0; i < data.length; i++) {
			data[i] = null; //All Objects will be eligible for Garbage Collection
		}
		actSize = 0;
	}

	private void copyElement(int index) {
		int numMoved = actSize - index - 1; // -1 is added to get the count of total number of elements moved
		if(numMoved > 0) {
			System.arraycopy(data, index+1, data, index, numMoved);
		}
		data[--actSize] = null;
	}

	public Object set(int index, Object element) {
		checkRange(index);
		Object oldElement = get(index);
		data[index] = element;
		return oldElement;
	}
	
	public Object[] toArray() {
		return Arrays.copyOf(data, actSize);
	}
	
	public boolean contains(Object element) {
		int index = indexOf(element);
		return index >= 0;
	}
	
	public int indexOf(Object element) {
		if(element == null) {
			for(int i= 0; i<actSize; i++) {
				if(data[i] == element) {
					return i;
				}
			}
		}else {
			for(int i=0; i<actSize; i++) {
				if(element.equals(data[i])) {
					return i;
				}
			}
		}
		return -1;
	}
	
	public int lastIndexOf(Object element) {
		if(element == null) {
			for(int i = actSize-1; i >= 0 ;i--) {
				if(data[i] == element) {
					return i;
				}
			}
		}else {
			for(int i = actSize-1; i >= 0 ;i--) {
				if(element.equals(data[i])) {
					return i;
				}
			}
		}
		return -1;
	}
	
	public IteratorI iterator() {//Pending Implementation in ArrayList "modCount" changes
		return new IteratorImpl();
	}
	
	private class IteratorImpl implements IteratorI{
		
		int cursor = 0;
		
		@Override
		public Object next() {
			/*if(cursor >= actSize) {
				throw new NoSuchElementException();
			}*/
			return data[cursor++];
		}

		@Override
		public boolean hasNext() {
			return cursor != actSize;
		}
		
	}
	
}
