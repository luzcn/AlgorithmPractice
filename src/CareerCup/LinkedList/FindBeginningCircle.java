package CareerCup.LinkedList;


/**
 * Problem: Given a circular linked list, implement an algorithm which returns the node at the beginning of the loop.
 * Input: A->B->C->D->E->C
 * Output: C
 * @author Zheng Lu
 *
 */

/**
 * The algorithm is pretty straightforward: 1.We start at the beginning of the
 * linked list with two pointers.
 * 
 * 2.The first pointer is incremented through each node of the list. The second
 * pointer moves twice as fast, and skips every other node.
 * 
 * 3.If the linked list contains a loop, these two pointers will eventually meet
 * at the same node, thus indicating that the linked list contains a loop.
 */

public class FindBeginningCircle
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		/*
		 * SinglyLinkedList<String> list = new SinglyLinkedList<String>("A");
		 * SinglyLinkedList<String> list2 = new SinglyLinkedList<String>("b");
		 * SinglyLinkedList<String> list3 = new SinglyLinkedList<String>("c");
		 * SinglyLinkedList<String> list4 = new SinglyLinkedList<String>("d");
		 * SinglyLinkedList<String> list5 = new SinglyLinkedList<String>("e");
		 */
		LinkedNode<String> n1 = new LinkedNode<String>("A");
		LinkedNode<String> n2 = new LinkedNode<String>("b");
		LinkedNode<String> n3 = new LinkedNode<String>("c");
		LinkedNode<String> n4 = new LinkedNode<String>("d");
		LinkedNode<String> n5 = new LinkedNode<String>("e");
		LinkedNode<String> n6 = new LinkedNode<String>("f");
		LinkedNode<String> n7 = new LinkedNode<String>("g");

		/** Build a circular **/
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n3;

		FindBeginningCircle find = new FindBeginningCircle();
		System.out.println(find.findbegin(n1).data);
	}

	private LinkedNode<String> findmeet(LinkedNode<String> list)
	{
		LinkedNode<String> p1 = list;
		LinkedNode<String> p2 = list;

		while (p2.next != null)
		{
			p1 = p1.next;
			p2 = p2.next.next;
			if (p1 == p2)
				break;
		}
		return p2;
	}

	private LinkedNode<String> findbegin(LinkedNode<String> head)
	{
		LinkedNode<String> p1 = head;
		LinkedNode<String> p2 = findmeet(head);

		while (p2 != p1)
		{
			p2 = p2.next;
			p1 = p1.next;
		}
		return p2;
	}

	static class LinkedNode<T>
	{
		LinkedNode<T> next;
		T data;

		public LinkedNode()
		{
			this.next = null;
			this.data = null;
		}

		public LinkedNode(T data)
		{
			this.data = data;
		}
	}
}
