package config;

import structure.ListInterface;

public class LinkedList<T> implements ListInterface<T> {
	
	private LinkedListNode<T> head;
	private LinkedListNode<T> tail;
	private int size;
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public ListInterface<T> insertFirst(T elem) {
		// TODO Auto-generated method stub
		if(elem == null) {
			throw new NullPointerException();
		}
		if(head == null) {//if the head is null, create the head
			head = new LinkedListNode<T>(elem);
			tail = head;
		}
		else {
			LinkedListNode<T> temp = new LinkedListNode<T>(elem);
			temp.setLink(head);
			head = temp;
		}
		this.size ++;
		return this;
	}

	@Override
	public ListInterface<T> insertLast(T elem) {
		// TODO Auto-generated method stub
		if(elem == null) {
			throw new NullPointerException();
		}
		if(head == null) {//if the head is null, create the head
			head = new LinkedListNode<T>(elem);
			tail = head;
		}
		else {
			LinkedListNode<T> temp = new LinkedListNode<T>(elem);
			tail.setLink(temp);
			tail = temp;
			temp.setLink(null);
		}
		this.size ++;
		return this;
	}

	@Override
	public ListInterface<T> insertAt(int n, T elem) {
		// TODO Auto-generated method stub
		if (n > this.size || n < 0){ //check the index of n
			throw new IndexOutOfBoundsException();
		}
		if(n == 0) {
			insertFirst(elem);
		}
		else if(n == size) {
			insertLast(elem);
		}
		else {
			insertAtFrom(head, n-1, elem); //
		}
		return this;
	}
	
	private void insertAtFrom(LinkedListNode<T> start, int n, T elem) {
		if(n == 0) {
			LinkedListNode<T> temp = new LinkedListNode<T>(elem);
			temp.setLink(start.getLink());
			start.setLink(temp);
			size++;
		}
		else {
			n--;
			insertAtFrom(start.getLink(), n, elem);
		}
	}

	@Override
	public T removeFirst() {
		// TODO Auto-generated method stub
		if(isEmpty())
			throw new IllegalStateException();
		
		LinkedListNode<T> temp = head;
		head = head.getLink();
		size--;
		return temp.getInfo();
	}

	@Override
	public T removeLast() {
		// TODO Auto-generated method stub
		if(isEmpty())
			throw new IllegalStateException();
		
		if(size == 1)
			return removeFirst();
		else 
			return removeAt(size - 1);
	}

	@Override
	public T removeAt(int n) {
		// TODO Auto-generated method stub
		if (n >= this.size || n <= 0){ //check the index of n
			throw new IndexOutOfBoundsException();
		}
		T result = null;
		n--;
		result = removeAtFrom(head, n);

		this.size--;
		return result;
	}
	
	private T removeAtFrom(LinkedListNode<T> start, int n) {
		T result = null;
		if(n == 0) {
			result = start.getLink().getInfo();
			if(start.getLink().getLink() == null) {
				tail = start;
				start.setLink(null);
			}
			else {
				LinkedListNode<T> temp = start.getLink().getLink();
				start.setLink(temp);
			}	
		}
		else {
			n--;
			result = removeAtFrom(start.getLink(), n);
		}
		return result;
	}

	@Override
	public T getFirst() {
		// TODO Auto-generated method stub
		if(head == null)
			throw new IllegalStateException();
		return this.head.getInfo();
	}

	@Override
	public T getLast() {
		// TODO Auto-generated method stub
		if(tail == null)
			throw new IllegalStateException();
		return this.tail.getInfo();
	}

	@Override
	public T get(int i) {
		// TODO Auto-generated method stub
		return getAtFrom(head,i);
	}
	
	private T getAtFrom(LinkedListNode<T> start,int i) {
		T result = null; 
		if(i == 0) {
			result = start.getInfo();
		}
		else {
			i--;
			result = getAtFrom(start.getLink(), i);
		}
		return result;
	}

	@Override
	public boolean remove(T elem) {
		// TODO Auto-generated method stub
		int result = contains(elem);	
		
		if(result == -1)
			return false;
		else {
			if(result == 0)
				removeFirst();
			else if(result == (size -1)) {
				removeLast();
			}
			else {
				removeAt(result);
			}
			return true;	
		}

	}

	@Override
	public int contains(T elem) {
		// TODO Auto-generated method stub
		return contains(elem, head, 0);
	}
	
	private int contains(T toFind, LinkedListNode<T> toCheck, int currentIndex)
	{	
		if(toCheck.getInfo() == toFind) {
			return currentIndex;
		}
		else {
			if(currentIndex == (size - 1))
				return -1;
			else 		
				return contains(toFind, toCheck.getLink(), ++currentIndex);
		}
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if(this.size == 0)
			return true;
		return false;
	}

	
	
}
