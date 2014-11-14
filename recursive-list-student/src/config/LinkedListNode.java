package config;

public class LinkedListNode<T> {
	T elem;
	private LinkedListNode<T> link;

	public LinkedListNode(T info) {
		this.elem = info;
		link = null;
	}

	public T getInfo() {
		return elem;
	}

	public LinkedListNode<T> getLink() {
		return link;
	}

	public void setInfo(T a) {
		elem = a;
	}

	public void setLink(LinkedListNode<T> lnk) {
		link = lnk;
	}
}