package com.test.collections;

public class LinkedListImpl {
	
	private Node head;
	private int actSize = 0;
	
	public void add(Object element) {
		Node newNode = new Node(element);
		if (head == null) {
			head = new Node(element);
		} else {
			Node tempNode = head;
			while (tempNode.getNext() != null) {
				tempNode = tempNode.getNext();
			}
			tempNode.setNext(newNode);
		}
		actSize++;
	}
	
	public void addFirst(Object element) {
		Node newNode = new Node(element);
		newNode.setNext(head);
		head = newNode;
		actSize++;
	}
	
	public void addLast(Object element) {
		Node newNode = new Node(element);
		if(head == null) {
			head = newNode;
		}else { 
			Node temp = head;
			/*while(temp != null) {
				temp = temp.getNext();
				if(temp.getNext() == null) {
					break;
				}
			}*/
			while(temp.getNext() != null) {
				temp = temp.getNext();
			}
			temp.setNext(newNode);
		}
		actSize++;
	}
	
	public void addAtIndex(int index,Object element) {
		if(index <= 0 ||index > actSize) {
			throw new RuntimeException("Invalid index");
		}else {
			Node newNode = new Node(element);
			Node tempNode = head;
			for(int i = 0 ; i < index - 2 ; i++) {
				tempNode = tempNode.getNext();
			}
			newNode.setNext(tempNode.getNext());
			tempNode.setNext(newNode);
			actSize++;
		}
	}
	
	public String toString() {
		StringBuilder sData = new StringBuilder("[");
		Node tempNode = head;
		while (tempNode != null) {
			sData.append(tempNode.getData()).append(",");
			tempNode = tempNode.getNext();
		}
		int lastIndex = sData.lastIndexOf(",");
		return sData.substring(0, lastIndex != -1 ? lastIndex : 1).concat("]").toString();
	}
	
	public int size() {
		return actSize;
	}
	
	public boolean isEmpty() {
		return actSize == 0;
	}
	
	public Object get(int index) {
		Node tempNode = head;
		if(index <= 0 || index > actSize) {
			throw new RuntimeException("Invalid index::= "+index);
		}
		for(int i = 0; i < index-1; i++) { 
			tempNode = tempNode.getNext();
			/*if(tempNode == null) {
				throw new RuntimeException("Index Overflow....");
			}*/
		}
		return tempNode.getData();
	}
	
	public Object remove(int index) {
		Object data = 0;
		if(index <= 0 || index > actSize) {
			throw new IndexOutOfBoundsException("Invalid Index ::= "+index);
		}else {
			if(index == 1) {
				data = head.getData();
				head = head.getNext();
				actSize--;
				return data;
			}
			Node temp = head;
			Node deleteNode = null;
			for(int i = 0; i < index - 2 ; i++) {
				temp = temp.getNext();
			}
			deleteNode = temp.getNext();
			data = deleteNode.getData();
			temp.setNext(deleteNode.getNext());
			deleteNode = null;
			actSize--;
			return data;
		}
	}
	
	public Object removeFirst() {
		if(head == null) {
			throw new RuntimeException("No Node to Delete");
		}else {
			Node tempNode = head;
			head = tempNode.getNext();
			actSize--;
			return tempNode.getData();
		}
	}
	
	public Object removeLast() {
		if(head == null) {
			throw new RuntimeException("No nodes to Delete..");
		}
		
		if(head.getNext() == null) {
			Node tempNode = head;
			head.setNext(head.getNext());
			actSize--;
			return tempNode.getData();
		}
		
		Node previousNode = null;
		Node tempNode = head;
		while(tempNode.getNext() != null) {
			previousNode = tempNode;
			tempNode = tempNode.getNext();
		}
		actSize--;
		previousNode.setNext(null);
		return tempNode.getData();
	}
	
	/*public boolean remove(int index) {
		if(index < 0 || index >= actSize) {
			throw new IndexOutOfBoundsException("Invalid Index ::= "+index);
		}else {
			Node temp = head;
			if(index == 0) {
				head = head.getNext();
				return true;
			}
			for(int i = 0; i < index - 1 ; i++) {
				temp = temp.getNext();
			}
			temp.setNext(temp.getNext().getNext());
			actSize--;
			return true;
		}
	}*/
	
	private class Node {
		
		private Object data;
		
		private Node next;
		
		public Node(Object data) {
			this.data = data;
		}
		
		public Node getNext() {
			return next;
		}
		
		public void setNext(Node next) {
			this.next = next;
		}
		
		public Object getData() {
			return data;
		}
		
		public void setData(Object data) {
			this.data = data;
		}
	}

}
