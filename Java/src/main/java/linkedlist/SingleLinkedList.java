package linkedlist;
/*
 * 
 * 1、插入 ：头插入和尾插入
 * 2、删除
 * 3、反转
 * 4、合并两个有序的链表
 * 
 * */
public class SingleLinkedList {
	private Node head ;

	public static void main(String[] args) {
		SingleLinkedList list = new SingleLinkedList(); 
		list.tailInsert(1);
		list.tailInsert(2);
		list.tailInsert(3);
		list.printAll(list.head);
		System.out.println("---------------");
		Node result = list.reserve(list.head);
		list.printAll(result);
	}
	
	//插入-头插入
	public void headInsert(int _data) {
		if (head==null) {
			head = new Node(_data);
			return  ;
		}
		Node newNode = new Node(_data);
		newNode.next = head ; 
		head = newNode ; 
	}
	
	//插入-尾插入
	public void tailInsert(int _data) {
		if (head == null) {
			head = new Node(_data);
			return ; 
		}
		
		Node newNode = new Node(_data);
		Node tmpNode = head;
		while (tmpNode.next != null) {
			tmpNode = tmpNode.next ; 
		}
		tmpNode.next = newNode ; 
	}
	
	public void printAll(Node _head) {
		if (_head == null) return ; 
		Node tmpNode = _head ;
		while (tmpNode != null) {
			System.out.println(tmpNode.data);
			tmpNode = tmpNode.next;
		}
	}
	
	//删除
	public void delete(int _data) {
		if (head == null)return ; 
		
		Node preNode = null; 
		Node tmpNode = head ; 
		while (tmpNode != null && tmpNode.data != _data ) {
			preNode = tmpNode;
			tmpNode = tmpNode.next ; 
		}
		
		//链表里没有要删除的元素
		if (tmpNode == null)return ; 
			
		//要删除的是头结点
		if (preNode == null) {
			if (head.next == null) head = null;
			else head = head.next ; 
			return ; 
		}

		if (tmpNode.next == null) preNode.next = null;  //删除的是尾节点
		else preNode.next = tmpNode.next;               
	}
	
	//链表反转 
	public Node reserve(Node _head) {
		if (_head == null || _head.next == null) return _head;
		Node preNode = null ; 
		Node tmpNode = _head ; 
		Node nextNode = null ; 
		while (tmpNode != null) {
			nextNode = tmpNode.next;
			tmpNode.next = preNode ;
			preNode = tmpNode ; 
			tmpNode = nextNode ; 
		}
		return preNode;
	}
	
	class Node{
		private int data ; 
		private Node next ; 
		public Node(int data) {
			this.data=data;
		}
	}

}
