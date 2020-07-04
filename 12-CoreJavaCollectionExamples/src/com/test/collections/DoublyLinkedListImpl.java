package com.test.collections;

import java.util.NoSuchElementException;

/*
 * 1. add(Object)
 * 2. addFirst(Object)
 * 3. addLast(Object)
 * 4. add(index,Object)
 * 5. get(index)
 * 6. getFirst()
 * 7. getLast()
 * 8. remove(index)
 * 9. removeFirst()
 * 10. removeLast()
 * 11. remove(Object)
 * 12. size()
 * 13. toString()
 * 14. isEmpty()
 * 15. indexOf(Object)
 * 16. lastIndexOf(Object)
 * 17. contains(Object)
 * 18. toArray()
 * 19. set(index,Object)
 * 20. clear()
 * 
 * */
public class DoublyLinkedListImpl {
	
	private Node first;
	
	private Node last;
	
	private int actSize;
	
	public void add(Object element) {
		linkLast(element);
	}
	
	public void addFirst(Object element) {
		linkFirst(element);
	}
	
	public void addLast(Object element) {
		linkLast(element);
	}
	
	public void add(int index, Object element) {
		checkRange(index);
		
		if(index == actSize) {
			linkLast(element);
		}else {
			linkBefore(element, getNode(index));
		}
	}
	
	private void linkBefore(Object element, Node succ) {
		Node prev = succ.previous;
		Node node = new Node(prev,element,succ);
		succ.previous = node;
		if(prev == null) {
			first = node;
		}else {
			prev.next = node;
		}
		actSize++;
	}

	private void linkFirst(Object element) {
		Node temp = first;
		Node node = new Node(null,element,temp);
		first = node;
		if(temp == null) {
			last = node;
		}else {
			temp.previous = node;
		}
		actSize++;
	}

	private void linkLast(Object element) {
		Node temp = last;
		Node node = new Node(temp,element,null);
		last = node;
		if(temp == null) {
			first = node;
		}else {
			temp.next = node;
		}
		actSize++;
	}
	
	public Object get(int index) {
		checkRange(index);
		Node node = getNode(index);
		return node.data;
	}
	
	public Object getFirst() {
		Node temp = first;
		if(temp == null) {
			throw new NoSuchElementException("Empty List");
		}
		return temp.data;
	}
	
	public Object getLast() {
		Node temp = last;
		if(temp == null) {
			throw new NoSuchElementException("Empty List");
		}
		return temp.data;
	}
	
	private Node getNode(int index) {
		if(index < (actSize >> 1)) {
			Node temp = first;
			for(int i = 0 ; i < index ; i++) {
				temp = temp.next;
			}
			return temp; 
		}else {
			Node temp = last;
			for(int i = actSize-1; i > index; i--) {
				temp = temp.previous;
			}
			return temp;
		}	
	}
	
	public Object remove(int index) {
		checkRange(index);
		return unLink(getNode(index));
	}
	
	public Object removeFirst() {
		Node temp = first;
		if(temp == null) {
			throw new NoSuchElementException("Empty list no details to remove");
		}
		return unLinkFirst(temp);
	}
	
	public Object removeLast() {
		Node temp = last;
		if(temp == null) {
			throw new NoSuchElementException("Empty list no details to remove");
		}
		return unlinkLast(temp);
	}
	
	public boolean remove(Object element) {
		if(element == null) {
			for(Node temp = first; temp != null; temp = temp.next) {
				if(temp.data == element) {
					unLink(temp);
					return true;
				}
			}
		}else {
			for(Node temp = first; temp != null; temp = temp.next) {
				if(element.equals(temp.data)) {
					unLink(temp);
					return true;
				}
			}
		}
		return false;
	}
	
	private Object unlinkLast(Node node) {
		Object element = node.data;
		Node prev = node.previous;
		node.data = null;
		node.previous = null;
		last = prev;
		if(prev == null) {
			first = null;
		}else {
			prev.next = null;
		}
		actSize--;
		return element;
	}

	private Object unLinkFirst(Node node) {
		Object element = node.data;
		Node next = node.next;
		node.data = null;
		node.next = null;
		first = next;
		if(next == null) {
			last = null;
		}else {
			next.previous = null;
		}
		actSize--;
		return element;
	}

	private Object unLink(Node node) {
		Object element = node.data;
		Node prev = node.previous;
		Node next = node.next;
		
		if(prev == null) {
			first = next;
		}else {
			prev.next = next;
			node.previous = null;
		}
		
		if(next == null) {
			last = prev;
		}else {
			next.previous = prev;
			node.next = null;
		}
		node.data = null;
		actSize--;
		return element;
	}

	private void checkRange(int index) {
		if(index < 0 || index >= actSize) {
			throw new IndexOutOfBoundsException("Invalid Index::= "+index);
		}
	}

	public int size() {
		return actSize;
	}
	
	public boolean isEmpty() {
		return actSize == 0;
	}
	
	public String toString() {
		StringBuilder sData = new StringBuilder("[");
		Node tempNode = first;
		while(tempNode != null) {
			sData.append(tempNode.data).append(",");
			tempNode = tempNode.next;
		}
		int lastIndex = sData.lastIndexOf(",");
		return sData.substring(0, lastIndex != -1 ? lastIndex : 1).concat("]").toString();
	}
	
	public int indexOf(Object element) {
		int index = 0;

		if(element == null) {
			for(Node temp = first; temp != null; temp = temp.next) {
				if(temp.data == null) {
					return index;
				}
				index++;
			}
		}else {
			for(Node temp = first; temp != null; temp = temp.next) {
				if(element.equals(temp.data)){
					return index;
				}
				index++;
			}
		}
		return -1;
	}
	
	public int lastIndexOf(Object element) {
		int index = actSize;
		if(element == null) {
			for(Node temp = last; temp != null; temp = temp.previous) {
				index--;
				if(temp.data == null) {
					return index;
				}
			}
		}else {
			for(Node temp = last; temp != null; temp = temp.previous) {
				index--;
				if(element.equals(temp.data)) {
					return index;
				}
			}
		}
		return -1;
	}
	
	public boolean contains(Object element) {
		return indexOf(element) != -1;
	}
	
	public Object[] toArray() {
		int index = 0;
		Object[] temp = new Object[actSize];
		for(Node node = first; node != null; node = node.next) {
			temp[index++] = node.data;
		}
		return temp;
	}
	
	public Object set(int index, Object element) {
		checkRange(index);
		Node node = getNode(index);
		Object oldElement = node.data;
		node.data = element;
		return oldElement;
	}
	
	public void clear() {
		for(Node temp = first; temp != null;) {
			Node node = temp.next;
			node.previous = null;
			node.data = null;
			node.next = null;
			temp = node;
		}
		first = last = null;
		actSize = 0;
	}
	
	private class Node {
		public Node previous;
		public Object data;
		public Node next;

		public Node(Node previous, Object data, Node next) {
			super();
			this.previous = previous;
			this.data = data;
			this.next = next;
		}
	}

}
