package com.java.interview;

import java.util.Objects;

public class SinglyLinkedList {

	public static void main(String[] args) {
		CustomeLinkList<String> list = new CustomeLinkList<>();
		list.add("a");
		list.add("b");
		list.printList();
		CustomeLinkList<Integer> list1 = new CustomeLinkList<>();
		list1.add(1);
		list1.add(2);
		list1.add(4);
		list1.add(3, 0);
		list1.printList();
		CustomeLinkList<Object> list2 = new CustomeLinkList<>();
		list2.add("String");
		list2.add(1);
		list2.add(1.2F);
		list2.printList();
	}

}

class Node<T> {
	public T value;
	public Node<T> next;

	public Node(T value) {
		super();
		this.value = value;
		this.next = null;
	}

}

class CustomeLinkList<T> {
	private Node<T> head = null;
	public Node<T> tail = null;
	public int size = 0;

	public void add(T value) {
		Node<T> node = new Node<>(value);
		if (Objects.isNull(head)) {
			head = node;
			tail = node;
		} else {
			tail.next = node;
			tail = node;
		}
		size++;
	}

	public void add(T value, int index) {
		Node<T> node = new Node<>(value);
		if (Objects.isNull(head)) {
			head = node;
			tail = node;
		} else {
			if (size < index) {
				System.out.println("index out of bound!!");
				return;
			}
			int cnt = 0;
			Node<T> current = head;
			while (cnt != index-1) {
				current = current.next;
				cnt++;
			}
			Node<T> temp = current;
			node.next = temp.next;
			current.next = node;
		}
	}

	public void printList() {
		Node<T> current = head;
		if (head == null) {
			System.out.println("List is empty");
			return;
		}
		System.out.println("Nodes of singly linked list: ");
		while (current != null) {
			System.out.print(current.value + " ");
			current = current.next;
		}
		System.out.println();
	}
}