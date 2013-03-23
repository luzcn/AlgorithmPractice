package CareerCup.LinkedList;

import AlgorithmDataStructure.ListNode;

/**
 * print the linked list in reverse order without using stack
 * 
 * @author annie
 * 
 * @date Feb 6, 2013
 */
public class PrintListReversely
{
	public void printListInReverseOrder(ListNode head)
	{
		if (head == null)
			return;
		if (head.next == null)
			System.out.println(head.val);

		printRec(head);
	}

	public void printRec(ListNode head)
	{
		if (head == null)
			return;

		printRec(head.next);
		System.out.println(head.val);

	}

	public static void main(String[] args)
	{
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(1);
		ListNode n4 = new ListNode(2);
		ListNode n5 = new ListNode(1);
		ListNode n6 = new ListNode(1);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = null;
	}

}
