package linkedlist;
/*
 * 
 * 1、插入 ：头插入和尾插入
 * 2、删除
 * 3、反转
 * 4、合并两个有序的链表
 * 5、链表中环的检测
 * 6、求链表的中间节点
 * 7、删除链表倒数第n个节点
 * */
public class SingleLinkedList {
	private Node head ;

	public static void main(String[] args) {
		SingleLinkedList list = new SingleLinkedList(); 
		list.tailInsert(1);
		list.tailInsert(2);
		list.tailInsert(3);
		list.tailInsert(4);
//		list.generateLoop(4);
		Node result = list.deleteReserveNode(6);
		System.out.println(result.data);
		System.out.println("--------");
		list.printAll(list.head);
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
	
	//构造循环链表
	public void generateLoop(int _data) {
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
		newNode.next = head ; //将新加入的节点指向头结点
	}
	
	//遍历
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
	
	//合并两个有序链表
	public Node combine(Node node1,Node node2) {
		if (node1 == null && node2 == null)return null ; 
		if (node1 == null && node2  != null)return node2 ;
		if (node2 == null && node1  != null)return node1 ;
			
		Node tmpOne = node1 ;
		Node tmpTwo = node2 ; 
		Node newNode = null ;
		
		//确定头结点
		if (tmpOne.data<tmpTwo.data) {
			newNode = tmpOne ; 
			tmpOne = tmpOne.next ; 
		} else {
			newNode = tmpTwo;
			tmpTwo = tmpTwo.next ; 
		}

		Node tmp = newNode  ;
		
		//合并 
		while (tmpOne != null && tmpTwo != null) {
			if (tmpOne.data < tmpTwo.data) {
				tmp.next = tmpOne;
				tmpOne = tmpOne.next ; 
			} else {
				tmp.next = tmpTwo;
				tmpTwo = tmpTwo.next ; 
			}
			tmp = tmp.next ; 
		}
		
		tmp.next = (tmpOne == null)?tmpTwo:tmpOne;
		
		return newNode; 
	}
	
	//链表中环的检测
	public boolean checkRing(Node _head) {
		if (_head == null)return false;
		Node slow = _head;
		Node fast =_head;
		while (slow != null && slow.next != null && fast != null && fast.next != null && fast.next.next != null) {
			slow = slow.next ; 
			fast = fast.next.next ; 
			if (slow == fast)return true;
		}
		return false;
	}
	
	//求链表的中间节点
	public Node getMiddle(Node _head) {
		if (_head == null)return null;
		Node slow = _head;
		Node fast =_head;
		while (slow != null && slow.next != null && fast != null && fast.next != null && fast.next.next != null) {
			slow = slow.next ; 
			fast = fast.next.next ; 
		}
		return slow;		
	}
	
	//找到倒数第n个节点
	public Node findReserve(int n) {
		if (n<1)return null; 
		// 设置快指针，先走n-1步 
		Node fast = head ;
		int i = 1 ;
		while (fast != null && i<n) {
			fast = fast.next ;
			++i;
		}
		Node tmpNode = head;
		while (fast.next != null) {
			fast = fast.next ;
			tmpNode = tmpNode.next ;
		}
		return tmpNode;
		
	}
	
	//删除倒数第n个节点
	public Node deleteReserveNode(int n) {
		if (head == null)return null;
		if (n<1)return null; 
		// 设置快指针，先走n-1步 
		Node fast = head ;
		int i = 1 ;
		while (fast != null && i<n) {
			fast = fast.next ;
			++i;
		}
		
		//超出链表长度，如链表长度为4，n为5 
		if (fast == null )return null;
			
		Node preNode = null ; 
		Node tmpNode = head;
		while (fast.next != null) {
			fast = fast.next ;
			preNode = tmpNode ; 
			tmpNode = tmpNode.next ;
		}
		
		if (preNode == null) {
			head = (head.next == null)?head:head.next;
			return head;
		}
		
		preNode.next = (tmpNode.next==null)?null:tmpNode.next;
		
		return tmpNode;
	}
	
	class Node{
		private int data ; 
		private Node next ; 
		public Node(int data) {
			this.data=data;
		}
	}

}
