package com.test.collections;

import java.util.NoSuchElementException;

/*
 * 1. add(Object)
 * 2. add(index,Object)
 * 3. addFirst(Object)
 * 4. addLast(Object)
 * 5. size()
 * 6. isEmpty()
 * 7. toString()
 * 8. toArray()
 * 9. get(index)
 * 10. getFirst()
 * 11. getLast()
 * 12. remove(index)
 * 13. removeFirst()
 * 14. removeLast()
 * 15. remove(Object)
 * 16. indexOf(Object)
 * 17. lastIndexOf(Object)
 * 18. contains(Object)
 * 19. set(index,Object)
 * 20. clear()
 *  
 * */
public class SinglyLinkedListImpl {
	
	private Node head;
	
	private int actSize;
	
	public void add(Object element) {
		linkLast(element);
	}
	
	public void add(int index, Object element) {
		checkRange(index);
		if(index == 0) {
			addFirst(element);
		}else {
			Node previous = getNode(index-1);
			Node temp = getNode(index);
			Node node = new Node(element,temp);
			previous.next = node;
		}
		actSize++;
	}
	
	public void addFirst(Object element) {
		Node node = new Node(element, head);
		head = node;
		actSize++;
	}
	
	public void addLast(Object element) {
		linkLast(element);
	}
	
	private void linkLast(Object element) {
		Node node = new Node(element, null);
		if(head == null) {
			head = node;
		}else {
			Node temp = head;
			while(temp.next != null) {
				temp = temp.next;
			}
			temp.next = node;
		}
		actSize++;
	}
	
	public int size() {
		return actSize;
	}
	
	public boolean isEmpty() {
		return actSize == 0;
	}
	
	@Override
	public String toString() {
		StringBuilder sBData = new StringBuilder("[");
		Node temp = head;
		while(temp != null) {
			sBData.append(temp.data).append(",");
			temp = temp.next;
		}
		int lastIndex = sBData.lastIndexOf(",");
		return sBData.substring(0, lastIndex != -1 ? lastIndex : 1).concat("]").toString();
	}
	
	public Object get(int index) {
		checkRange(index);
		Node temp = getNode(index);
		return temp.data;
	}
	
	public Object getFirst() {
		if(head == null) {
			throw new NoSuchElementException("Empty List");
		}
		return head.data;
	}
	
	public Object getLast() {
		if(head == null) {
			throw new NoSuchElementException("Empty List");
		}
		return get(actSize-1);
	}
	
	public Object remove(int index) {
		checkRange(index);
		if(index == 0) {
			return unlinkFirst();
		}
		Node node = getNode(index-1);
		Node temp = getNode(index);
		node.next = temp.next;
		temp.next = null;
		actSize--;
		return temp.data;
	}
	
	public Object removeFirst() {
		return unlinkFirst();
	}
	
	public Object removeLast() {
		return unLinkLast();
	}
	
	public boolean remove(Object element) {
		Node temp = head;
		if(temp == null) {
			throw new NoSuchElementException("Empty List");
		}
		if(element == null) {
			Node previous = null;
			while(temp.next != null) {
				if(temp.data == null) {
					if(previous != null) {
						previous.next = temp.next;
					}else {
						head = temp.next;
					}
					temp.next = null;
					actSize--;
					return true;
				}
				previous = temp;
				temp = temp.next;
			}
			
		}else {
			Node previous = null;
			while(temp.next != null) {
				if(element.equals(temp.data)) {
					if(previous != null) {
						previous.next = temp.next;
					}else {
						head = temp.next;
					}
					temp.next = null;
					actSize--;
					return true;
				}
				previous = temp;
				temp = temp.next;
			}
		}
		return false;
	}
	
	public int indexOf(Object element) {
		int index = 0;
		
		if(element == null) {
			for(Node temp = head; temp != null; temp = temp.next) {
				if(temp.data == null) {
					return index;
				}
				index++;
			}
		}else {
			for(Node temp = head; temp != null; temp = temp.next) {
				if(element.equals(temp.data)) {
					return index;
				}
				index++;
			}
		}
		return -1;
	}
	
	public int lastIndexOf(Object element) {
		int index = 0;
		int elementIndex = -1;
		
		if(element == null) {
			for(Node temp = head; temp != null; temp = temp.next) {
				if(temp.data == null) {
					elementIndex = index;
				}
				index++;
			}
		}else {
			for(Node temp = head; temp != null; temp = temp.next) {
				if(element.equals(temp.data)) {
					elementIndex = index;
				}
				index++;
			}
		}
		return elementIndex;
	}
	
	public boolean contains(Object element) {
		return indexOf(element) != -1;
	}
	
	private Object unlinkFirst() {
		Node temp = head;
		if(temp == null) {
			throw new NoSuchElementException("Empty List");
		}
		head = temp.next;
		temp.next = null;
		actSize--;
		return temp.data;
	}
	
	private Object unLinkLast() {
		if(head == null) {
			throw new NoSuchElementException("Empty List");
		}
		Node temp = head;
		Node previous = null;
		while(temp.next != null) {
			previous = temp;
			temp = temp.next;
		} 
		previous.next = null;
		actSize--;
		return temp.data;
	}
	
	private void checkRange(int index) {
		if(index < 0 || index >= actSize) {
			throw new IndexOutOfBoundsException("Invalid index ::= "+index);
		}
	}
	
	private Node getNode(int index) {
		Node temp = head;
		for(int i = 0; i < index; i++) {
			temp = temp.next;
		}
		return temp;
	}
	
	public Object[] toArray() {
		Object[] data = new Object[actSize];
		int index = 0;
		for(Node temp = head; temp != null; temp = temp.next) {
			data[index++] = temp.data;
		}
		return data;
	}
	
	public void clear() {
		for(Node temp = head; temp != null;) {
			Node node = temp.next;
			temp.data = null;
			temp.next = null;
			temp = node;
		}
		head = null;
		actSize = 0;
	}
	
	public Object set(int index, Object element) {
		checkRange(index);
		Node node = getNode(index);
		Object oldElement = node.data;
		node.data = element;
		return oldElement;
	}

	private class Node {
		
		private Object data;
		
		private Node next;

		public Node(Object data, Node next) {
			super();
			this.data = data;
			this.next = next;
		}

	}

}
